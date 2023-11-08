package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("구입 금액이 0일 경우")
    @Test
    void createMoneyByDecimal() {
        assertThatThrownBy(() -> new Asset(2.5D))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 100장 넘게 구매할 경우")
    @Test
    void createMoneyByOverflow() {
        assertThatThrownBy(() -> new Player(new Asset(200000D)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위가 아닐 경우")
    @Test
    void createBonusNumByOutOfRange() {
        assertThatThrownBy(() -> new LottoGame( new Lotto(List.of(1,2,3,4,5,6)), 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위가 아닐 경우")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,45,111)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 모두 일치할 경우 1등입니다.")
    @Test
    void winFirst(){
        Lotto winningNum = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNum = 7;

        Integer result = ticket.matchNumbers(winningNum);
        Boolean bonusMatch = ticket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(result,bonusMatch);

        assertThat(grade).isEqualTo(Grade.FIRST);
    }

    @DisplayName("5개 일치와 보너스가 일치할 경우 2등입니다.")
    @Test
    void winSecond(){
        Lotto winningNum = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(1,2,3,4,5,7));
        int bonusNum = 7;

        Integer result = ticket.matchNumbers(winningNum);
        Boolean bonusMatch = ticket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(result,bonusMatch);

        assertThat(grade).isEqualTo(Grade.SECOND);
    }

    @DisplayName("5개 일치할 경우 3등입니다.")
    @Test
    void winThrid(){
        Lotto winningNum = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(1,2,3,4,5,45));
        int bonusNum = 7;

        Integer result = ticket.matchNumbers(winningNum);
        Boolean bonusMatch = ticket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(result,bonusMatch);

        assertThat(grade).isEqualTo(Grade.THIRD);
    }

    @DisplayName("4개 일치할 경우 4등입니다.")
    @Test
    void winFourth(){
        Lotto winningNum = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(1,2,3,4,44,45));
        int bonusNum = 7;

        Integer result = ticket.matchNumbers(winningNum);
        Boolean bonusMatch = ticket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(result,bonusMatch);

        assertThat(grade).isEqualTo(Grade.FOURTH);
    }

    @DisplayName("3개 일치할 경우 5등입니다.")
    @Test
    void wiFiFth(){
        Lotto winningNum = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(1,2,3,43,44,45));
        int bonusNum = 7;

        Integer result = ticket.matchNumbers(winningNum);
        Boolean bonusMatch = ticket.matchBonusNum(bonusNum);

        Grade grade = Grade.judge(result,bonusMatch);

        assertThat(grade).isEqualTo(Grade.FIFTH);
    }
}