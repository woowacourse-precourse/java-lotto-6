package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("랜덤으로 생성한 로또 숫자가 1~45 범위인지 확인")
    @Test
    void checkRandomNumberCorrectRange() {
        assertThat(LottoGenerator.createRandomNumber())
                .allMatch(number -> (number >= 1) && (number <= 45));
    }
}