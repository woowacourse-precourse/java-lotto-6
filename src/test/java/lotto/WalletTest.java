package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import lotto.model.Lotto;
import lotto.model.Wallet;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
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

    @DisplayName("구입 금액이 null이거나 비어있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createWalletByNullOrEmptyMoney(String money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                        + maximumPurchaseAmount + "원.");
    }

    @DisplayName("구입 금액이 최대금액을 넘는 경우 예외가 발생한다.")
    @Test
    void createWalletByNullMoney() {
        Integer inputMoney = maximumPurchaseAmount + 1000;

        assertThatThrownBy(() -> new Wallet(inputMoney.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                        + maximumPurchaseAmount + "원.");
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "51007", "0"})
    void createWalletByNotDivisibleBy1000(String money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                        + maximumPurchaseAmount + "원.");
    }

    @DisplayName("구입 금액이 정상적으로 들어온 경우.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "45000", "999999000"})
    void createWinningLottoByNormal(String money) throws NoSuchFieldException, IllegalAccessException {
        Wallet wallet = new Wallet(money);

        Field privateMoney = Wallet.class.getDeclaredField("money");
        privateMoney.setAccessible(true);
        int walletPrivateMoney = (int) privateMoney.get(wallet);

        assertEquals(walletPrivateMoney, Integer.parseInt(money));
    }
}
