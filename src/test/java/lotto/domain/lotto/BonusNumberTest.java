package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 1부터 45 사이가 아니라면 예외")
    @ValueSource(ints = {0, 46})
    void 보너스번호_생성_예외(int number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1부터 45 사이라면 생성 성공")
    @ValueSource(ints = {1, 25, 45})
    void 보너스번호_생성_성공(int number) {
        assertDoesNotThrow(() -> new BonusNumber(number));
        Assertions.assertThat(new BonusNumber(number).getNumber()).isEqualTo(number);
    }


    @ParameterizedTest
    @DisplayName("BonusNumber가 number를 가지고 있는지 여부 테스트")
    @CsvSource(value = {"1,1,true", "1,2,false"})
    void bonusNumber(int number, int otherNumber, boolean expected) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);

        // when
        boolean hasSameNumber = bonusNumber.hasSameNumber(otherNumber);

        // then
        Assertions.assertThat(hasSameNumber).isEqualTo(expected);
    }

}