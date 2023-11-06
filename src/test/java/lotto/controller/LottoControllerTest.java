package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.enums.ErrorMassage.DUPLICATE_BONUS_NUMBER;
import static lotto.enums.ErrorMassage.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorMassage.INVALID_AMOUNT_UNIT;
import static lotto.enums.ErrorMassage.INVALID_LOTTO_COUNT;
import static lotto.enums.ErrorMassage.INVALID_NUMBER;
import static lotto.enums.ErrorMassage.NOT_ENOUGH_AMOUNT;
import static lotto.enums.ErrorMassage.OUT_OF_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    @Test
    void 구입_금액을_잘못_입력하면_에러_메시지를_출력한다() {
        assertSimpleTest(() -> {
            run("3000a", "900", "2020", "1000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    INVALID_NUMBER.getMassage(),
                    NOT_ENOUGH_AMOUNT.getMassage(),
                    INVALID_AMOUNT_UNIT.getMassage()
            );
        });
    }

    @Test
    void 구입_금액을_올바르게_입력하면_개수만큼_로또를_구매한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[10, 11, 12, 13, 14, 15]",
                            "[16, 17, 18, 19, 20, 21]"
                    );
                },
                List.of(10, 11, 12, 13, 14, 15),
                List.of(16, 17, 18, 19, 20, 21)
        );
    }

    @Test
    void 당첨_번호를_잘못_입력하면_에러_메시지를_출력한다() {
        assertSimpleTest(() -> {
            run("8000", "1.2.3.45,6", "65,1,2,3,4,5", "41,41,1,2,3,4", "1,2,3,4,5,6,7", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    INVALID_NUMBER.getMassage(),
                    OUT_OF_RANGE_LOTTO_NUMBER.getMassage(),
                    DUPLICATE_LOTTO_NUMBER.getMassage(),
                    INVALID_LOTTO_COUNT.getMassage()
            );
        });
    }

    @Test
    void 당첨_번호를_올바르게_입력하면_보너스_번호를_입력한다() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                "보너스 번호를 입력해 주세요."
            );
        });
    }

    @Test
    void 보너스_번호를_잘못_입력하면_에러_메시지를_출력한다() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "1a", "6", "65", "7");
            assertThat(output()).contains(
                    INVALID_NUMBER.getMassage(),
                    DUPLICATE_BONUS_NUMBER.getMassage(),
                    OUT_OF_RANGE_LOTTO_NUMBER.getMassage()
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}