package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.replaceAll;

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
