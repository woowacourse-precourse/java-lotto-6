package lotto.model;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤_로또_생성기_테스트")
class LottoSalesOfficeTest {

    @Test
    @DisplayName("랜덤_로또_생성_테스트")
    void generate() {
        LottoSalesOffice salesOffice = new LottoSalesOffice();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lotto = salesOffice.buyLottos(2);
                    assertThat(lotto.get(0).getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    assertThat(lotto.get(1).getNumbers()).isEqualTo(List.of(2, 3, 4, 5, 6, 7));
                },
                List.of(6, 5, 4, 3, 2, 1)
                , List.of(2, 3, 4, 5, 6, 7)
        );

    }

}