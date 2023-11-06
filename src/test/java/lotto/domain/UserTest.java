package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UserTest {
    User user = new User();

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2500","3200","16220","87799","5438219"})
    void inputAmountTest(String input) {
        assertThatThrownBy(() -> user.countLottoTicketIssues(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력하세요.");
    }

    @DisplayName("시도 횟수 구하는 메서드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000,2","3000,3","17000,17","199000,199","145000,145"})
    void inputMoneyTest(String input, int count) {
        int result = user.countLottoTicketIssues(input);
        assertThat(result).isEqualTo(count);
    }

    @Test
    void duplicatedInputTest() {
        String[] selectedNumbers = {"1","1","2","3","4","5"};
        assertThatThrownBy(() -> user.checkDuplicated(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
    }

    @Test
    void inputNumbersLengthTest() {
        String[] selectedNumbers = {"5","6","7","8","2","17","43","24","35"};
        assertThatThrownBy(() ->  user.checkNumbersLength(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @DisplayName("숫자가 맞는지 검증하는 메서드 테스트")
    @Test
    void isNumberTest(String input) {
        String[] selectedNumbers = {"5","6","7","8","@","17","43","24","35"};
        assertThatThrownBy(() ->  user.isNumber(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");

    }

    @DisplayName("입력값 범위(1~45) 확인 테스트")
    @Test
    void checkNumberRange() {
        List<Integer> numbers = Arrays.asList(3,5,45,0,23,30);
        assertThatThrownBy(() ->   user.checkNumbersRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 값을 선택하세요.");

    }
}