package lotto.collaboration.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.collaboration.lottostore.enums.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void matchPrize로_3등을판별할수있다() {
        int resultOfMatchNumbers = 5;
        boolean resultOfMatchBonusNumber = false;

        Prize actual = Prize.matchPrize(resultOfMatchNumbers, resultOfMatchBonusNumber);
        Prize expected = Prize.THIRD;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchPrize로_2등을판별할수있다() {
        int resultOfMatchNumbers = 5;
        boolean resultOfMatchBonusNumber = true;

        Prize actual = Prize.matchPrize(resultOfMatchNumbers, resultOfMatchBonusNumber);
        Prize expected = Prize.SECOND;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchPrize로_보너스번호를맞추지못한_낙첨을판별할수있다() {
        int resultOfMatchNumbers = 2;
        boolean resultOfMatchBonusNumber = false;

        Prize actual = Prize.matchPrize(resultOfMatchNumbers, resultOfMatchBonusNumber);
        Prize expected = Prize.LOST;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchPrize로_보너스번호를맞춘_낙첨을판별할수있다() {
        boolean resultOfMatchBonusNumber = true;
        int resultOfMatchNumbers = 1;

        Prize expected = Prize.LOST;
        Prize actual = Prize.matchPrize(resultOfMatchNumbers, resultOfMatchBonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void valuesByRank로_역순의_Prize를가져올수있다() {
        List<Prize> expected = List.of(Prize.LOST, Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);

        List<Prize> actual = Prize.valuesByRank();

        assertThat(actual).containsExactly(expected.toArray(Prize[]::new));
    }

    @Test
    void message로_당첨내역메시지를_가져올수있다() {
        String expected = "6개 일치 (2,000,000,000원)";

        String actual = Prize.FIRST.message();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void makeCountOfPrizeLottos로_개별등수당첨결과문을_가져올수있다() {
        String expected = "6개 일치 (2,000,000,000원) - 1개";

        String actual = Prize.FIRST.makeCountOfPrizeLottos(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void money로_당첨내역금액을_가져올수있다() {
        int expected = 2_000_000_000;

        long actual = Prize.FIRST.money();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}