package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCountTest {

    @DisplayName("로또 당첨금 조회")
    @Test
    public void totalWinnings() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> tickets = new ArrayList<>();

        tickets.add(lotto);

        BonusNumber bonusNumber = new BonusNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), bonusNumber);

        RankCount rankCount = new RankCount(tickets, winningNumbers);

        assertThat(rankCount.calculateTotalWinnings()).isEqualTo(Rank.FIRST.getAmount());
    }

    @DisplayName("로또 순위")
    @Test
    public void winningRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> tickets = new ArrayList<>();

        tickets.add(lotto);

        BonusNumber bonusNumber = new BonusNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), bonusNumber);

        RankCount rankCount = new RankCount(tickets, winningNumbers);
        System.out.println(rankCount.getRankCount().keySet());

        assertAll(
                () -> assertThat(rankCount.getRankCount().containsKey(Rank.FIRST)).isTrue(),
                () -> assertThat(rankCount.getRankCount().get(Rank.FIRST)).isEqualTo(1)
        );
    }
}
