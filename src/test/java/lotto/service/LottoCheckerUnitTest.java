package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.win.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerUnitTest {
    LottoBuyer lottoBuyer;
    Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonus = 7;

    @Test
    @DisplayName("모든 숫자가 맞아야 한다.")
    void 로또체커_1등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> tickets = List.of(lotto);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개의 숫자와 보너스 숫자가 맞아야한다")
    void 로또체커_2등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> tickets = List.of(lotto);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개의 숫자가 맞아야한다. 보너스 숫자는 틀려야한다.")
    void 로또체커_3등_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(2, 3, 4, 5, 6, 10));
        List<Lotto> tickets = List.of(lotto);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 로또체커_4등_테스트() {
        //given
        Lotto lotto1 = new Lotto(List.of(3, 4, 5, 6, 7, 11));
        Lotto lotto2 = new Lotto(List.of(3, 4, 5, 6, 11, 12));
        List<Lotto> tickets = List.of(lotto1, lotto2);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.FORTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("3개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 로또체커_5등_테스트() {
        //given
        Lotto lotto1 = new Lotto(List.of(3, 4, 5, 7, 11, 12));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        List<Lotto> tickets = List.of(lotto1, lotto2);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("2개 이하는 모두 무시한다. 보너스는 무시한다.")
    void 로또체커_무효_테스트() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 7, 10, 11, 12));
        Lotto lotto2 = new Lotto(List.of(1, 2, 30, 11, 12, 13));
        List<Lotto> tickets = List.of(lotto1, lotto2);
        lottoBuyer = new LottoBuyer(tickets, target, bonus);

        //when
        Map<Rank, Integer> map = lottoBuyer.checkAllLotto();

        //then
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(Rank.FAIL)).isEqualTo(2);
    }
}
