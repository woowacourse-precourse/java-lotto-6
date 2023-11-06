package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {

    @Test
    @DisplayName("로또 구입 금액은 1000원 단위가 아니면 예외가 발생한다.")
    void addBalance_multiplesOfThousand_exception() {

        Wallet wallet = new Wallet();

        int testMoney = 1_500;

        assertThatThrownBy(() -> wallet.addBalance(testMoney))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("로또 구입 금액은 1,000 ~ 100,000 사이가 아니라면 예외가 발생한다.")
    void addBalance_range_exception() {

        Wallet wallet = new Wallet();

        int testMoney = 101_000;

        assertThatThrownBy(() -> wallet.addBalance(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("addBalance 값 검증 테스트")
    void validate_addBalance() {

        Wallet wallet = new Wallet();

        int testMoney = 50_000;

        wallet.addBalance(testMoney);

        assertThat(wallet.getBalance()).isEqualTo(testMoney);
    }

    @Test
    @DisplayName("buyAllLotto 값 검증 테스트")
    void validate_buyAllLotto() {

        Wallet wallet = new Wallet();

        int testMoney = 10_000;
        wallet.addBalance(testMoney);

        wallet.buyAllLotto();

        assertThat(wallet.getBalance()).isEqualTo(0);
        assertThat(wallet.getLottos().size()).isEqualTo(10);
    }
}
