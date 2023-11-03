package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketsTest {

    @Nested
    @DisplayName("[LottoTickets] 입력 테스트")
    class LottoTicketsSuccessTest {

        @DisplayName("로또 발행이 정상적으로 진행되는 경우를 확인")
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 6})
        void create_로또_발행이_정상적으로_진행되는_꼉우를_확인(int count) {
            assertThatNoException().isThrownBy(()
                    -> LottoTickets.of(count));
        }
    }

    @Nested
    @DisplayName("[LottoTickets] 기능 테스트")
    class LottoTicketsUnitTest {

        @Test
        @DisplayName("발행한 로또 리스트를 정상적으로 반환하는지 확인")
        void toString_발행한_로또_리스트를_정상적으로_반환하는지_확인() {
            int count = 8;

            LottoTickets lottoTickets = LottoTickets.of(count);
            List<String> result = lottoTickets.receiveLottoTicketsInfo();

            assertThat(result.size()).isEqualTo(count);
        }
    }
}