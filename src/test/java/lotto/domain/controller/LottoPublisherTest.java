package lotto.domain.controller;

import lotto.domain.controller.LottoController;
import lotto.domain.controller.LottoPublisher;
import lotto.domain.controller.converter.LottosConverter;
import lotto.domain.controller.converter.StatisticsConverter;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPublisherTest {

    @Test
    void 로또_발행_테스트() {
        LottoPublisher publisher = new LottoPublisher(() -> List.of(1, 2, 3, 4, 5, 6), new LottoController(new LottoInput(() -> ""), new LottoOutput(new LottosConverter(), new StatisticsConverter())));
        Money money = new Money(1000);
        Lottos expected = new Lottos();
        expected.addLotto(List.of(1, 2, 3, 4, 5, 6));

        Lottos actual = publisher.publish(money);

        assertEquals(expected, actual);

    }

}