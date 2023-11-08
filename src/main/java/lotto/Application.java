package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController(new LottoView(), new InputJudgement());
        Integer inputPurchasePrice = lottoController.inputPurchasePrice();
        lottoController.buyLotto(inputPurchasePrice);
        List<Integer> winningNumbers = lottoController.inputWinningNumber();
        Integer bonusNumber = lottoController.inputBonusNumber(winningNumbers);
        lottoController.requestWinningStatistics(winningNumbers, bonusNumber);
    }
}
