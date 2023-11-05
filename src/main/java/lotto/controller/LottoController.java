package lotto.controller;

import static lotto.view.ExceptionView.printException;
import static lotto.view.LottoInputView.getLottoWinningNumber;
import static lotto.view.LottoInputView.getPurchaseAmount;
import static lotto.view.LottoOutputView.printPurchaseAmount;
import static lotto.view.LottoOutputView.printPurchaseLotto;
import static lotto.view.LottoOutputView.printWinningNumber;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWallet;
import lotto.model.LottoWinningNumbers;
import lotto.model.Money;
import lotto.service.LottoService;
import lotto.service.LottoWalletService;

public class LottoController {

    private final LottoService lottoService;
    private final LottoWalletService lottoWalletService;

    public LottoController() { // 초기화
        this.lottoService = new LottoService();
        this.lottoWalletService = new LottoWalletService();
    }

    /**
     * 로또 기능을 시작한다. 로또 구매, 로또 번호 입력, 로또 당첨 결과
     */
    public void run() {
        buyLotto();
        getLottoWinningAmount(); // 당첨 번호 가져오고, 서비스에 전달
    }

    /**
     * 사용자로부터 당첨 번호를 받는다.
     */
    private void getLottoWinningAmount() {
        printWinningNumber();
        LottoWinningNumbers winningNumbers = getLottoWinningNumbers();

        // 지갑에서 계산할 수 있도록 저장
        lottoWalletService.saveRecentWinningNumbers(winningNumbers);
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
     * 사용자로부터 구매 금액을 입력받고, 로또를 구매하고, 지갑에 저장한다.
     */
    private void buyLotto() {
        while (true) {
            try {
                Money money = getAmount();
                List<Lotto> lottos = lottoService.buyLottos(money);
                lottoWalletService.saveLottos(new LottoWallet(lottos));

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
        printPurchaseAmount();

        Money coin = new Money(getPurchaseAmount());
        lottoService.validateUnit(coin);

        return coin;
    }

}
