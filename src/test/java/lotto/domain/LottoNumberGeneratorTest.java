package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @DisplayName("로또 번호 생성 단일 실행")
    @Test
    void generate_ShouldReturnSixNumbers_WithNoDuplicates_AndMeetsNumberSizeRange() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        // when
        List<Integer> numbers = generator.generate();
        // then
        assertThat(numbers)
                .hasSize(LOTTO_NUMBER_COUNT)
                .doesNotHaveDuplicates()
                .allMatch(number -> number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER);
    }

}
