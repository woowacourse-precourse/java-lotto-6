package lotto.lottoCompareTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.controller.LottoCompareController;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCompareControllerTest extends NsTest {
    @Test
    @DisplayName("각 로또 비교 당첨 수 테스트")
    void lottoTicketsCompareNum() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    run("5000", "2,11,18,20,23,32", "1");

                    Assertions.assertThat(WinningLotto.getInstance().getTreeSameNumLotto()).isEqualTo(1);
                    Assertions.assertThat(WinningLotto.getInstance().getFourSameNumLotto()).isEqualTo(1);
                    Assertions.assertThat(WinningLotto.getInstance().getFiveSameNumLotto()).isEqualTo(1);
                    Assertions.assertThat(WinningLotto.getInstance().getFiveAndBonusSameNumLotto()).isEqualTo(1);
                    Assertions.assertThat(WinningLotto.getInstance().getSixSameNumLotto()).isEqualTo(1);


                },
                List.of(2, 11, 18, 20, 23, 32),
                List.of(2, 11, 18, 20, 23, 1),
                List.of(2, 11, 18, 20, 23, 30),
                List.of(2, 11, 18, 20, 4, 5),
                List.of(2, 11, 18, 33, 4, 5)
        );
    }
    @Test
    @DisplayName("통계 계산 테스트")
    void winningLottoRate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    run("8000", "1,2,3,4,5,6", "7");


                    Assertions.assertThat(LottoCompareController.getInstance().winningLottoRate()).isEqualTo(62.5);


                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @Override
    protected void runMain() {
        {
            Application.main(new String[]{});
        }
    }
}
