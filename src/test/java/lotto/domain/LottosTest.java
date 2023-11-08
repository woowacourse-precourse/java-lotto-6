package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest extends NsTest {

    @DisplayName("구입 금액에 따라 구입한 개수만큼 로또가 랜덤 번호를 기반으로 생성된다.")
    @Test
    void getLottos() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        // when, then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = new Lottos(purchaseAmount);
                    System.out.println(lottos);
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @DisplayName("Lottos가 가지고 있는 로또의 개수를 알려준다.")
    @Test
    void getLottoCount() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto));
        int expectedResult = 2;
        // when, then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedResult);
    }

    @DisplayName("로또들의 당첨 결과를 만든다.")
    @Test
    void getLottosResult() {
        // given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinnigMachine winnigMachine = new WinnigMachine(winningLotto, bonusNumber);
        Map<Prize, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Prize.FIRST, 1);
        expectedResult.put(Prize.SECOND, 1);
        expectedResult.put(Prize.THIRD, 1);
        expectedResult.put(Prize.FOURTH, 1);
        expectedResult.put(Prize.FIFTH, 2);
        // when
        Map<Prize, Integer> lottosResult = lottos.getLottosResult(winnigMachine);
        // then
        assertThat(lottosResult).isEqualTo(expectedResult);
    }

    @DisplayName("Lottos가 가지고 있는 로또들의 String을 반환한다.")
    @Test
    void getLottosString() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto));
        String expectedResult = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 7]";
        // when, then
        assertThat(lottos.toString()).isEqualTo(expectedResult);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}