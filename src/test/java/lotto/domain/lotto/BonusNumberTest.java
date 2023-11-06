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
    @DisplayName("보너스 번호가 1 부터 45 사이가 아니라면 예외")
    @ValueSource(ints = {0, 46})
    void When_CreateBonusNumber_Expect_Exception(int number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1부터 45 사이라면 예외가 발생하지 않고 생성 성공")
    @ValueSource(ints = {1, 25, 45})
    void When_CreateBonusNumber_Expect_DoesNotThrow(int number) {
        assertDoesNotThrow(() -> new BonusNumber(number));
    }

    @ParameterizedTest(name = "BonusNumber 숫자 : {0}, BonusNumber에게 전달 될 숫자: {1}, 결과 : {2}")
    @DisplayName("BonusNumber가 number를 가지고 있다면 True 없다면 False")
    @CsvSource(value = {"1,1,true", "1,2,false"})
    void 같은_숫자를_가지고_있는지_여부_테스트(int number, int otherNumber, boolean expected) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);

        // when
        boolean hasSameNumber = bonusNumber.hasSameNumber(otherNumber);

        // then
        Assertions.assertThat(hasSameNumber).isEqualTo(expected);
    }

}