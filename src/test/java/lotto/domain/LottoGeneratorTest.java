package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.configure.DomainConfiguration;
import lotto.configure.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LottoGeneratorTest {

    @DisplayName("파라미터로 전달된 값에 따라 다른 길이의 리스트가 반환된다.")
    @Test
    void generateLotto() {
        Map<Integer, Integer> testCases = Map.of(
                0, 0,
                1, 1,
                3, 3,
                8, 8
        );

        testCases.keySet().forEach((k) -> {
            Integer numOfLotto = testCases.get(k);
            assertThat(LottoGenerator.generate(k).size()).isEqualTo(numOfLotto);
        });
    }
}