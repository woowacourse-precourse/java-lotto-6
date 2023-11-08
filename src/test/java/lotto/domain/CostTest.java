package lotto.domain;

import static lotto.global.exception.ErrorMessage.INVALID_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CostTest {
    @Test
    @DisplayName("정상적으로 비용을 생성한다.")
    public void 비용_생성_테스트() {
        Cost cost = Cost.from(1000);

        assertThat(cost).isNotNull();
    }

    @Test
    @DisplayName("1000원 단위가 아닌 비용을 입력하면 예외를 반환한다.")
    public void 올바르지_않은_단위의_비용_입력_테스트() {
        assertThatThrownBy(() -> Cost.from(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT_ERROR.getMessage());
    }

    @Test
    @DisplayName("비용을 입력했을 때 로또의 개수를 반환한다.")
    public void 로또_개수_반환_테스트() {
        Cost cost = Cost.from(2000);

        assertThat(cost.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("비용과 수익을 통해 수익률을 계산한다.")
    public void 수익률_계산_테스트() {
        Cost cost = Cost.from(2000);
        double earnings = 3000.0;

        assertThat(cost.divided(earnings)).isEqualTo(1.5);
    }
}
