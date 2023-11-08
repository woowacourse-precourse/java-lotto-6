package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.constant.WinningCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest extends NsTest {
    @DisplayName("quantity개의 로또 번호를 생성한다.")
    @Test
    void createLottoTickets() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoManager lottoManager = new LottoManager();
                    List<Lotto> tickets = lottoManager.generateLottoTickets(2);
                    assertThat(tickets.stream().map(Lotto::toString).toArray()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @DisplayName("내 로또 티켓과 로또 당첨 번호를 조회하여 결과 테이블을 만든다.")
    @Test
    void createLottoResultTable() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(4, 5, 6, 10, 11, 7)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        Lotto lotto = new Lotto(List.of(4, 5, 6, 10, 11, 12));
        int bonusNumber = 7;

        LottoManager lottoManager = new LottoManager();
        Map<?,?> result = lottoManager.getResultTable(tickets, lotto, bonusNumber);
        assertThat(result.get(WinningCondition.THREE_MATCH)).isEqualTo(1);
        assertThat(result.get(WinningCondition.FOUR_MATCH)).isEqualTo(null);
        assertThat(result.get(WinningCondition.FIVE_MATCH)).isEqualTo(null);
        assertThat(result.get(WinningCondition.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
        assertThat(result.get(WinningCondition.SIX_MATCH)).isEqualTo(null);
    }

    @DisplayName("나의 로또 티켓을 로또 당첨 번호와 대조한다.")
    @Test
    void queryMyLotto() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 10, 11, 7));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));

        Lotto lotto = new Lotto(List.of(4, 5, 6, 10, 11, 12));
        int bonusNumber = 7;

        LottoManager lottoManager = new LottoManager();
        WinningCondition expected1 = lottoManager.checkWinningResult(lotto1, lotto, bonusNumber);
        WinningCondition expected2 = lottoManager.checkWinningResult(lotto2, lotto, bonusNumber);
        WinningCondition expected3 = lottoManager.checkWinningResult(lotto3, lotto, bonusNumber);
        assertThat(WinningCondition.THREE_MATCH).isEqualTo(expected1);
        assertThat(WinningCondition.FIVE_MATCH_WITH_BONUS).isEqualTo(expected2);
        assertThat(WinningCondition.NOTHING).isEqualTo(expected3);
    }

    @DisplayName("로또 결과를 통해 수익률을 계산한다.")
    @Test
    void calculateRoR() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(4, 5, 6, 10, 11, 7)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        Lotto lotto = new Lotto(List.of(4, 5, 6, 10, 11, 12));
        int bonusNumber = 7;

        LottoManager lottoManager = new LottoManager();
        Map<WinningCondition, Integer> result = lottoManager.getResultTable(tickets, lotto, bonusNumber);

        double expected = 1000166.7;
        assertThat(lottoManager.calculateRoR(result, 3000))
                .isEqualTo(expected);
    }

    @Override
    public void runMain() {
    }
}