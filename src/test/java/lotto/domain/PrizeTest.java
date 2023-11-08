package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PrizeTest {

    @DisplayName("매칭번호 개수와 보너스번호 일치 여부에 따라 적절한 상금을 반환한다")
    @Test
    void getPrize() {
        assertThat(Prize.FIRST).isEqualTo(Prize.getPrize(6, false));
        assertThat(Prize.SECOND).isEqualTo(Prize.getPrize(5, true));
        assertThat(Prize.THIRD).isEqualTo(Prize.getPrize(5, false));
        assertThat(Prize.FOURTH).isEqualTo(Prize.getPrize(4, false));
        assertThat(Prize.FIFTH).isEqualTo(Prize.getPrize(3, false));
        assertThat(Prize.NO_PRIZE).isEqualTo(Prize.getPrize(2, false));
    }

    @DisplayName("상금과 매칭번호 개수가 유효하지 않은 값인 경우 예외가 발생한다.")
    @Test
    void validatePrizeMoneyAndMatchCount() {
        assertThatThrownBy(() -> Prize.FIRST.validate(-1, 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Prize.FIRST.validate(1000000, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}