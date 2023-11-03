package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {

    static Lotto winningLotto;
    static int bonusNumber;
    static LottoBundle bundle = new LottoBundle();

    public static void main(String[] args) {
        makeLottoBundle();
        showBundle();
        makeWinningLotto();
        setBonusNumber();

        Map<String, Integer> result = bundle.result(winningLotto, bonusNumber);
        float rate = getRate(result);

        View.showResult(result, rate);
    }

    private static float getRate(Map<String, Integer> result) {
        float rate = 0;
        float cost = bundle.getSize() * Config.UNIT;
        rate += result.getOrDefault("3", 0) * 5000;
        rate += result.getOrDefault("4", 0) * 50000;
        rate += result.getOrDefault("5", 0) * 1500000;
        rate += result.getOrDefault("5+", 0) * 30000000;
        rate += result.getOrDefault("6", 0) * 2000000000;
        rate = (rate / cost) * 100;
        return rate;
    }

    private static void setBonusNumber() {
        String inputBonusNumber = View.askBonusNumber(winningLotto);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        System.out.println();
    }

    private static void makeWinningLotto() {
        String inputWinningNumber = View.askWinningNumber();
        List<Integer> winningNumber = Arrays.stream(inputWinningNumber.split(",")).map(Integer::parseInt).toList();
        winningLotto = new Lotto(winningNumber);
        System.out.println();
    }

    private static void showBundle() {
        View.showBundle(bundle.getBundle());
        System.out.println();
    }

    private static void makeLottoBundle() {
        String inputPrice = View.askPrice(Config.UNIT);
        bundle.makeLotto(inputPrice);
        System.out.println();
    }
}