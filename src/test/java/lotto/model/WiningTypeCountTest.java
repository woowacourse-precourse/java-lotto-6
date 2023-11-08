package lotto.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WiningTypeCountTest {

    @Test
    void 수익률이_백프로다() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );
        Lotto wining = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Bonus bonus = new Bonus(44);

        // when
        WiningNumbers winingNumbers = new WiningNumbers(wining, bonus);
        WiningTypeCount winingTypeCount = winingNumbers.countWining(lottos);

        // then
        Assertions.assertEquals(winingTypeCount.calculateRateOfReturn(lottos), 100);
    }

    @Test
    void 수익률이_오백프로다() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto wining = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Bonus bonus = new Bonus(44);

        // when
        WiningNumbers winingNumbers = new WiningNumbers(wining, bonus);
        WiningTypeCount winingTypeCount = winingNumbers.countWining(lottos);

        // then
        Assertions.assertEquals(winingTypeCount.calculateRateOfReturn(lottos), 500);
    }
}