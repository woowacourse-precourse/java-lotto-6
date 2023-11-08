package rank;

import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("맞힌 개수에 따라 로또 티켓이 몇 등인지 확인해준다.")
    @Test
    void checkTicketRank() {
        Rank result = Rank.checkTicketRank(5,true);
        assertThat(result).isEqualTo(Rank.SECOND_PLACE);
    }

}
