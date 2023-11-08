package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    User user;

    @BeforeEach
    void buyLotto() {
        user = new User(LotteryOffice.LOTTO_PRICE.multiply(new Money(5)));

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 9, 10, 11));

        user.buy(LotteryOffice.LOTTO_PRICE, lotto1);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto2);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto3);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto4);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto5);
    }

    @DisplayName("WinningResult는 해당 등수에 몇개가 당첨됐는지 알수 있다.")
    @Test
    void createWinningResult() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        WinningResult winningResult1 = new WinningResult(user, winningLotto, Winning.FIRST_PLACE);
        WinningResult winningResult2 = new WinningResult(user, winningLotto, Winning.SECOND_PLACE);
        WinningResult winningResult3 = new WinningResult(user, winningLotto, Winning.THIRD_PLACE);
        WinningResult winningResult4 = new WinningResult(user, winningLotto, Winning.FOURTH_PLACE);
        WinningResult winningResult5 = new WinningResult(user, winningLotto, Winning.FIFTH_PLACE);

        //then
        assertThat(winningResult1.getMatchCount()).isEqualTo(1);
        assertThat(winningResult2.getMatchCount()).isEqualTo(1);
        assertThat(winningResult3.getMatchCount()).isEqualTo(1);
        assertThat(winningResult4.getMatchCount()).isEqualTo(1);
        assertThat(winningResult5.getMatchCount()).isEqualTo(1);
    }

    @DisplayName("WinningResult는 얻은 이익을 계산할 수 있다.")
    @Test
    void totalProfit() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        WinningResult winningResult1 = new WinningResult(user, winningLotto, Winning.FIRST_PLACE);
        WinningResult winningResult2 = new WinningResult(user, winningLotto, Winning.SECOND_PLACE);
        WinningResult winningResult3 = new WinningResult(user, winningLotto, Winning.THIRD_PLACE);
        WinningResult winningResult4 = new WinningResult(user, winningLotto, Winning.FOURTH_PLACE);
        WinningResult winningResult5 = new WinningResult(user, winningLotto, Winning.FIFTH_PLACE);

        //then
        assertThat(winningResult1.totalProfit().compareTo(Winning.FIRST_PLACE.getAmount())).isEqualTo(0);
        assertThat(winningResult2.totalProfit().compareTo(Winning.SECOND_PLACE.getAmount())).isEqualTo(0);
        assertThat(winningResult3.totalProfit().compareTo(Winning.THIRD_PLACE.getAmount())).isEqualTo(0);
        assertThat(winningResult4.totalProfit().compareTo(Winning.FOURTH_PLACE.getAmount())).isEqualTo(0);
        assertThat(winningResult5.totalProfit().compareTo(Winning.FIFTH_PLACE.getAmount())).isEqualTo(0);
    }
}