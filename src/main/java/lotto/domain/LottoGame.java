package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.util;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Lottos lottos;
    WinningLottoNumbers winningLottoNumbers;
    Purchase purchase;
    public LottoGame() {

    }

    public void game() {
        purchase = inputPurchase(); // 구매금액 입력

        util.lineBlank();
        outputView.printPurchaseQyantity(purchase.getQuantity());

        // 로또 생성
        lottos = new Lottos(new LottosGenerator(purchase.getQuantity()).generateLottos());

        // 로또 출력
        outputView.printLottoNumbers(lottos);
        util.lineBlank();

        // 당첨번호 입력
        String winningNumber = inputWinningNumbers();
        util.lineBlank();

        // 보너스 번호 입력
        String bonus = inputBonus();
        util.lineBlank();

        //WinningLottoNumbers 생성
        winningLottoNumbers = new WinningLottoNumbers(winningNumber,bonus);

        /*로또 값 비교 로직*/
        List<Rank> rankResult = lottos.matchRanks(winningLottoNumbers);

        // 당첨통계
        outputView.printwinningResultMessage();
        outputView.printResult(rankResult, purchase.getPurchase());
    }

    // 구매금액 입력
    public Purchase inputPurchase() {
        try {
            inputView.printInputPurchaseAmountMessage();
            String purchaseAmount = inputView.inputPurchaseAmount();

            return new Purchase(purchaseAmount);
        } catch (IllegalArgumentException e) {
            return inputPurchase();
        }
    }

    public String inputWinningNumbers() {
        try {
            inputView.printInputWinningNumberMessage();
            return inputView.inputWinningNumbers();
        } catch(IllegalArgumentException e) {
            util.println(e);
            return inputWinningNumbers();
        }
    }

    public String inputBonus() {
        try {
            inputView.printInputBonusNumberMessage();
            return inputView.inputBounsNumber();
        } catch(IllegalArgumentException e) {
            util.println(e);
            return inputBonus();
        }

    }
}
