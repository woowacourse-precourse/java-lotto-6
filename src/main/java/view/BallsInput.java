package view;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorCode;
import java.util.ArrayList;
import java.util.List;

public class BallsInput {

    private final String ballsWord = "당첨 번호를 입력해 주세요.";

    private List<Integer> numberBalls;

    public List<Integer> getNumberBalls() {
        return numberBalls;
    }

    public void ballsInput() {
        System.out.println(ballsWord);
        String[] balls = Console.readLine().split(",");
        validationBalls(balls);
    }

    private void validationBalls(String[] balls) {
        checkBallsSize(balls);
        checkBallsDuplication(balls);
    }

    private void checkBallsSize(String[] balls) {
        try {
            if (balls.length != 6) {
                throw new IllegalArgumentException(ErrorCode.BALLS_NOT_SIX.getErrorMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ballsInput();
        }
    }

    private void checkBallsDuplication(String[] balls) {
        this.numberBalls = new ArrayList<>();
        try {
            for (String ball : balls) {
                int ballNumber = Integer.parseInt(ball);
                if (ballNumber < 1 || ballNumber > 45) {
                    throw new IllegalArgumentException(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
                }
                if (this.numberBalls.contains(ballNumber)) {
                    throw new IllegalArgumentException(ErrorCode.BALL_DUPLICATE.getErrorMessage());
                } else {
                    this.numberBalls.add(ballNumber);
                }
            }
        } catch (NumberFormatException e){
            System.out.println(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
            ballsInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ballsInput();
        }
    }

}
