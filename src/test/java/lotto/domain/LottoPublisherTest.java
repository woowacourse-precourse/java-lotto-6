package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPublisherTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1500", "-1000"})
    void 구입_금액이_올바르지_않을_경우(String money) {
        assertThatThrownBy(() -> new LottoPublisher(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2000", "100000"})
    void 발행한_로또_갯수_확인(String money) {
        LottoPublisher lottoPublisher = new LottoPublisher(money);

        int expectedLottoAmount = Integer.parseInt(money) / PURCHASE_UNIT.getNumber();
        int actualLottoAmount = lottoPublisher.getLottoAmount();

        assertEquals(expectedLottoAmount, actualLottoAmount);
    }

    @Test
    void 로또_발행() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    LottoPublisher lottoPublisher = new LottoPublisher("3000");
                    List<Lotto> userLottos = lottoPublisher.getUserLottos();

                    assertThat(userLottos.get(0).getNumbers())
                            .containsExactly(10, 20, 30, 40, 50, 60);
                    assertThat(userLottos.get(1).getNumbers())
                            .containsExactly(3, 6, 9, 12, 15, 18);
                    assertThat(userLottos.get(2).getNumbers())
                            .containsExactly(4, 12, 20, 28, 36, 44);
                },
                List.of(10, 20, 30, 40, 50, 60),
                List.of(3, 6, 9, 12, 15, 18),
                List.of(4, 12, 20, 28, 36, 44)
        );
    }

}
