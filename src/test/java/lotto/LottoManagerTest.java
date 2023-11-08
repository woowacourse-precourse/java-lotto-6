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

    @Override
    public void runMain() {
    }
}