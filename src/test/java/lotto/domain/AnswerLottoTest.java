package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.Rank;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnswerLottoTest {

    @DisplayName("당첨번호와 보너스 번호로 로또 정답을 생성할 수 있다.")
    @Test
    void of() {
        // given
        Lotto mainLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        AnswerLotto answerLotto = AnswerLotto.of(mainLotto, bonusNumber);

        // then
        assertThat(answerLotto)
                .extracting("mainLotto", "bonusNumber")
                .contains(mainLotto, 7);
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되면 안된다.")
    @Test
    void ofByBonusNumberDuplicate() {
        // given
        Lotto mainLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when // then
        assertThatThrownBy(() -> AnswerLotto.of(mainLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호의 범위가 1 ~ 45 이어야한다.")
    @Test
    void ofByBonusNumberOutOfRange() {
        // given
        Lotto mainLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        // when // then
        assertThatThrownBy(() -> AnswerLotto.of(mainLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_RANGE.getMessage());
    }

    @DisplayName("로또 번호의 순위를 추출할 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoProvider")
    void getRank(List<Integer> lotto, Rank targetRank) {
        // given
        AnswerLotto answerLotto = AnswerLotto.of(new Lotto(List.of(1,2,3,4,5,6)), 7);
        Lotto inputLotto = new Lotto(lotto);

        // when
        Rank rank = answerLotto.getRank(inputLotto);

        // then
        assertThat(rank).isEqualTo(targetRank);
    }

    static Stream<Arguments> lottoProvider() {
        return Stream.of(
                arguments(List.of(1, 8, 9, 10, 11, 12), Rank.NONE),
                arguments(List.of(1, 2, 8, 9, 10, 11), Rank.NONE),
                arguments(List.of(1, 2, 3, 8, 9, 10), Rank.FIFTH),
                arguments(List.of(1, 2, 3, 4, 8, 9), Rank.FOURTH),
                arguments(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD),
                arguments(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                arguments(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST)
        );
    }
}