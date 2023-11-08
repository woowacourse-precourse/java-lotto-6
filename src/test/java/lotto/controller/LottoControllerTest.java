package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.MatchNumber;
import lotto.util.MatchRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
    LottoController lottoController = new LottoController();

    @DisplayName("당첨 숫자와 보너스 숫자가 합쳐졌는지 테스트")
    @Test
    void getTotalMatchNumbersTest() {
        assertSimpleTest(() -> {
            MatchNumber numbers = new MatchNumber("1,2,3,4,5,6");
            BonusNumber bonusNumber = new BonusNumber("7", numbers);

            assertThat(lottoController.getTotalMatchNumbers(numbers, bonusNumber))
                    .isEqualTo(List.of(1,2,3,4,5,6,7));
        });
    }

    @DisplayName("당첨 번호와 보너스 번호로 당첨 결과 테스트")
    @Test
    void matchResultTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lottos lottos = new Lottos(2);
                    List<Integer> totalMatchNumbers = List.of(1,2,3,4,5,6,7);

                    LottoManager lottoManager = lottoController.matchResult(lottos, totalMatchNumbers);
                    assertThat(lottoManager.getLottoResult()
                            .get(MatchRanking.FOURTH_PLACE)).isEqualTo(1);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 1, 2, 38)
        );
    }

    @DisplayName("당첨 번호와 보너스 번호로 당첨 결과 테스트")
    @Test
    void drawLottoNumbersTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    LottoPrice lottoPrice = new LottoPrice("2000");

                    Lottos lottos = lottoController.drawLottoNumbers(lottoPrice);
                    assertThat(lottos.getLottos().contains(List.of(8, 21, 23, 41, 42, 43)));
                    assertThat(lottos.getLottos().contains(List.of(3, 5, 11, 1, 2, 38)));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 1, 2, 38)
        );
    }

    @DisplayName("로또 구입 갯수 확인 테스트")
    @Test
    void countLottoTest() {
        assertSimpleTest(() -> {
            LottoPrice lottoPrice = new LottoPrice("7000");
            assertThat(lottoController.countLotto(lottoPrice)).isEqualTo(7);
        });
    }
}
