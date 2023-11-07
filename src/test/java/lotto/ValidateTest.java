package lotto;

import lotto.util.Validate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.*;

public class ValidateTest {

    private static Validate valid = new Validate();

    @DisplayName("구입 금액이 유효성 검사에 걸리는 테스트")
    @Test
    void purchaseMoneyInputTest() throws IOException {
        Assertions.assertThatThrownBy(() -> valid.getPurchaseMoney("1"))
            .hasMessage("[ERROR] 구입 금액은 1000원 이상의 1000의 배수만 입력이 가능합니다.");
    }

    @DisplayName("당첨 번호가 개수 유효성 검사에 걸리는 테스트")
    @Test
    void prizeNumbersInputTest1() throws IOException {
        Assertions.assertThatThrownBy(() -> valid.getPrizeNumbers("1,2,3,4,5"))
            .hasMessage("[ERROR] 당첨 번호는 6개가 입력되어야 합니다.");

    }

    @DisplayName("당첨 번호가 중복 유효성 검사에 걸리는 테스트")
    @Test
    void prizeNumbersInputTest2() throws IOException {
        Assertions.assertThatThrownBy(() -> valid.getPrizeNumbers("1,2,3,4,5,5"))
            .hasMessage("[ERROR] 중복된 숫자가 들어갈 수 없습니다.");
    }

    @DisplayName("당첨 번호가 범위 유효성 검사에 걸리는 테스트")
    @Test
    void prizeNumbersInputTest3() throws IOException {
        Assertions.assertThatThrownBy(() -> valid.getPrizeNumbers("1,2,3,4,5,47"))
            .hasMessage("[ERROR] 1~45까지의 숫자만 허용됩니다.");
    }
}