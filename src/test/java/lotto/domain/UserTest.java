package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @DisplayName("User는 가진 돈이 있으면 로또를 산다.")
    @Test
    void buyWithHasMoney() {
        //given
        User user = new User(LotteryOffice.LOTTO_PRICE);

        //when
        boolean isBuy = user.buy(LotteryOffice.LOTTO_PRICE, new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //then
        assertThat(isBuy).isTrue();
    }

    @DisplayName("User는 가진 돈이 없으면 로또를 사지 않는다.")
    @Test
    void buyWithHasNotMoney() {
        //given
        User user = new User(LotteryOffice.LOTTO_PRICE.minus(new Money(1)));

        //when
        boolean isBuy = user.buy(LotteryOffice.LOTTO_PRICE, new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //then
        assertThat(isBuy).isFalse();
    }

    @DisplayName("user는 당첨이 된 로또가 몇개인지 알 수 있다.")
    @Test
    void calculateWinningCount() {
        //given
        User user = new User(LotteryOffice.LOTTO_PRICE.multiply(new Money(5)));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 9, 10, 11));

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        user.buy(LotteryOffice.LOTTO_PRICE, lotto1);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto2);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto3);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto4);
        user.buy(LotteryOffice.LOTTO_PRICE, lotto5);

        //when
        int calculateWinningCount1 = user.calculateWinningCount(Winning.FIRST_PLACE, winningLotto);
        int calculateWinningCount2 = user.calculateWinningCount(Winning.SECOND_PLACE, winningLotto);
        int calculateWinningCount3 = user.calculateWinningCount(Winning.THIRD_PLACE, winningLotto);
        int calculateWinningCount4 = user.calculateWinningCount(Winning.FOURTH_PLACE, winningLotto);
        int calculateWinningCount5 = user.calculateWinningCount(Winning.FIFTH_PLACE, winningLotto);

        //then
        assertThat(calculateWinningCount1).isEqualTo(1);
        assertThat(calculateWinningCount2).isEqualTo(1);
        assertThat(calculateWinningCount3).isEqualTo(1);
        assertThat(calculateWinningCount4).isEqualTo(1);
        assertThat(calculateWinningCount5).isEqualTo(1);
    }

    @DisplayName("user는 수익률을 계산할 수 있다.")
    @Test
    void calculateRateOfReturn() {
        //given
        User user = new User(new Money(8000));

        //when
        double rateOfReturn = user.calculateRateOfReturn(new Money(5000));

        //then
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}