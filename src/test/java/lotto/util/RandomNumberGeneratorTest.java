package lotto.util;

import static lotto.config.LottoConfig.LOTTO_NUMBER_AMOUNT_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Nested
    @DisplayName("발매 로또 번호 랜덤 생성에 대한 테스트")
    class create {
        @DisplayName("모든 테스트 통과")
        @Test
        void success() {
            success_NumberRange();
            success_NumberAmount();
        }

        @DisplayName("랜덤 생성된 번호가 최소 최대 범위를 벗어나지 않으면 통과")
        @Test
        void success_NumberRange() {
            for (int i = 0; i < 100; i++) {
                // given
                List<Integer> numbers = RandomNumberGenerator.generate();
                int min = Collections.min(numbers);
                int max = Collections.max(numbers);
                // when, then
                assertThat(min).isGreaterThanOrEqualTo(LOTTO_NUMBER_MIN.getValue());
                assertThat(max).isLessThanOrEqualTo(LOTTO_NUMBER_MAX.getValue());
            }
        }

        @DisplayName("랜덤 생성된 번호가 6개이면 통과")
        @Test
        void success_NumberAmount() {
            for (int i = 0; i < 100; i++) {
                // given
                List<Integer> numbers = RandomNumberGenerator.generate();
                int length = numbers.size();
                //when, then
                assertThat(length).isEqualTo(LOTTO_NUMBER_AMOUNT_MAX.getValue());
            }
        }
    }
}