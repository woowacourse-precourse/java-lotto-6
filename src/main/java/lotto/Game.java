package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    private final LottoBundle bundle = new LottoBundle();
    private Lotto winningLotto;
    private int bonusNumber;
    private int cost;

    public void run() {
        makeLottoBundle();
        showBundle();
        setWinningLotto();
        setBonusNumber();
        showResult();
    }

    /**
     * 구입 금액을 입력받아서 로또 묶음을 만든다. 올바른 값이 입력될때까지 반복한다.
     */
    private void makeLottoBundle() {
        inputView.showAskPrice();
        while (true) {
            try {
                this.cost = inputView.askNumber();
                this.bundle.makeLotto(this.cost);
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
    private void showBundle() {
        outputView.showBundle(this.bundle);
        System.out.println();
    }

    /**
     * 당첨 번호를 입력받아 당첨 로또를 생성한다. 올바른 값이 입력될때까지 반복한다.
     */
    private void setWinningLotto() {
        inputView.showAskWinningNumbers();
        while (true) {
            try {
                this.winningLotto = new Lotto(inputView.askNumbers());
                System.out.println(winningLotto.toString());
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
    private void setBonusNumber() {
        inputView.showAskBonusNumber();
        while (true) {
            try {
                this.bonusNumber = inputView.askNumber();
                Validation.isInRange(this.bonusNumber, Config.MIN_VALUE, Config.MAX_VALUE);
                Validation.isDuplicate(this.winningLotto, this.bonusNumber);
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 당첨 결과를 계산해서 출력한다.
     */
    private void showResult() {
        Map<Rank, Integer> result = this.bundle.makeResult(this.winningLotto, this.bonusNumber);
        double rate = 0;

        for (Rank rank : result.keySet()) {
            rate += result.getOrDefault(rank, 0) * rank.getPrize();
        }
        rate = (rate / this.cost) * 100;
        outputView.showResult(result, rate);
    }
}