package lotto.domain;

import static lotto.domain.constant.LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED;
import static lotto.domain.constant.LottoPrizes.FIVE_NUMBER_MATCHED;
import static lotto.domain.constant.LottoPrizes.FOUR_NUMBERS_MATCHED;
import static lotto.domain.constant.LottoPrizes.SIX_NUMBER_MATCHED;
import static lotto.domain.constant.LottoPrizes.THREE_NUMBERS_MATCHED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.constant.LottoPrizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        // 당첨 번호는 1,2,3,4,5,6 보너스 번호는 7로 설정
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("한 개의 로또 당첨 여부를 정확하게 반환하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void compare(String testName, List<Integer> numbers, LottoPrizes expectedPrize) {
        Lotto lotto = new Lotto(numbers);
        LottoPrizes actual = winningLotto.compare(lotto);

        assertThat(actual).isEqualTo(expectedPrize);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("3개의 숫자를 맞춘 경우", List.of(1, 2, 3, 8, 9, 10), THREE_NUMBERS_MATCHED),
                arguments("4개의 숫자를 맞춘 경우", List.of(1, 2, 3, 4, 9, 10), FOUR_NUMBERS_MATCHED),
                arguments("5개의 숫자를 맞춘 경우", List.of(1, 2, 3, 4, 5, 9), FIVE_NUMBER_MATCHED),
                arguments("5개의 숫자와 보너스 숫자를 맞춘 경우", List.of(1, 2, 3, 4, 5, 7), FIVE_NUMBER_AND_BONUS_MATCHED),
                arguments("6개의 숫자를 맞춘 경우", List.of(1, 2, 3, 4, 5, 6), SIX_NUMBER_MATCHED)
        );
    }
}