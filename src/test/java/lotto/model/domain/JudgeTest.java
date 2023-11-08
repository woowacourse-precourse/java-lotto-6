package lotto.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

class JudgeTest extends NsTest {

    @Test
    void judgeCorrectResult() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Integer> winningNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Lotto lotto = new Lotto(winningNumber);
                    LottoNumber bonusNumber = new LottoNumber(7);
                    User user = new User();
                    user.enterDraw(6000);
                    Judge judge = new Judge(lotto, bonusNumber, user);
                    LottoResult lottoResult = judge.draw();
                    assertThat(lottoResult.fifth()).isEqualTo(1);
                    assertThat(lottoResult.fourth()).isEqualTo(1);
                    assertThat(lottoResult.third()).isEqualTo(1);
                    assertThat(lottoResult.second()).isEqualTo(2);
                    assertThat(lottoResult.first()).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 41, 42, 43),
                List.of(1, 2, 3, 4, 42, 43),
                List.of(1, 2, 3, 4, 5, 43),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 6, 7),
                List.of(1, 2, 3, 4, 5, 6)
        );

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}