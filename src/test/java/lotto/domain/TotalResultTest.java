package lotto.domain;

import java.util.ArrayList;
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

    @DisplayName("최종 결과 클래스 내부의 메서드를 통해 수익률을 얻을 수 있다.")
    @Test
    void getRateOfReturnByMethod() {
        TotalResult mockTotalResult = createTotalResultByMockData();
        Assertions.assertThat(mockTotalResult.calcRateOfReturn(1000)).isEqualTo(150000.0);
    }

    private TotalResult createTotalResultByRandomsAPI() {
        LottoMachine machine = new LottoMachine();
        Tickets tickets = machine.generateTickets(10000);
        Lotto mockHitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(mockHitNumbers, 7);

        return tickets.compareTicketsToAnswer(answer);
    }

    private TotalResult createTotalResultByMockData() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> mockTickets = new ArrayList<>(){{
            add(lotto);
        }};
        Tickets tickets = new Tickets(mockTickets);
        Lotto mockHitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Answer answer = new Answer(mockHitNumbers, 7);

        return tickets.compareTicketsToAnswer(answer);
    }
}
