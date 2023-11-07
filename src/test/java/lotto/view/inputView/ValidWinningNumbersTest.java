package lotto.view.inputView;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.Validation;
import lotto.utils.ValidationImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidWinningNumbersTest {

    @DisplayName("당첨 번호 입력에 숫자와 쉼표 이외 문자가 있으면 false 를 반환한다.")
    @Test
    void test1() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,(,d,asd,29";
        assertThat(validation.isValidWinningNumbers(input)).isFalse();
    }

    @DisplayName("당첨 번호 입력에 숫자와 쉼표만으로 이루어져 있으면 true 를 반환한다.")
    @Test
    void test2() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,5";
        assertThat(validation.isValidWinningNumbers(input)).isTrue();
    }

    @DisplayName("쉼표 사이에 숫자가 없으면 false 를 반환한다.")
    @Test
    void test3() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,5,,999,";
        assertThat(validation.isValidWinningNumbers(input)).isFalse();
    }

    @DisplayName("1보다 작으면 false 를 반환한다.")
    @Test
    void test4() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,-1";
        assertThat(validation.isValidWinningNumbers(input)).isFalse();
    }

    @DisplayName("45보다 크면 false 를 반환한다.")
    @Test
    void test5() {
        Validation validation = new ValidationImpl();
        String input = "1,2,3,4,99";
        assertThat(validation.isValidWinningNumbers(input)).isFalse();
    }


}
