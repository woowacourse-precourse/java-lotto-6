package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparatorTest {
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    int bonusNumber;

    @Test
    @DisplayName("발행한 로또를 당첨번호 및 보너스 번호와 비교하고 당첨된 번호의 개수와 보너스 번호의 일치 여부를 저장한 winningCounts 리스트 반환")
    void compareTest() {
        setUp();
        List<WinningCount> winningCounts = Comparator.compare(lottos, winningNumbers, bonusNumber);
        assertThat(winningCounts.get(0).getWinningCount()).isEqualTo(5);
        assertThat(winningCounts.get(0).hasBonusNumber()).isEqualTo(true);
    }

    @BeforeEach
    void setUp() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        bonusNumber = 6;
    }
}