package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("당첨 번호가")
public class WinningNumbersTest {
    @Nested
    @DisplayName("보너스 번호와 중복된다면")
    class is_bonus_number_duplication {
        @Test
        @DisplayName("에러 출력")
        void returns_error() {
            List<LottoNumber> lottoNumbers = Arrays.asList(41, 41, 42, 43, 44, 45)
                    .stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            assertThatThrownBy(
                    () -> new WinningNumbers(new Lotto(lottoNumbers), new LottoNumber(45)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
