package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.dto.MatchCounterDTO;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {
    private static final Lotto lotto = new Lotto(givenNumbers(1, 2, 3, 4, 5, 6));
    private static final Bonus bonus = new Bonus(7, lotto);
    private static final WinningLotto winningLotto = new WinningLotto(lotto, bonus);

    @ParameterizedTest(name = "대상 : {0}, 일치 숫자 개수 : {1}, 일치 보너스 개수 : {2}")
    @MethodSource("lottoAndExpectedCount")
    @DisplayName("임의의 로또에 대해 일치하는 개수를 셀 수 있어야 합니다.")
    void countByLotto(Lotto test, Integer expectedCountLotto, Integer expectedCountBonus) {
        MatchCounterDTO matchCounterDTO = winningLotto.countMatchesWholeNumber(test);

        assertThat(matchCounterDTO.getCountLotto()).isEqualTo(expectedCountLotto);
        assertThat(matchCounterDTO.getCountBonus()).isEqualTo(expectedCountBonus);
    }

    static Stream<Arguments> lottoAndExpectedCount() {
        return Stream.of(
                Arguments.arguments(new Lotto(givenNumbers(8, 9, 10, 11, 12, 13)), 0, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 9, 10, 11, 12, 13)), 1, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 10, 11, 12, 13)), 2, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 3, 11, 12, 13)), 3, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 3, 4, 12, 13)), 4, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 3, 4, 5, 13)), 5, 0),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 3, 4, 5, 7)), 5, 1),
                Arguments.arguments(new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)), 6, 0)
        );
    }

    private static List<Integer> givenNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }
}
