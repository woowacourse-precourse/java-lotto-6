package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.dto.WinningStatisticDTO;
import lotto.model.MatchCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MatchCounterTest {
    private MatchCounter matchCounter;

    @BeforeEach
    void reset() {
        matchCounter = new MatchCounter();
    }

    private Object getMatchCounter() {
        try {
            Field field = matchCounter.getClass().getDeclaredField("matchCounter");
            field.setAccessible(true);
            return field.get(matchCounter);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("초기 값은 모두 0 이어야 합니다.")
    @Test
    void checkInitializedValueZero() {
        Map<String, Integer> counter = (Map<String, Integer>) getMatchCounter();

        assertThat(
                counter
                        .values()
                        .stream()
                        .collect(Collectors.toList())
        ).isEqualTo(givenNumbers(0, 0, 0, 0, 0));
    }

    @ParameterizedTest(name = "로또 일치 개수 : {0}, 보너스 일치 개수 : {1}, 반환 키 : {2}")
    @MethodSource("countsAndExpectedKey")
    @DisplayName("일치한 개수에 따라 정해진 키를 반환해야합니다.")
    void checkKeyReturnsByLottoAndBonusCount(Integer lottoCount, Integer bonusCount, String key) {
        assertThat(matchCounter.matchingKeyByCount(lottoCount, bonusCount)).isEqualTo(key);
    }

    static Stream<Arguments> countsAndExpectedKey() {
        return Stream.of(
                Arguments.arguments(0, 0, null),
                Arguments.arguments(1, 0, null),
                Arguments.arguments(2, 0, null),
                Arguments.arguments(3, 0, "three matched"),
                Arguments.arguments(4, 0, "four matched"),
                Arguments.arguments(5, 0, "five matched"),
                Arguments.arguments(5, 1, "five and bonus matched"),
                Arguments.arguments(6, 0, "six matched")
        );
    }

    @ParameterizedTest(name = "입력 키 : {0}, 예상 리스트 : {1}")
    @MethodSource("keyAndExpectedList")
    @DisplayName("키에 대응되는 개수를 증가시켜야 합니다.")
    void checkIncreaseByKey(String key, List<Integer> expected) {
        matchCounter.increaseCountByKey(key);

        Map<String, Integer> counter = (Map<String, Integer>) getMatchCounter();

        assertThat(
                counter
                        .values()
                        .stream()
                        .collect(Collectors.toList())
        ).isEqualTo(expected);
    }

    static Stream<Arguments> keyAndExpectedList() {
        return Stream.of(
                Arguments.arguments(null, givenNumbers(0, 0, 0, 0, 0)),
                Arguments.arguments("three matched", givenNumbers(0, 0, 0, 1, 0)),
                Arguments.arguments("four matched", givenNumbers(1, 0, 0, 0, 0)),
                Arguments.arguments("five matched", givenNumbers(0, 1, 0, 0, 0)),
                Arguments.arguments("five and bonus matched", givenNumbers(0, 0, 0, 0, 1)),
                Arguments.arguments("six matched", givenNumbers(0, 0, 1, 0, 0))
        );
    }

    @DisplayName("저장된 개수에 맞는 Winning statistic DTO 객체를 생성해야 합니다.")
    @Test
    void compareWinningStatisticDTOWithMadeByMatchCounter() {
        matchCounter.increaseCountByKey("three matched");
        matchCounter.increaseCountByKey("three matched");
        matchCounter.increaseCountByKey("four matched");
        matchCounter.increaseCountByKey("five matched");
        matchCounter.increaseCountByKey("five matched");
        matchCounter.increaseCountByKey("five and bonus matched");
        matchCounter.increaseCountByKey("five and bonus matched");
        matchCounter.increaseCountByKey("five and bonus matched");

        WinningStatisticDTO winningStatisticDTO = matchCounter.createWinningStatisticDTO();

        assertThat(winningStatisticDTO.getMatchedThree()).isEqualTo(2);
        assertThat(winningStatisticDTO.getMatchedFour()).isEqualTo(1);
        assertThat(winningStatisticDTO.getMatchedFive()).isEqualTo(2);
        assertThat(winningStatisticDTO.getMatchedFiveAndBonus()).isEqualTo(3);
        assertThat(winningStatisticDTO.getMatchedSix()).isEqualTo(0);
    }

    private static List<Integer> givenNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }
}
