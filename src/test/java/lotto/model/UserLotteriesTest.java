package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLotteriesTest {

    @DisplayName("사용자가 구매한 로또의 개수를 반환한다.")
    @Test
    void getUserLotteriesSize() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        UserLotteries userLotteries = new UserLotteries(List.of(lotto1, lotto2, lotto3));
        //when
        int lotteriesCount = userLotteries.lotteriesCount();
        //then
        assertThat(lotteriesCount).isEqualTo(3);
    }
}