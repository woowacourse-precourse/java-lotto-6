package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 결과를 비교하여 요구 사항는 결과를 반환한다.")
    @Test
    void compareLottoNumWithResultNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Result sixExpected = lotto.match(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(sixExpected).isEqualTo(Result.SIX);

        Result fiveBonusExpected = lotto.match(List.of(1, 2, 3, 4, 5, 13), 6);
        assertThat(fiveBonusExpected).isEqualTo(Result.FIVE_BONUS);

        Result fiveExpected = lotto.match(List.of(1, 2, 3, 4, 5, 13), 7);
        assertThat(fiveExpected).isEqualTo(Result.FIVE);

        Result fourExpected = lotto.match(List.of(1, 2, 3, 4, 9, 13), 6);
        assertThat(fourExpected).isEqualTo(Result.FOUR);

        Result threeExpected = lotto.match(List.of(1, 2, 3, 8, 9, 13), 6);
        assertThat(threeExpected).isEqualTo(Result.THREE);

        Result loseExpected2 = lotto.match(List.of(1, 2, 7, 8, 9, 13), 6);
        assertThat(loseExpected2).isEqualTo(Result.LOSE);

        Result loseExpected1 = lotto.match(List.of(1, 40, 7, 8, 9, 13), 6);
        assertThat(loseExpected1).isEqualTo(Result.LOSE);

        Result loseExpected0 = lotto.match(List.of(41, 40, 7, 8, 9, 13), 6);
        assertThat(loseExpected0).isEqualTo(Result.LOSE);
    }
}