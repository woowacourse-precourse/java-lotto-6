package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.WinningNumberTest.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.Model.CountLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyLottoTest extends ApplicationTest {

    @DisplayName("구매금액입력값에 따른 로또구매개수확인")
    @Test
    void LottoAmountCalculateTest() {
        // Given
        int buyAmount =10000;
        int expectedLottoCount = 10;

        // Act
        CountLotto countLotto = new CountLotto(buyAmount);
        int actualLottoCount = countLotto.getCountLotto();

        // Assert
        assertEquals(expectedLottoCount, actualLottoCount);
    }

    @DisplayName("유효하지않은 값일시 예외처리")
    @Test
    void moreCountTest() {
        assertSimpleTest(() -> {
            runException("3500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

}
