package lotto.model;

import static lotto.common.Constant.MATCH_COUNT_FIVE;
import static lotto.common.Constant.MATCH_COUNT_FOUR;
import static lotto.common.Constant.MATCH_COUNT_SIX;
import static lotto.common.Constant.MATCH_COUNT_THREE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    private MainNumbers mainNumbers;

    @BeforeEach
    void setUp() {
        mainNumbers = MainNumbers.from(List.of("1", "2", "3", "4", "5", "6"));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void throwExceptionWhenLottoHasOverSize() {
        assertThatThrownBy(() -> Lotto.issue(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenLottoHasDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.issue(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호와의 일치 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForMatchingCount")
    void countMatchingNumbersCorrectly(List<Integer> lottoNumbers, int expectedMatchCount) {
        Lotto lotto = Lotto.issue(lottoNumbers);
        int actualMatchCount = lotto.countMatchingNumbers(mainNumbers);

        assertEquals(expectedMatchCount, actualMatchCount);
    }

    private static Stream<Arguments> provideLottoNumbersForMatchingCount() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 10, 11, 12), MATCH_COUNT_THREE),
                arguments(List.of(1, 2, 3, 4, 10, 11), MATCH_COUNT_FOUR),
                arguments(List.of(1, 2, 3, 4, 5, 10), MATCH_COUNT_FIVE),
                arguments(List.of(1, 2, 3, 4, 5, 6), MATCH_COUNT_SIX)
        );
    }

    @DisplayName("로또 번호 중 보너스 번호와 일치하는 번호가 있는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void checkForBonusNumberMatch(String number) {
        Lotto lotto = Lotto.issue(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(number);

        assertTrue(lotto.hasBonusNumber(bonusNumber));
    }
}