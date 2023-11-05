package lotto;

import lotto.model.Lotto;
import lotto.model.LottoResult;
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

    @DisplayName("로또 번호에 중복된 숫자의 범위가 아니면 예외가 발생한다. : under")
    @Test
    void createLottoByRangeOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 80)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자의 범위가 아니면 예외가 발생한다. : over")
    @Test
    void createLottoByRangeUnderNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 6")
    @Test
    void compareLottoWithGivenLottoSix() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(LottoResult.SIX_MATCHES);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 5")
    @Test
    void compareLottoWithGivenLottoFive() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(LottoResult.FIVE_MATCHES);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 4")
    @Test
    void compareLottoWithGivenLottoFour() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 3, 4, 8, 7));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(LottoResult.FOUR_MATCHES);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 3")
    @Test
    void compareLottoWithGivenLottoThree() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 3, 7, 12, 9));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(LottoResult.THREE_MATCHES);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 2")
    @Test
    void compareLottoWithGivenLottoUnder() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(LottoResult.UNDER_THREE);
    }
    @DisplayName("로또 번호랑 보너스 번호를 비교를 한다. : 5개 일치인 경우")
    @Test
    void compareLottoWithGivenLottoFiveBonus() {
        Lotto userLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto answerLotto =  new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 10;
        assertThat(userLotto.matchUp(answerLotto,bonusNumber)).isEqualTo(LottoResult.FIVE_PLUS_BONUS);
    }


}