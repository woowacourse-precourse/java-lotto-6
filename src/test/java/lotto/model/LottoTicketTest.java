package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또를 당첨 번호와 비교하여 일치하는 개수를 구한다.")
    @Test
    void getMatchCountWithWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 3, 5, 7, 8, 9);
        int matchCount = lottoTicket.getMatchCountWithWinningNumbers(winningNumbers);

        assertThat(matchCount).isEqualTo(3);
    }
}
