package lotto.game;

import java.util.List;
import java.util.Map;

import lotto.common.ErrorType;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningRank;
import lotto.provider.LottoInputProvider;
import lotto.provider.LottoOutputProvider;
import lotto.service.LottoService;

public class LottoGame {

	private final LottoInputProvider lottoInputProvider;
	private final LottoOutputProvider lottoOutputProvider;
	private final LottoService lottoService;

	public LottoGame(LottoInputProvider lottoInputProvider, LottoOutputProvider lottoOutputProvider,
		LottoService lottoService) {
		this.lottoInputProvider = lottoInputProvider;
		this.lottoOutputProvider = lottoOutputProvider;
		this.lottoService = lottoService;
	}

	public void start() {

		int price = inputPrice();
		Customer customer = new Customer(LottoMachine.sellLotto(price));

		lottoOutputProvider.getOutputBuyLotto(customer.getLottos());

		Lotto winningNumbers = inputWinningNumber();
		int bonusNumber = inputBonusNumber();
		LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);

		List<LottoResult> lottoResults = lottoService.checkWinning(customer.getLottos()
			, lottoMachine.getWinningNumbers()
			, lottoMachine.getBonusNumber());
		Map<WinningRank, Integer> totalStatisticsMap = lottoService.totalStatistics(lottoResults);

		lottoOutputProvider.getOutputTotalStatistics(totalStatisticsMap, price);

	}

	private int inputBonusNumber() {
		try {
			return lottoInputProvider.getInputBonusNumber("보너스 번호를 입력해 주세요.");
		} catch (IllegalArgumentException e) {
			return lottoInputProvider.getInputBonusNumber("올바른 보너스 번호를 입력해 주세요. (당첨 번호와 중복되지 않는 1~45 사이 숫자)");
		}
	}

	private Lotto inputWinningNumber() {
		try {
			return lottoInputProvider.getInputWinningNumber("당첨 번호를 입력해 주세요.");
		} catch (IllegalArgumentException e) {
			return lottoInputProvider.getInputWinningNumber("올바른 당첨 번호를 입력해 주세요. (중복없이 쉼표로 구분해서 1~45 사이 숫자 6개)");
		}
	}

	private int inputPrice() {
		try {
			return lottoInputProvider.getInputPrice("구입금액을 입력해 주세요.");
		} catch (IllegalArgumentException e) {
			return lottoInputProvider.getInputPrice("올바른 구입금액을 입력해 주세요. (1,000원 단위)");
		}
	}
}
