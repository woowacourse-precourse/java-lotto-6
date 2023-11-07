package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseTest {
    private LottoPurchase lottoPurchase;

    @BeforeEach
    void setUp() {
        lottoPurchase = new LottoPurchase();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void lottoPurchaseAmountTest() {
        int purchaseAmount = 5;
        List<Lotto> purchaseLottos = lottoPurchase.purchaseLottoNumbers(purchaseAmount);

        assertThat(purchaseAmount).isEqualTo(purchaseLottos.size());
    }

    @Test
    @DisplayName("로또 가격인 1000원보다 아래인 돈을 입력할 시 재입력한다.")
    void purchasePriceInsufficientPrice() {
        consoleInput("500", "8000");
        int purchasePrice = lottoPurchase.inputPurchasePrice();

        assertThat(purchasePrice).isEqualTo(lottoPurchase.getPurchasePrice());
    }

    @Test
    @DisplayName("문자열을 입력할 시 재입력한다.")
    void purchasePriceIncorrectPrice() {
        consoleInput("j", "8000");
        int purchasePrice = lottoPurchase.inputPurchasePrice();

        assertThat(purchasePrice).isEqualTo(lottoPurchase.getPurchasePrice());
    }

    @Test
    @DisplayName("1000원으로 안 나누어질시 재입력한다.")
    void purchasePriceDividePrice() {
        consoleInput("1500", "8000");
        int purchasePrice = lottoPurchase.inputPurchasePrice();

        assertThat(purchasePrice).isEqualTo(lottoPurchase.getPurchasePrice());
    }

    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
