package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import lotto.service.FindWinning;
import lotto.vo.winning.LottoWinning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningTest extends NsTest {

    public long setup() {
        List<Integer> winningnumber = new ArrayList<>();
        List<Lotto> lottos = new ArrayList<>();
        winningnumber.add(1);
        winningnumber.add(2);
        winningnumber.add(3);
        winningnumber.add(4);
        winningnumber.add(5);
        winningnumber.add(6);
        Lotto winnigNumber = new Lotto(winningnumber);
        lottos.add(winnigNumber);
        LottoWinning.setWinningnumber(winnigNumber);
        LottoWinning.setBonusnumber(7);
        FindWinning winning = new FindWinning();
        winning.Result(lottos, winning);
        return LottoWinning.GetTotalWinningPrice();
    }

    @DisplayName("로또 발행과 로또 당첨 번호는 만들어진 메서드로 진행함.")
    @Test
    public void LottoWinning_테스트() {
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run();
            assertThat(output()).contains("당첨 통계\r\n"
                    + "---\r\n"
                    + "3개 일치 (5,000원) - 0개\r\n"
                    + "4개 일치 (50,000원) - 0개\r\n"
                    + "5개 일치 (1,500,000원) - 0개\r\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\r\n"
                    + "6개 일치 (2,000,000,000원) - 1개");
        });
    }

    @Test
    public void LottoWinningPrice_테스트() {
        assertEquals(setup(), 2_000_000_000);
    }

    @Override
    public void runMain() {
        setup();
    }
}
