package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import lotto.model.Wallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WalletTest {
    static Integer maximumPurchaseAmount;

    @BeforeAll
    public static void getConstantValue() throws NoSuchFieldException, IllegalAccessException {
        Wallet wallet = new Wallet("1000");

        Field privateMaximumPurchaseAmount = Wallet.class.getDeclaredField("MAXIMUM_PURCHASE_AMOUNT");
        privateMaximumPurchaseAmount.setAccessible(true);

        maximumPurchaseAmount = (Integer) privateMaximumPurchaseAmount.get(wallet);
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
        int inputMoney = maximumPurchaseAmount + 1000;

        assertThatThrownBy(() -> new Wallet(String.valueOf(inputMoney)))
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

    @DisplayName("로또를 구입할 금액이 있으면 true를 반환한다.")
    @Test
    void CanBuyLottoInGeneralCase() {
        Wallet wallet = new Wallet("2000");

        assertTrue(wallet.canBuyLotto());
    }

    @DisplayName("로또를 구입할 금액이 없으면 false를 반환한다.")
    @Test
    void CanBuyLottoInFailedCase() {
        Wallet wallet = new Wallet("1000");

        wallet.buyLotto();

        assertFalse(wallet.canBuyLotto());
    }

    @DisplayName("수익률 계산이 잘 이루어지는지 확인한다. (소수점 둘째 자리에서 반올림)")
    @Test
    void testCalculateProfitRate() {
        Wallet wallet = new Wallet("10000");

        assertEquals(4.3, wallet.calculateProfitRate(2300));
        assertEquals(4.2, wallet.calculateProfitRate(2400));
        assertEquals(0.0, wallet.calculateProfitRate(0));
    }

    @DisplayName("수익 계산이 잘 이루어지는지 확인한다.")
    @Test
    void testCalculateProfit() {
        Wallet wallet = new Wallet("10000");
        Map<Integer, Integer> lottoesResult = new HashMap<>();

        for (int lottoRank = 1; lottoRank <= 5; lottoRank++) {
            lottoesResult.put(lottoRank, lottoRank);
        }

        assertEquals(2064725000L, wallet.calculateProfit(lottoesResult));
    }
}
