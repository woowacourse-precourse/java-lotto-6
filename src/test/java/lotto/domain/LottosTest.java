package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("구입 금액만큼 발급받은 로또 티켓들을")
public class LottosTest {
    @Nested
    @DisplayName("주어진 숫자(개수)만큼")
    class input_is_lotto_tickets_amount {
        @ParameterizedTest
        @ValueSource(ints = {3, 4, 5, 6})
        @DisplayName("정상적으로 생성한다")
        void create_lottos(int count) {
            assertThat(new Lottos(count).getTotalLottos()).hasSize(count);
        }
    }
}
