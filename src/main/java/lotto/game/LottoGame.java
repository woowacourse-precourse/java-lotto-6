package lotto.game;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
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
		int price = lottoInputProvider.getInputPrice("구입금액을 입력해 주세요.");
		List<Lotto> lottos = lottoService.purchaseLotto(price);
		lottoOutputProvider.getOutputBuyLotto(lottos);

		Lotto winningNumbers = lottoInputProvider.getInputWinningNumber("당첨 번호를 입력해 주세요.");
		int bonusNumber = lottoInputProvider.getInputBonusNumber("보너스 번호를 입력해 주세요.");

		List<LottoResult> lottoResults = lottoService.checkWinning(lottos, winningNumbers, bonusNumber);
		Map<WinningRank, Integer> totalStatisticsMap = lottoService.totalStatistics(lottoResults);

		lottoOutputProvider.getOutputTotalStatistics(totalStatisticsMap, price);
	}
}
