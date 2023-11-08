package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.Input.StatisticsStartCommand;
import lotto.Input.winningnumber.NumberEnteredEvent;
import lotto.Input.winningnumber.ValidatedBonusNumber;
import lotto.Lotto;
import lotto.statistics.calculatewinning.Ranking;
import lotto.statistics.calculatewinning.Win;
import lotto.statistics.calculatewinning.WinningRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StaticsContextTest {

  @DisplayName("당첨 통계를 계산한다. (1등 1개, 2등 1개, 3등 0개, 4등 0개, 5등 0개)")
  @Test
  void calculateStatics() {
    // given
    NumberEnteredEvent event = NumberEnteredEvent.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        ValidatedBonusNumber.of("7"));
    List<Lotto> issuedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
        new Lotto(List.of(1, 2, 3, 4, 5, 7)));
    int standardPrice = 1000;
    StatisticsStartCommand command = StatisticsStartCommand.of(event, issuedLottos, standardPrice);

    // when
    StaticsCalculatedEvent staticsCalculatedEvent = StaticsContext.calculateStatics(command);

    // then
    assertThat(staticsCalculatedEvent.getTotalStaticRecord().records()).hasSize(5);
    assertThat(staticsCalculatedEvent.getTotalStaticRecord().records()).containsExactly(
        StaticsRecord.of(3, 5_000, 0),
        StaticsRecord.of(4, 50_000, 0),
        StaticsRecord.of(5, 1_500_000, 0),
        StaticsRecord.of(5, 30_000_000, 1),
        StaticsRecord.of(6, 2_000_000_000, 1)
    );
  }

  @DisplayName("당첨이 없다.")
  @Test
  void if_not_Winning_calculate() {
    // given
    NumberEnteredEvent event = NumberEnteredEvent.of(new Lotto(List.of(10, 11, 12, 13, 14, 15)),
        ValidatedBonusNumber.of("7"));
    List<Lotto> issuedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
        new Lotto(List.of(1, 2, 3, 4, 5, 8)));
    int standardPrice = 1000;
    StatisticsStartCommand command = StatisticsStartCommand.of(event, issuedLottos, standardPrice);

    // when
    StaticsCalculatedEvent staticsCalculatedEvent = StaticsContext.calculateStatics(command);

    // then
    assertThat(staticsCalculatedEvent.getTotalStaticRecord().records()).containsExactly(
        StaticsRecord.of(3, 5000, 0),
        StaticsRecord.of(4, 50000, 0),
        StaticsRecord.of(5, 1500000, 0),
        StaticsRecord.of(5, 30_000_000, 0),
        StaticsRecord.of(6, 2000000000, 0)
    );
  }
}