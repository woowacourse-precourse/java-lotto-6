package controller;

import domain.Lotto;
import view.BallsInput;
import view.BonusBallInput;
import view.MoneyInput;

public class InputController {

    private static final MoneyInput moneyInput = new MoneyInput();
    private static final BallsInput ballsInput = new BallsInput();
    private static final BonusBallInput bonusBallInput = new BonusBallInput();

    public int inputMoney() {
        moneyInput.moneyInput();
        System.out.println();
        return moneyInput.getMoney();
    }

    public Lotto inputWinningBalls() {
        ballsInput.ballsInput();
        System.out.println();
        return ballsInput.getWinningBall();
    }

    public int inputBonusBall() {
        bonusBallInput.bonusBallInput(ballsInput.getWinningBall());
        System.out.println();
        return bonusBallInput.getBonusBall();
    }
}
