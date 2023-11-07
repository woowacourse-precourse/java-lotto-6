package lotto.view.inputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.Validation;
import lotto.utils.ValidationImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidWinningNumbersTest {

    @DisplayName("당첨 번호 입력에 숫자와 쉼표 이외 문자가 있으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void test1() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,(,d,asd,29";
        assertThatThrownBy(() -> validation.isValidWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 갯수는 6개이다.")
    @Test
    void test2() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> validation.isValidWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표 사이에 숫자가 없으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void test3() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,5,,999,";
        assertThatThrownBy(() -> validation.isValidWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 1보다 작으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void test4() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,-1";
        assertThatThrownBy(() -> validation.isValidWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 45보다 크면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void test5() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,99";
        assertThatThrownBy(() -> validation.isValidWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
