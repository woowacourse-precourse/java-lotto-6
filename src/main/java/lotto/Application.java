package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final int MIN_VALUE = Config.MIN_VALUE;
    private static final int MAX_VALUE = Config.MAX_VALUE;
    private static final LottoBundle bundle = new LottoBundle();
    private static Lotto winningLotto;
    private static int bonusNumber;
    private static int cost;

    public static void main(String[] args) {
        makeLottoBundle();
        showBundle();
        setWinningLotto();
        setBonusNumber();
        showResult();
    }

    /**
     * 구입 금액을 입력받아서 로또 묶음을 만든다. 올바른 값이 입력될때까지 반복한다.
     */
    private static void makeLottoBundle() {
        InputView.askPrice();
        while (true) {
            try {
                cost = InputView.askNumber();
                bundle.makeLotto(cost);
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 생성된 로또 묶음을 출력한다.
     */
    private static void showBundle() {
        OutputView.showBundle(bundle);
        System.out.println();
    }

    /**
     * 당첨 번호를 입력받아 당첨 로또를 생성한다. 올바른 값이 입력될때까지 반복한다.
     */
    private static void setWinningLotto() {
        InputView.askWinningNumbers();
        while (true) {
            try {
                winningLotto = new Lotto(InputView.askNumbers());
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 보너스 번호를 입력받는다. 올바른 값이 입력될때까지 반복한다.
     */
    private static void setBonusNumber() {
        InputView.askBonusNumber();
        while (true) {
            try {
                bonusNumber = InputView.askNumber();
                Validation.isInRange(bonusNumber, MIN_VALUE, MAX_VALUE);
                Validation.isDuplicate(winningLotto, bonusNumber);
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 당첨 결과를 출력한다.
     */
    private static void showResult() {
        Map<Rank, Integer> result = bundle.result(winningLotto, bonusNumber);
        double rate = 0;

        for (Rank rank : result.keySet()) {
            rate += result.getOrDefault(rank, 0) * rank.getPrize();
        }
        rate = (rate / cost) * 100;
        OutputView.showResult(result, rate);
    }
}