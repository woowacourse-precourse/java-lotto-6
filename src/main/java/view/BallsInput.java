package view;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorCode;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class BallsInput {

    private final String BALLS_WORD = "당첨 번호를 입력해 주세요.";

    private Lotto winningBall;

    public void ballsInput() {
        System.out.println(BALLS_WORD);
        String[] balls = Console.readLine().split(",");
        validationBalls(balls);
    }

    public void validationBalls(String[] balls) {
        List<Integer> temp = new ArrayList<>();
        try {
            if (balls.length != 6) {
                throw new IllegalArgumentException(ErrorCode.BALLS_NOT_SIX.getErrorMessage());
            }
            for (String ball : balls) {
                int ballNumber = Integer.parseInt(ball);
                if (ballNumber < 1 || ballNumber > 45) {
                    throw new IllegalArgumentException(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
                }
                if (temp.contains(ballNumber)) {
                    throw new IllegalArgumentException(ErrorCode.BALL_DUPLICATE.getErrorMessage());
                }
                temp.add(ballNumber);
            }
            winningBall = new Lotto(temp);
        } catch (NumberFormatException e) {
            System.out.println(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
            ballsInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ballsInput();
        }
    }

    public Lotto getWinningBall() {
        return winningBall;
    }
}
