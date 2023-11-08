package lotto.model;

import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.ErrorCode.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.BONUS_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @DisplayName("보너스 번호가 1에서 45가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {MIN_RANDOM_NUMBER - 1, MAX_RANDOM_NUMBER + 1})
    void bonusNumberOutOfRange(final int bonus) {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중번된다면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberDuplicateWithWinningLotto(final int bonus) {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    void 로또들의_당첨순위들을_계산한다() {
        final List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 11)),
            new Lotto(List.of(1, 2, 3, 7, 11, 12))
        );
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto lottoChecker = new WinningLotto(winningLotto, 7);

        final LottoResult lottoResult = lottoChecker.checkLottos(lottos);

        final List<String> outputStrings = lottoResult.toOutputStrings();
        Assertions.assertThat(outputStrings).contains("3개 일치 (5,000원) - 1개");
        Assertions.assertThat(outputStrings).contains("4개 일치 (50,000원) - 0개");
        Assertions.assertThat(outputStrings).contains("5개 일치 (1,500,000원) - 1개");
        Assertions.assertThat(outputStrings).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        Assertions.assertThat(outputStrings).contains("6개 일치 (2,000,000,000원) - 0개");
    }

}