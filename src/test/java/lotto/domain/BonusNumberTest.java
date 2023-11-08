package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 이미 선언된 번호라면 예외가 발생한다")
    void 중복번호_로또_Test() throws Exception {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumber.getBonusNumber(1, list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 범위가 초과되면 예외가 발생한다")
    void 범위초과_로또_Test() throws Exception {
        //given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        //when

        //then
        assertThatThrownBy(() -> BonusNumber.getBonusNumber(0, list))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BonusNumber.getBonusNumber(46, list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}