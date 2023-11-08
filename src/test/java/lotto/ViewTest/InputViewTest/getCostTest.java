package lotto.ViewTest.InputViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class getCostTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("음수의 금액이 들어오면 [ERROR]를 출력한 후 다시 입력을 받습니다.")
    @Test
    public void throwExceptionWhenMinusValueCame()
    {
        run("-1000", "1000");
        assertThat(output()).contains(ERROR_MESSAGE, "1000");
    }

    @DisplayName("1000으로 나누어지지 않는 금액이 들어오면 [ERROR]를 출력한 후 입력을 다시 받습니다.")
    @Test
    public void throwExceptionNotMultiplyOfThousands()
    {
        run("1234", "1000");
        assertThat(output()).contains(ERROR_MESSAGE, "1000");
    }

    @DisplayName("숫자가 아닌 금액이 들어오면 [ERROR]를 출력한 후 다시 값을 받습니다.")
    @Test
    public void throwExceptionWithStringValue()
    {
        run("abcd", "1000");
        assertThat(output()).contains(ERROR_MESSAGE, "1000");
    }

    @Override
    public void runMain()
    {
        System.out.println(new InputView().getCost());
    }
}
