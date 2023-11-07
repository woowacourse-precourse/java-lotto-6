package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest  extends NsTest {
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}