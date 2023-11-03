package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    static Lotto winningLotto;
    static int bonusNumber;
    static int cost;
    static double rate;
    static Map<Rank, Integer> result = new HashMap<>();
    static LottoBundle bundle = new LottoBundle();

    public static void main(String[] args) {
        makeLottoBundle();
        showBundle();
        makeWinningLotto();
        setBonusNumber();
        setResult();
        setRate();
        OutputView.showResult(result, rate);
    }

    private static void setResult() {
        result = bundle.result(winningLotto, bonusNumber);
    }

    private static void setRate() {
        for (Rank rank : result.keySet()) {
            rate += result.getOrDefault(rank, 0) * rank.getPrize();
        }
        rate = (rate / cost) * 100;
    }

    private static void setBonusNumber() {
        bonusNumber = InputView.askBonusNumber(winningLotto);
        System.out.println();
    }

    private static void makeWinningLotto() {
        winningLotto = InputView.askWinningNumber();
        System.out.println();
    }

    private static void showBundle() {
        OutputView.showBundle(bundle.getBundle());
        System.out.println();
    }

    private static void makeLottoBundle() {
        cost = InputView.askPrice();
        bundle.makeLotto(cost);
        System.out.println();
    }
}