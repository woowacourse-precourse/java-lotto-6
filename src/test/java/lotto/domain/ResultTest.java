package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("상의 개수를 확인한다.")
    @Test
    void getPrizeCount() {
        // given
        final List<Prize> prizes = List.of(Prize.FIRST, Prize.FIRST, Prize.SECOND, Prize.SECOND, Prize.SECOND,
                Prize.NONE);
        final Result result = new Result(prizes);

        // when
        final long firstCount = result.getPrizeCount((Prize.FIRST));
        final long secondCount = result.getPrizeCount((Prize.SECOND));
        final long noneCount = result.getPrizeCount((Prize.NONE));

        // then
        assertAll(() -> {
            assertThat(firstCount).isEqualTo(2);
            assertThat(secondCount).isEqualTo(3);
            assertThat(noneCount).isEqualTo(1);
        });
    }

    @DisplayName("해당 하는 상이 하나도 없으면 0개를 반환한다.")
    @Test
    void getPrizeCountZero() {
        // given
        final List<Prize> prizes = List.of(Prize.FIRST);
        final Result result = new Result(prizes);

        // when
        final long secondCount = result.getPrizeCount((Prize.SECOND));

        // then
        assertThat(secondCount).isZero();
    }

    @DisplayName("상금의 합을 계산한다.")
    @Test
    void getWinMoney() {
        // given
        final List<Prize> prizes = List.of(Prize.FIRST, Prize.SECOND, Prize.NONE);
        final Money expected = prizes.stream().map(Prize::getMoney).reduce(Money.ZERO, Money::add);
        final Result result = new Result(prizes);

        // when
        final Money actual = result.getWinMoney();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
