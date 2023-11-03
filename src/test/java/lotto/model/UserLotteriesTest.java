package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLotteriesTest {

    @DisplayName("사용자가 가지고 있는 각각의 로또들의 숫자를 오름차순 정렬한다.")
    @Test
    void sortAscendingAllLotto() {
        //given
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(11, 40, 36, 12, 3, 4)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(6, 5, 4, 3, 2, 1)));
        UserLotteries userLotteries = new UserLotteries(List.of(lotto1, lotto2));

        //when
        userLotteries.sortAscendingAllLotto();

        //then
        assertThat(userLotteries.getLotteries().get(0).getNumbers())
                .usingRecursiveComparison().isEqualTo(List.of(3, 4, 11, 12, 36, 40));
        assertThat(userLotteries.getLotteries().get(1).getNumbers())
                .usingRecursiveComparison().isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}