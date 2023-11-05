package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(secondRanking.getRanking()).isEqualTo(2);
    }

}