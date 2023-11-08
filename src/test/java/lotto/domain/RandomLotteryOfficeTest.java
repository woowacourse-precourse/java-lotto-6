package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLotteryOfficeTest {
    @DisplayName("LotteryOffice는 User가 돈이 충분하다면 로또를 판다.")
    @Test
    void issueLottoWithUserHasMoney() {
        //given
        LotteryOffice lotteryOffice = new RandomLotteryOffice();
        User user = new User(new Money(1000));

        //when
        boolean isSell = lotteryOffice.sellTo(user);

        //then
        assertThat(isSell).isTrue();
    }

    @DisplayName("LotteryOffice는 User가 돈이 충분하지 않다면 로또를 팔지 않는다.")
    @Test
    void issueLottoWithUserHasNoMoney() {
        //given
        LotteryOffice lotteryOffice = new RandomLotteryOffice();
        User user = new User(new Money(0));

        //when
        boolean isSell = lotteryOffice.sellTo(user);

        //then
        assertThat(isSell).isFalse();
    }
}