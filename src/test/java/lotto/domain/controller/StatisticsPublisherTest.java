package lotto.domain.controller;

import lotto.domain.controller.LottoController;
import lotto.domain.controller.StatisticsPublisher;
import lotto.domain.controller.converter.LottosConverter;
import lotto.domain.controller.converter.StatisticsConverter;
import lotto.domain.dto.Statistics;
import lotto.domain.model.*;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsPublisherTest {

    @Test
    void 통계_발행_테스트() {
        StatisticsPublisher publisher = new StatisticsPublisher(new LottoController(new LottoInput(() -> ""), new LottoOutput(new LottosConverter(), new StatisticsConverter())));
        Lottos generatedLottos = new Lottos();
        generatedLottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Money money = new Money(1000);

        Statistics actual = publisher.publish(generatedLottos, winningNumber, bonusNumber, money);

        assertEquals(new Statistics(List.of(Result.SIX_MATCH), 200000000), actual);
    }
}
