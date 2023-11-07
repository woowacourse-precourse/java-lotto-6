package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBuyerUnitTest {
    LottoBuyer lottoBuyer1;
    Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonus = 7;

    @Test
    @DisplayName("6개의 숫자가 맞아야한다")
    void 로또바이어_1등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        Rank rank = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .findAny().get();
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등은 5개의 숫자와 보너스 숫자가 맞아야한다.")
    void 로또바이어_2등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        Rank rank = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .findAny().get();
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등은 5개의 숫자가 맞아야한다. 보너스는 틀려야한다.")
    void 로또바이어_3등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        Rank rank = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .findAny().get();
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등은 4개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 로또바이어_4등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 10));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        Rank rank = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .findAny().get();
        assertThat(rank).isEqualTo(Rank.FORTH);
    }

    @Test
    @DisplayName("5등은 3개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 로또바이어_5등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 7, 10));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        Rank rank = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .findAny().get();
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("0~2개는 FAIL에 매치된다. 보너스는 무시된다.")
    void 로또바이어_무효_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 15, 11, 7, 10));
        lottoBuyer1 = new LottoBuyer(List.of(lotto));

        //when
        Map<Rank, Integer> map = lottoBuyer1.checkAllLotto(target, bonus);

        //then
        long count = map.keySet().stream()
                .filter(key -> map.get(key) == 1)
                .count();
        assertThat(count).isEqualTo(0);
    }

    @Test
    void 로또바이어_지불액() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 15, 11, 7, 10));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBuyer1 = new LottoBuyer(List.of(lotto1));
        LottoBuyer lottoBuyer2 = new LottoBuyer(List.of(lotto1, lotto2, lotto3));

        //when
        int payment1 = lottoBuyer1.payment();
        int payment2 = lottoBuyer2.payment();

        //then
        Assertions.assertThat(payment1).isEqualTo(1000);
        Assertions.assertThat(payment2).isEqualTo(3000);
    }
}
