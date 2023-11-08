package Board;

import lotto.LottoOutcome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class BoardTest {
    @DisplayName("당첨 내역을 저장합니다.")
    @Test
    void storeWinningRecord(){
        Board board = new Board(1000);
        board.writeOutcome(LottoOutcome.rank1);

        assertThat(board.getWinningRecord().get(LottoOutcome.rank1)).isEqualTo(1);
    }
}
