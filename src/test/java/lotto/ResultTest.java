package lotto;

import lotto.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {
    private Result firstRank;
    private Result secondRank;
    private Result thirdRank;
    private Result fourthRank;
    private Result fifthRank;
    private Result othersRank;

    @BeforeEach
    void setUp() {
        Ticket ticket = new Ticket(new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Bonus(9));
        firstRank = new Result(ticket, new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        secondRank = new Result(ticket, new Lotto(List.of(1, 2, 3, 4, 5, 9)));
        thirdRank = new Result(ticket, new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        fourthRank = new Result(ticket, new Lotto(List.of(1, 2, 3, 4, 43, 8)));
        fifthRank = new Result(ticket, new Lotto(List.of(1, 2, 3, 41, 43, 8)));
        othersRank = new Result(ticket, new Lotto(List.of(1, 2, 40, 41, 43, 8)));
    }

    @DisplayName("결과가 1등인지 확인합니다.")
    @Test
    void createFirstRankingByTicketAndLotto() {
        assertThat(firstRank.getRank()).isEqualTo(Rank.FIRST);
    }

    @DisplayName("결과가 2등인지 확인합니다.")
    @Test
    void createSecondRankingByTicketAndLotto() {
        assertThat(secondRank.getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("결과가 3등인지 확인합니다.")
    @Test
    void createThirdRankingByTicketAndLotto() {
        assertThat(thirdRank.getRank()).isEqualTo(Rank.THIRD);
    }

    @DisplayName("결과가 4등인지 확인합니다.")
    @Test
    void createFourthRankingByTicketAndLotto() {
        assertThat(fourthRank.getRank()).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("결과가 5등인지 확인합니다.")
    @Test
    void createFifthRankingByTicketAndLotto() {
        assertThat(fifthRank.getRank()).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("결과가 5등 밖인지 확인합니다.")
    @Test
    void createOthersRankingByTicketAndLotto() {
        assertThat(othersRank.getRank()).isEqualTo(Rank.OTHERS);
    }
}