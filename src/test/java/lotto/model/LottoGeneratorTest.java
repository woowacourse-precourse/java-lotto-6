package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 생성 결과 테스트")
class LottoGeneratorTest {
    @Test
    void 최소_지불_금액_테스트() {
        assertThatThrownBy(() -> new LottoGenerator(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 결제 금액은 1,000원 입니다.");
    }

    @Test
    void 지불_금액_단위_테스트() {
        assertThatThrownBy(() -> new LottoGenerator(1008))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위로 결제해주세요.");
    }

    @Test
    void 로또_발행_개수_테스트() {
        assertThat(new LottoGenerator(15000).getLottos().size()).isEqualTo(15);
    }
}