package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {
    @DisplayName("랜덤 숫자들 생성 테스트")
    @Test
    void generateRandomNumbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            assertThat(
                LottoNumbersGenerator.generate()
            ).isEqualTo(List.of(3,4,25,32,34,45));
        },
                List.of(3,4,25,32,34,45)
        )
        ;
    }
}