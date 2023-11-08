package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.newInstance(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자의 범위가 아니면 예외가 발생한다. : under")
    @Test
    void createLottoByRangeOverNumber() {
        assertThatThrownBy(() -> Lotto.newInstance(List.of(1, 2, 3, 4, 5, 80)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자의 범위가 아니면 예외가 발생한다. : over")
    @Test
    void createLottoByRangeUnderNumber() {
        assertThatThrownBy(() -> Lotto.newInstance(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 6")
    @Test
    void compareLottoWithGivenLottoSix() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(6);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 5")
    @Test
    void compareLottoWithGivenLottoFive() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 7));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(5);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 4")
    @Test
    void compareLottoWithGivenLottoFour() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 8, 7));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(4);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 3")
    @Test
    void compareLottoWithGivenLottoThree() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 3, 7, 12, 9));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(3);
    }
    @DisplayName("로또 번호 끼리 비교를 한다. : 2")
    @Test
    void compareLottoWithGivenLottoUnder() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 7, 8, 9, 10));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        assertThat(answerLotto.matchUp(userLotto)).isEqualTo(2);
    }
    @DisplayName("로또 번호랑 보너스 번호를 비교를 한다. : 5개 일치인 경우")
    @Test
    void compareLottoWithGivenLottoFiveBonus() {
        Lotto userLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 10));
        Lotto answerLotto =  Lotto.newInstance(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 10;
        Integer countOfBall = userLotto.matchUp(answerLotto);
        PrizeOption result= PrizeOption.matchUp(countOfBall,userLotto,bonusNumber);
        assertThat(result).isEqualTo(PrizeOption.FIVE_PLUS_BONUS);
    }


}