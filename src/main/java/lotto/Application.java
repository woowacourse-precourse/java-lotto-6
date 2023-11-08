package lotto;

import controller.OutputController;
import controller.LottoController;
import domain.Lotto;
import java.util.List;
import controller.InputController;

public class Application {

    private static final InputController inputController = new InputController();
    private static final LottoController lottoController = new LottoController();
    private static final OutputController outputController = new OutputController();

    public static void main(String[] args) {

        // 입력
        int money = inputController.inputMoney();
        List<Lotto> randomLotto = lottoController.createRandomLotto(money);
        Lotto winningBall = inputController.inputWinningBalls();
        int bonusBall = inputController.inputBonusBall();

        // 로또 계산
        int[] answerCount = lottoController.checkWinningLotto(winningBall, bonusBall, randomLotto);

        // 당첨 내역 출력
        outputController.outputLotto(answerCount, money);
    }
}
