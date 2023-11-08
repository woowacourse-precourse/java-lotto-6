package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberServiceTest {

    @Test
    @DisplayName("로또번호를 생성 할 수 있다.")
    void createRandomLottosTest() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Cost cost = new Cost(8000);
                    LottoNumberService lottoNumberService = new LottoNumberService();
                    Lottos lottos = lottoNumberService.createRandomLottos(cost);
                    assertThat(lottos.getLottosPrintFormat()).isEqualTo(
                            List.of("[8, 21, 23, 41, 42, 43]",
                                    "[3, 5, 11, 16, 32, 38]",
                                    "[7, 11, 16, 35, 36, 44]",
                                    "[1, 8, 11, 31, 41, 42]",
                                    "[13, 14, 16, 38, 42, 45]",
                                    "[7, 11, 30, 40, 42, 43]",
                                    "[2, 13, 22, 32, 38, 45]",
                                    "[1, 3, 5, 14, 22, 45]")
                    );
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
}
