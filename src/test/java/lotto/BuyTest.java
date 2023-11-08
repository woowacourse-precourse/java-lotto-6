package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyTest extends NsTest {
    @DisplayName("입력한 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputPriceNotNumeric() {
        assertSimpleTest(() -> {
            runException("abcd");
            assertThat(output()).contains(ErrorMessage.NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("입력한 구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void inputPriceNotMultipleOfThousand() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(ErrorMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        });
    }

    @DisplayName("입력한 구입 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void inputPriceNotPositive() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
        });
    }

    @DisplayName("입력한 구입 금액만큼 로또를 구입한다.")
    @Test
    void buyLottoAccordingToPrice() {
        assertSimpleTest(() -> {
            runException("15000");
            assertThat(output()).contains("15개를 구매했습니다.");
        });
    }

    @DisplayName("구입한 로또가 오름차순으로 정렬되었는지 확인한다.")
    @Test
    void buyLottoAscendingSort() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[1, 2, 3, 4, 5, 6]",
                            "[3, 5, 13, 15, 25, 45]"
                    );
                },
                List.of(6, 5, 4, 3, 2, 1),
                List.of(45, 3, 25, 15, 5, 13)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
