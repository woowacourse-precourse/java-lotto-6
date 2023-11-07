package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import lotto.model.Wallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WalletTest {
    static Integer maximumPurchaseAmount;

    @BeforeAll
    public static void getConstantValue() throws NoSuchFieldException, IllegalAccessException {
        Wallet wallet = new Wallet("1000");

        Field privatemaximumPurchaseAmount = Wallet.class.getDeclaredField("MAXIMUM_PURCHASE_AMOUNT");
        privatemaximumPurchaseAmount.setAccessible(true);

        maximumPurchaseAmount = (Integer) privatemaximumPurchaseAmount.get(wallet);
    }

    @DisplayName("구입 금액에 숫자가 아닌 값이 있으면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자아님", "notNumber", "1섞어2MIX3"})
    void createWalletByNonNumericValueMoney(String money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 숫자가 아닌 값이 들어왔습니다.");
    }

    @DisplayName("구입 금액이 null인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createWalletByNullMoney(String money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                        + maximumPurchaseAmount + "원.");
    }

    @DisplayName("구입 금액이 최대금액을 넘는 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByNullOrEmptyBonusNumber() {
        Integer inputMoney = maximumPurchaseAmount + 1000;

        assertThatThrownBy(() -> new Wallet(inputMoney.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                        + maximumPurchaseAmount + "원.");
    }
}
