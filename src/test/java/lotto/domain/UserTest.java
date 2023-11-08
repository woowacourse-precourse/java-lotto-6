package lotto.domain;

import lotto.model.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @BeforeEach
    void makeUser() {
        User user = new User(8000);
    }

    @DisplayName("사용자가 구매한 자산 확인")
    @Test
    public void getPurchaseMonyeTest() {
        // given
        User user = new User(8000);

        // when
        long purchaseMoney = user.getPurchaseMoney();

        // then
        assertThat(purchaseMoney).isEqualTo(8000);
    }

    @DisplayName("사용자가 보유 중인 로또 개수 확인")
    @Test
    public void havingLottosCountTest() {
        // given
        User user = new User(8000);

        // when
        int purchaseLottosCount = user.getHavingLottosCount();

        // then
        assertThat(purchaseLottosCount).isEqualTo(8);
    }

    @DisplayName("사용자가 로또로 획득한 돈 추가 및 확인")
    @Test
    public void increaseMoneyOfReturnTest() {
        // given
        User user = new User(8000);
        long returnMoney = 5000L;

        // when
        user.increaseMoneyOfReturn(returnMoney);

        // then
        assertThat(user.getMoneyOfReturn()).isEqualTo(5000L);
    }

    @DisplayName("사용자가의 랭크 증가 및 확인")
    @Test
    public void increaseUserRankTest() {
        // given
        User user = new User(8000);
        int identifyNum = 3;

        // when
        user.increaseUserRank(identifyNum);

        // then
        assertThat(user.getLottoRanks()[3]).isEqualTo(1);
    }


}
