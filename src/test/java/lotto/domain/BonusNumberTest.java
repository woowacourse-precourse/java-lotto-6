package lotto.domain;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;
import static lotto.settings.ErrorMessage.INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    static List<Integer> numbers;
    static Lotto lotto;

    @BeforeAll
    public static void start(){
        numbers = new ArrayList<>(Arrays.asList(4,36,2,6,7,11));
        lotto = new Lotto(numbers);
    }

    @DisplayName("보너스번호는 1~45사이에 숫자를 중복없이 뽑아야 정상적으로 저장된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1","45,45"})
    void validateRange(int correctNum, int expected) {
        BonusNumber bonusNumber = BonusNumber.from(lotto, correctNum);
        assertThat(bonusNumber.getNumber()).isEqualTo(expected);
    }

    @DisplayName("보너스번호에 1~45를 벗어난 숫자를 뽑는다면 오류가 발생합니다")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void validateSmallNumber(int inpunt) {
        assertThatThrownBy(()-> BonusNumber.from(lotto, inpunt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    @DisplayName("보너스번호가 당첨번호에 있는 번호라면 오류가 발생합니다.")
    @Test
    void validateBonusNumInLotto() {
        // given
        int duplicateNum = 2;

        // when // then
        assertThatThrownBy(()-> BonusNumber.from(lotto, duplicateNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUM.getMessage());
    }
}