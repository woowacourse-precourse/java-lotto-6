package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputWinningNumberTest extends NsTest {
    @DisplayName("당첨 로또 번호 중 공백이 있는 경우 예외가 발생한다.")
    @Test
    void inputNumberBlank() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4, ,6");
            assertThat(output()).contains(ErrorMessage.NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("당첨 로또 번호 중 숫자가 아닌 항목이 있는 경우 예외가 발생한다.")
    @Test
    void inputNotNumericInput() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,a,6");
            assertThat(output()).contains(ErrorMessage.NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("당첨 로또 번호를 6개 미만 입력한 경우 예외가 발생한다.")
    @Test
    void inputUnderProperLengthOfWinningNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)));
    }

    @DisplayName("당첨 로또 번호를 6개 초과 입력한 경우 예외가 발생한다.")
    @Test
    void inputOverProperLengthOfWinningNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("당첨 로또 번호 중 1 미만의 수가 있는 경우 예외가 발생한다.")
    @Test
    void inputNumberUnderMin() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)));
    }

    @DisplayName("당첨 로또 번호 중 45를 초과한 수가 있는 경우 예외가 발생한다.")
    @Test
    void inputNumberOverMax() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
    }

    @DisplayName("당첨 로또 번호 중 중복된 수가 있는 경우 예외가 발생한다.")
    @Test
    void inputDuplicateNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
