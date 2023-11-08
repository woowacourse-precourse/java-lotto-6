package lotto.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import lotto.configure.DomainConfiguration;
import lotto.configure.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void testGenerateLotto_lengthOfLotto() {
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

    @Test
    void testGenerateLotto_generation() {
        Integer[][] testCases = {
                { 1, 2, 3, 4, 5, 6 },
                { 3, 4, 5, 6, 7, 8 },
                { 10, 12, 14, 16, 18, 20 }
        };
        Assertions.assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> generated = LottoGenerator.generate(3);
                    for (int i = 0; i < testCases.length; i++) {
                        Lotto expected = new Lotto(Arrays.asList(testCases[i]));
                        assertThat(generated.get(i)).isEqualTo(expected);
                    }
                },
                List.of(testCases[0]),
                List.of(testCases[1]),
                List.of(testCases[2])
        );
    }
}