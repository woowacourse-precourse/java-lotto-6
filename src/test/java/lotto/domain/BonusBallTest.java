package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallTest {

    @DisplayName("보너스 공의 범위가 로또 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusBallNumberisOutOfRange() {
        assertThatThrownBy(() -> BonusBall.valueOf(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 공의 숫자가 로또 번호화 중복이 된다면 true를, 중복이 안된다면 false를 반환한다.")
    @Test
    void BonusBallNumberDuplicateCheck() {
        BonusBall bonusBall = BonusBall.valueOf(34);

        assertAll(
                () -> assertThat(bonusBall.contains(List.of(30, 31, 32, 33, 34, 35))).isTrue(),
                () -> assertThat(bonusBall.contains(List.of(1,2,3,4,5,6))).isFalse()
        );


    }

}