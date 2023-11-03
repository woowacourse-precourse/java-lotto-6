package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSystemTest {

    @Nested
    @DisplayName("[LottoSystem] 입력 테스트")
    class LottoSystemSuccessTest {

        @DisplayName("로또 발행이 정상적으로 진행되는 경우를 확인")
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 6})
        void create_로또_발행이_정상적으로_진행되는_꼉우를_확인(int count) {
            assertThatNoException().isThrownBy(()
                    -> LottoSystem.of(count));
        }
    }

    @Nested
    @DisplayName("[LottoSystem] 기능 테스트")
    class LottoSystemUnitTest {

        @Test
        @DisplayName("발행한 로또 리스트를 정상적으로 반환하는지 확인")
        void toString_발행한_로또_리스트를_정상적으로_반환하는지_확인() {
            int count = 8;

            LottoSystem lottoSystem = LottoSystem.of(count);
            List<String> result = lottoSystem.receiveLotteriesInfo();

            assertThat(result.size()).isEqualTo(count);
        }
    }
}