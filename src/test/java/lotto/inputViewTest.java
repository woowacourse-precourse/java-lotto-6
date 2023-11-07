package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import Controller.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class inputViewTest {


    public String inputWinningNumber() {
        return Console.readLine();
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
