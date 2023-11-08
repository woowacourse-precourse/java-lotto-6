package lotto.lottoCompareTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

public class WinningLottoTest extends NsTest {

    @Test
    @DisplayName("각 로또 비교 당첨 수 테스트")
    void lottoTicketsCompareSameNum() {
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
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
