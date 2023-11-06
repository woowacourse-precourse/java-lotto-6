package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {
    private Result secondRanking;

    @BeforeEach
    void setUp() {
        Ticket ticket = new Ticket(new Lotto(List.of(1,2,3,4,5,7)), new Bonus(9));
        secondRanking = new Result(ticket, new Lotto(List.of(1,2,3,4,5,9)));
    }

    @DisplayName("결과가 2등인지 확인합니다.")
    @Test
    void createSecondRankingByTicketAndLotto() {
        assertThat(secondRanking.getRank()).isEqualTo(2);
    }

}