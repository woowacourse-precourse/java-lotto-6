package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private WinningLotto winningLotto;

    private static final List<Integer> FIRST_PLACE = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> SECOND_PLACE = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> THIRD_PLACE = List.of(1, 2, 3, 4, 5, 9);
    private static final List<Integer> FOURTH_PLACE = List.of(1, 2, 3, 4, 9, 10);
    private static final List<Integer> FIFTH_PLACE = List.of(1, 2, 3, 8, 9, 7);

    private static final List<List<Integer>> NUMBERS = List.of(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE,
            FIFTH_PLACE);
    private static final List<Integer> PLACE_MATCHES = List.of(6, 5, 5, 4, 3);
    private static final List<Boolean> BONUS_MATCHES = List.of(false, true, false, false, true);

    private static final List<Integer> BONUS_INCLUDED = List.of(7, 8, 9, 10, 11, 12);
    private static final List<Integer> BONUS_EXCLUDED = List.of(8, 9, 10, 11, 12, 13);

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(7);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨번호와 일치하는 번호의 개수를 반환한다.")
    @Test
    void winningLottoNumberMatchesTest() {
        for (int i = 0; i < 4; i++) {
            // given
            List<Integer> numbers = NUMBERS.get(i);
            int matchAnswer = PLACE_MATCHES.get(i);

            // when
            int matchCount = winningLotto.numberMatches(numbers);

            // then
            assertThat(matchCount).isEqualTo(matchAnswer);
        }
    }

    @DisplayName("보너스 번호가 일치하는지 여부를 반환한다")
    @Test
    void validateBonusNumberTest() {
        for (int i = 0; i < 4; i++) {
            // given
            List<Integer> numbers = NUMBERS.get(i);
            boolean matchAnswer = BONUS_MATCHES.get(i);

            // when
            boolean isBonusMatches = winningLotto.isBonusMatches(numbers);

            // then
            assertThat(isBonusMatches).isEqualTo(matchAnswer);
        }
    }
}