package lotto.contoller;

import lotto.Lotto;
import lotto.domain.Judgement;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        OutputView outputView = new OutputView();
        int money = inputMoney();
        System.out.println();
        List<Lotto> lottos = outputView.printLottoNumber(money);
        System.out.println();
        List<Integer> winningNumber = inputLottoWinningNumber();
        int bonusNumber = inputBonusNumber();
        System.out.println();
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumber, bonusNumber);
        Judgement judgement = new Judgement();
        Map<Ranking, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Ranking ranking = judgement.compare(lottoWinningNumber, lotto);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        outputView.printResult(result, money);
    }

    private int inputMoney() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private List<Integer> inputLottoWinningNumber() {
        try {
            return InputView.inputLottoWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoWinningNumber();
        }
    }

    private int inputBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }
}
