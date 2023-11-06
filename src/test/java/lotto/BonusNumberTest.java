package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 로또_보너스_번호_중복_예외처리() {
        assertThatThrownBy(() -> new BonusNumber(List.of(1,2,3,4,5,6),"1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_번호_숫자_예외처리() {
        assertThatThrownBy(() -> new BonusNumber(List.of(1,2,3,4,5,6),"abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_번호_숫자_공백처리() {
        assertThatThrownBy(() -> new BonusNumber(List.of(1,2,3,4,5,6)," "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}