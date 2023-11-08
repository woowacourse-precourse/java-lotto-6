package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 45, 39, 29, 30, 42, 31})
    @DisplayName("보너스번호가 번호 범위에 맞게 들어온 경우")
    void 보너스번호가_번호_범위에_맞게_들어온_경우(int bonusNumber) throws Exception {
        //given
        BonusNumber number = BonusNumber.getInstance(bonusNumber);
        //when
        int actualBonusNumber = number.getBonusNumber();
        //then
        assertThat(actualBonusNumber).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 47, 349, 60, 100})
    @DisplayName("보너스번호가 번호 범위에 벗어난 경우")
    void 보너스번호가_번호_범위에_벗어난_경우(int bonusNumber) throws Exception {
        //given
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumber.getInstance(bonusNumber));
    }

}