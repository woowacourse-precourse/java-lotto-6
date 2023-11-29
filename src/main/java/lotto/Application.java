package lotto;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.Statistics;
import lotto.ui.InputView;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        List<List<Integer>> lottoNumbers = purchase.process();

        InputView inputView = new InputView();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        new Lotto(winningNumbers);

        int bonusNumber = inputView.inputBonusNumber();
        System.out.println(bonusNumber);

        Statistics statistics = new Statistics(lottoNumbers, winningNumbers, bonusNumber);
        statistics.compareNumber();
    }
}
