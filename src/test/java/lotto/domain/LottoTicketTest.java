package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoTicket 클래스는")
class LottoTicketTest {
    @DisplayName("로또 정답을 받아서, 로또들의 결과를 Map으로 반환한다.")
    @Test
    void getLottoStatistics() {
        // given
        LottoTicket ticket = new LottoTicket(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new Lotto(List.of(1, 12, 13, 14, 15, 16)),
                        new Lotto(List.of(11, 12, 13, 14, 15, 16))
                )
        );

        LottoAnswer answer = new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Map<LottoGrade, Integer> statistics = ticket.getLottoStatistics(answer);

        // then
        assertThat(statistics)
                .containsEntry(LottoGrade.FIRST, 1)
                .containsEntry(LottoGrade.SECOND, 1)
                .containsEntry(LottoGrade.FOURTH, 1)
                .containsEntry(LottoGrade.MISS, 2);
    }
}