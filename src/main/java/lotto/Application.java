package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    static Lotto winningLotto;
    static int bonusNumber;
    static int cost;
    static LottoBundle bundle = new LottoBundle();

    public static void main(String[] args) {
        makeLottoBundle();
        showBundle();
        makeWinningLotto();
        setBonusNumber();

        Map<String, Integer> result = bundle.result(winningLotto, bonusNumber);
        float rate = getRate(result);

        OutputView.showResult(result, rate);
    }

    private static float getRate(Map<String, Integer> result) {
        float rate = 0;
        rate += result.getOrDefault("3", 0) * 5000;
        rate += result.getOrDefault("4", 0) * 50000;
        rate += result.getOrDefault("5", 0) * 1500000;
        rate += result.getOrDefault("5+", 0) * 30000000;
        rate += result.getOrDefault("6", 0) * 2000000000;
        rate = (rate / cost) * 100;
        return rate;
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