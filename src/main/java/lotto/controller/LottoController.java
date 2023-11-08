package lotto.controller;

import static lotto.view.ExceptionView.printException;
import static lotto.view.LottoInputView.getLottoWinningNumber;
import static lotto.view.LottoInputView.getPurchaseAmount;
import static lotto.view.LottoOutputView.printBonusNumber;
import static lotto.view.LottoOutputView.printPurchaseAmount;
import static lotto.view.LottoOutputView.printPurchaseLotto;
import static lotto.view.LottoOutputView.printWinningNumber;
import static lotto.view.LottoOutputView.printWinningStatistics;

import java.util.List;
import lotto.dto.DatabaseDto;
import lotto.dto.LottosCalculateResult;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoWinningNumbers;
import lotto.model.Money;
import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoCalculateService;
import lotto.view.LottoInputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoCalculateService lottoCalculateService;

    public LottoController(DatabaseDto dto) { // 초기화
        this.lottoService = new LottoService(dto.getUserLottoDataRepository());

        UserLottoRepository userLottoRepository = dto.getUserLottoDataRepository();
        LottoWinningRepository lottoWinningRepository = dto.getLottoWinningDataRepository();
        this.lottoCalculateService = new LottoCalculateService(userLottoRepository, lottoWinningRepository);
    }

    /**
     * 로또 당첨 통계 가져오기
     */
    public void getWinningStatistics() {
        LottosCalculateResult result = lottoCalculateService.winningStatistics(); // 서비스에 로또 통계 요청

        printWinningStatistics(result); // 서비스로부터 받은 결과 출력
    }

    /**
     * 사용자로부터 당첨 번호를 받는다.
     */
    public void saveLottoWinningAmount() {
        printWinningNumber();
        LottoWinningNumbers winningNumbers = getLottoWinningNumbers();

        printBonusNumber();
        LottoBonusNumber bonusNumber = getLottoBonusNumber(winningNumbers);

        // 계산할 수 있도록 저장
        lottoCalculateService.saveRecentWinningNumbers(winningNumbers, bonusNumber);
    }

    /**
     * 유저로부터 로또 당첨 보너스 번호를 입력받고, 반환한다.
     *
     * @return 로또 당첨 보너스 번호 객체
     */
    private LottoBonusNumber getLottoBonusNumber(LottoWinningNumbers winningNumbers) {
        while (true) {
            try {
                String number = LottoInputView.getLottoBonusNumber();
                LottoBonusNumber bonusNumber = new LottoBonusNumber(winningNumbers, number);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                printException(e);
            }
        }
    }

    /**
     * 로또 당첨 번호를 받아오고, 반환한다.
     *
     * @return 당첨 로또 객체
     */
    private LottoWinningNumbers getLottoWinningNumbers() {
        while (true) {
            try {
                String input = getLottoWinningNumber();
                LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(input);

                return lottoWinningNumbers;
            } catch (IllegalArgumentException e) {
                printException(e);
            }
        }
    }

    /**
     * 사용자로부터 구매 금액을 입력받고, 로또를 구매하고 출력한다.
     */
    public void buyLotto() {
        printPurchaseAmount();

        while (true) {
            try {
                Money money = getAmount();
                List<Lotto> lottos = lottoService.buyLottos(money);

                printPurchaseLotto(lottos);
                return;
            } catch (IllegalArgumentException e) {
                printException(e);
            }
        }
    }

    /**
     * 사용자로부터 기준에 맞는 구매할 금액을 입력받는다.
     *
     * @return Money 금액
     */
    private Money getAmount() {
        Money coin = new Money(getPurchaseAmount());
        lottoService.validateUnit(coin);

        return coin;
    }

}
