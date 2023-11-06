package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("객체생성 중복 예외테스트")
    public void duplicateExceptionTest() {
        List<Integer> invalidList = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "6";

        assertThatThrownBy(() -> new WinningNumbers(invalidList, bonusNumber)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체생성 숫자 범위 예외테스트")
    public void rangeExceptionTest() {
        List<Integer> invalidList = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "46";

        assertThatThrownBy(() -> new WinningNumbers(invalidList, bonusNumber)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 등수별 개수 구하는 기능 테스트")
    public void getRankCountTest() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), "7");
        List<Lotto> lottoTicket = buyLottoTicket();

        Map<Rank, Integer> rankCount = winningNumbers.getRankCount(lottoTicket);

        assertEquals(rankCount.get(Rank.FIRST), 1);
        assertEquals(rankCount.get(Rank.SECOND), 1);
        assertEquals(rankCount.get(Rank.THIRD), 1);
        assertEquals(rankCount.get(Rank.FOURTH), 1);
        assertEquals(rankCount.get(Rank.FIFTH), 1);
        assertEquals(rankCount.get(Rank.LOSE), 3);
    }

    private static List<Lotto> buyLottoTicket() {
        List<Lotto> lottoTicket = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 15)),
            new Lotto(List.of(1, 2, 3, 4, 15, 25)),
            new Lotto(List.of(1, 2, 3, 15, 25, 35)),
            new Lotto(List.of(1, 2, 15, 25, 35, 45)),
            new Lotto(List.of(1, 10, 15, 25, 35, 45)),
            new Lotto(List.of(7, 10, 15, 25, 35, 45))
        );
        return lottoTicket;
    }
}
