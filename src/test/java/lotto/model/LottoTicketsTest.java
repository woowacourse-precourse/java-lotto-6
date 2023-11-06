package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("입력된 개수만큼 로또 만들기")
    void makeLottoTickets(){
        List<Lotto> tickets = new ArrayList<>();
        tickets.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        tickets.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        LottoTickets expectedTicktes = new LottoTickets(tickets);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(8);
                    assertThat(lottoTickets.makeTickets()).isEqualTo(expectedTicktes);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

}