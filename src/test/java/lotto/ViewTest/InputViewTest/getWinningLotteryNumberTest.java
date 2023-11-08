package lotto.ViewTest.InputViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class getWinningLotteryNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("잘못된 범위의 입력을 받은 경우")
    @Test
    public void getWrongRangeOfInput()
    {
        run("1,2,3,4,5,46", "1,2,3,4,5,6");
        assertThat(output()).contains(ERROR_MESSAGE, "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("정수형이 아닌 입력을 받을 경우")
    @Test
    public void getStringTypeInput()
    {
        run("1,2,3,4,5,a", "1,2,3,4,5,6");
        assertThat(output()).contains(ERROR_MESSAGE, "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("잘못된 구분자의 입력을 받는 경우")
    @Test
    public void getWrongSplitInput()
    {
        run("1;2;3;4;5;6", "1,2,3,4,5,6");
        assertThat(output()).contains(ERROR_MESSAGE, "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("짧거나 긴 길이의 입력을 받을 경우")
    @Test
    public void getWrongLengthInput()
    {
        run("1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE, "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("중복된 숫자가 있는 입력을 받는 경우")
    @Test
    public void getOverlappedValueInput()
    {
        run("1,2,3,4,5,5", "1,2,3,4,5,6");
        assertThat(output()).contains(ERROR_MESSAGE, "[1, 2, 3, 4, 5, 6]");
    }

    public void runMain()
    {
        System.out.println(new InputView().getWinningLotteryNumber().toString());
    }
}
