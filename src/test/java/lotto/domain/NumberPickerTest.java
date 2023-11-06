package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberPickerTest {

    NumberPicker numberPicker = new NumberPicker();

    @Test
    void duplicatedInputTest() {
        String[] selectedNumbers = {"1","1","2","3","4","5"};
        assertThatThrownBy(() -> numberPicker.checkDuplicated(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
    }

    @Test
    void inputNumbersLengthTest() {
        String[] selectedNumbers = {"5","6","7","8","2","17","43","24","35"};
        assertThatThrownBy(() -> numberPicker.checkNumbersLength(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @DisplayName("입력값이 숫자인지 검증하는 메서드 테스트")
    @Test
    void isNumberTest() {
        String[] selectedNumbers = {"8","@","17","43","24","35"};
        assertThatThrownBy(() -> numberPicker.isNumber(selectedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");

    }

    @DisplayName("6개 번호 입력값 범위(1~45) 확인 테스트")
    @Test
    void checkNumberRange() {
        List<Integer> numbers = Arrays.asList(3,5,45,0,23,30);
        assertThatThrownBy(() -> numberPicker.checkNumbersRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 값을 선택하세요.");

    }

    @ParameterizedTest
    @ValueSource(ints={0,46,52,77,100,2345})
    void checkLottoNumberRangeTest(int num) {
        assertThatThrownBy(() -> numberPicker.checkLottoNumberRange(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 값을 선택하세요.");
    }

    @DisplayName("숫자 6개와 중복인 값이 있는 경우")
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5,6})
    void isValidBonusNumberTest(int num) {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        assertThatThrownBy(() -> numberPicker.checkIsDuplicate(num,winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되는 값은 입력할 수 없습니다.");
    }

    @DisplayName("보너스 1개, 숫자 이외의 값이 입력될 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a","ㄱ","o","@","!"})
    void checkIsBonusNumberTest(String input) {
        assertThatThrownBy(() -> numberPicker.checkIsBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
    }
}