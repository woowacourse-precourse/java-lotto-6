package view;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorCode;
import domain.Lotto;
import java.util.List;

public class BonusBallInput {

    private final String BONUS_BALL_WORD = "보너스 번호를 입력해 주세요.";

    private int bonusBall;

    public void bonusBallInput(Lotto balls) {
        System.out.println(BONUS_BALL_WORD);
        String bonusBall = Console.readLine();
        validationBonusBall(balls.getNumbers(), bonusBall);
    }

    private void validationBonusBall(List<Integer> balls, String bonusBall) {
        try {
            this.bonusBall = Integer.parseInt(bonusBall);
            if (this.bonusBall < 1 || this.bonusBall > 45) {
                throw new IllegalArgumentException(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
            }
            if (balls.contains(this.bonusBall)) {
                throw new IllegalArgumentException(ErrorCode.BONUS_BALL_DUPLICATE.getErrorMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println(ErrorCode.BALL_NOT_NUMBER.getErrorMessage());
            bonusBallInput(new Lotto(balls));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusBallInput(new Lotto(balls));
        }
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
