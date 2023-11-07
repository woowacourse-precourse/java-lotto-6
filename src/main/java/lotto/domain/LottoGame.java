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
    public LottoGame() {

    }

    public void game() {
        inputView.printInputPurchaseAmountMessage();
        String purchaseAmount = inputView.inputPurchaseAmount();
        int quantity = new Purchase(purchaseAmount).getQuantity();

        util.lineBlank();
        outputView.printPurchaseQyantity(quantity);
        /*로또 값 비교 로직*/

        // 로또 생성
        lottos = new Lottos(new LottosGenerator(quantity).generateLottos());

        // 로또 출력
        outputView.printLottoNumbers(lottos);

        util.lineBlank();

        // 당첨번호 입력
        inputView.printInputWinningNumberMessage();
        String winningNumber = inputView.inputWinningNumbers();

        util.lineBlank();

        // 보너스 번호 입력
        inputView.printInputBonusNumberMessage();
        String bonus = inputView.inputBounsNumber();

        util.lineBlank();

        //WinningLottoNumbers 생성
        winningLottoNumbers = new WinningLottoNumbers(winningNumber,bonus);
        List<Rank> rank = lottos.getResults(winningLottoNumbers);


        // 당첨통계
        outputView.printwinningResultMessage();
        outputView.printResult(rank,Integer.parseInt(purchaseAmount) );
    }
}
