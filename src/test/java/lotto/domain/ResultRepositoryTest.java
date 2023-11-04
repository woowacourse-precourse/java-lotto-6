package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultRepositoryTest {
    WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

    @DisplayName("등수 판단")
    @Test
    void checkRank() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        ResultRepository resultRepository = new ResultRepository(winningLotto, lotto);
        assertThat(resultRepository.getRank()).isEqualTo(Rank.First);

        lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
        resultRepository = new ResultRepository(winningLotto, lotto);
        assertThat(resultRepository.getRank()).isEqualTo(Rank.Second);

        lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10)));
        resultRepository = new ResultRepository(winningLotto, lotto);
        assertThat(resultRepository.getRank()).isEqualTo(Rank.Third);

        lotto = new Lotto(new ArrayList<>(List.of(11, 12, 13, 14, 15, 16)));
        resultRepository = new ResultRepository(winningLotto, lotto);
        assertThat(resultRepository.getRank()).isEqualTo(Rank.None);
    }
}
