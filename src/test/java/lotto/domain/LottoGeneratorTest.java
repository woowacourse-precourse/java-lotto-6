package lotto.domain;

import lotto.configure.DomainConfiguration;
import lotto.configure.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoGeneratorTest {

    @Test
    void testCalculateNumOfLotto_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoGenerator.calculateNumOfLotto(DomainConfiguration.PRICE_OF_LOTTO + 1))
                .withMessageContaining(ErrorMessages.PURCHASE_NUMBER_IS_NOT_MULTIPLE_OF_1000.get());
    }

    @Test
    void testCalculateNumOfLotto_noException() {
        Map<Integer, Integer> testCasesAndExpected = Map.of(
                0, 0,
                1000, 1,
                3000, 3,
                8000, 8
        );

        testCasesAndExpected.forEach((price, num) ->
                assertThat(LottoGenerator.calculateNumOfLotto(price)).isEqualTo(num));
    }

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