package lotto.domain;

import static lotto.domain.exception.DomainExceptionCode.ANSWER_LOTTO_AND_BONUS_NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerLottoTest {

    @Test
    void 당첨로또와_다른_로또를_비교할_때_보너스_번호가_등록_되어_있지_않다면_오류가_발생합니다() {
        final var numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> AnswerLotto.of(numbers)
                        .match(new Lotto(numbers)));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨로또에_보너스번호와_일치하는_경우가_있으면_오류가_발생합니다(final int bonusNumber) {
        final var numbers = List.of(1, 2, 3, 4, 5, 6);
        final var answerLotto = AnswerLotto.of(numbers);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> answerLotto.registerBonusNumber(bonusNumber))
                .withMessageContaining(ANSWER_LOTTO_AND_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    void 당첨로또와_다른_로또를_비교해서_결과를_만들어냅니다() {
        final var numbers = List.of(1, 2, 3, 4, 5, 6);

        final var answerLotto = AnswerLotto.of(numbers)
                .registerBonusNumber(7);

        final var matchResult = answerLotto.match(new Lotto(numbers));

        assertAll(
                () -> assertThat(matchResult.ballCount()).isEqualTo(6),
                () -> assertThat(matchResult.matchBonus()).isEqualTo(false)
        );
    }

    @Test
    void _3개의_번호가_일치하면_5등이다() {
        final var matchResult = createMatchResult(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 7, 8, 9),
                4
        );

        assertThat(LottoMatchingTable.of(matchResult)).isEqualTo(LottoMatchingTable.FIFTH);
    }

    @Test
    void _4개의_번호가_일치하면_4등이다() {
        final var matchResult = createMatchResult(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 7, 8),
                5
        );

        assertThat(LottoMatchingTable.of(matchResult)).isEqualTo(LottoMatchingTable.FOURTH);
    }

    @Test
    void _5개의_번호가_일치하면_3등이다() {
        final var matchResult = createMatchResult(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                8
        );
        assertThat(LottoMatchingTable.of(matchResult)).isEqualTo(LottoMatchingTable.THIRD);
    }

    @Test
    void _5개의_번호와_보너스번호가_일치하면_2등이다() {
        final var matchResult = createMatchResult(
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6),
                7
        );
        System.out.println(LottoMatchingTable.of(matchResult));
        assertThat(LottoMatchingTable.of(matchResult)).isEqualTo(LottoMatchingTable.SECOND);
    }

    @Test
    void _6개의_번호가_일치하면_1등이다() {
        final var matchResult = createMatchResult(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                7
        );
        System.out.println(LottoMatchingTable.of(matchResult));
        assertThat(LottoMatchingTable.of(matchResult)).isEqualTo(LottoMatchingTable.FIRST);
    }

    private MatchResult createMatchResult(List<Integer> numbers, List<Integer> answerLottoNumber, int bonusNumber) {
        final var answerLotto = AnswerLotto.of(answerLottoNumber)
                .registerBonusNumber(bonusNumber);
        return answerLotto.match(new Lotto(numbers));

    }
}