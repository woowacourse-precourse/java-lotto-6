package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.util.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalResultTest {
    @DisplayName("최종 결과의 Getter를 통해 EnumMap을 얻을 수 있다.")
    @Test
    void getEnumMapByGetter() {
        TotalResult mockTotalResult = createTotalResultByRandomsAPI();
        Assertions.assertThat(mockTotalResult.getTotalResult()).isInstanceOf(EnumMap.class);
    }

    private TotalResult createTotalResultByRandomsAPI() {
        LottoMachine machine = new LottoMachine();
        Tickets tickets = machine.generateTickets(10000);
        Lotto mockHitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(mockHitNumbers, 7);

        return tickets.compareTicketsToAnswer(answer);
    }
}
