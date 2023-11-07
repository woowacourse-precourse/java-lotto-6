package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {

    @DisplayName("getBonusNumber 메소드 테스트")
    @Nested
    class GetBonusNumber {
        @ParameterizedTest(name = "{0}가 들어왔을 때")
        @CsvSource(value = {"1, 1", "2, 2", "35, 35", "40, 40", "45, 45"})
        void 입력된_보너스번호가_잘_반환되는지_테스트(int target, int expected) {
            BonusNumber bonusNumber = new BonusNumber(target);

            assertThat(bonusNumber.getBonusNumber()).isEqualTo(expected);
        }
    }
}