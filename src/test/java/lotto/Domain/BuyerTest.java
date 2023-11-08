package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyerTest {

    Buyer buyer = new Buyer();

    @DisplayName("1000단위 금액 외 입력 시 로또 구입 불가능")
    @ParameterizedTest
    @ValueSource(ints = {1001, 3, 500})
    void buyLottoDividedByNotThousand(int purchaseAmount) {
        assertThatThrownBy(() -> buyer.buyLotto(purchaseAmount))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("1000단위 금액 입력 시 로또 구입 가능")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 5000, 12000})
    void buyLottoTest(int purchaseAmount) {
        buyer.buyLotto(purchaseAmount);

        assertThat(buyer.getPurchasedLotteries().size()).isEqualTo(purchaseAmount / 1000);
    }

    @DisplayName("구입 금액에 맞춰 로또 리스트 생성")
    @Test
    void getPurchasedLotteries() {
        buyer.buyLotto(5000);

        var count = buyer.getPurchasedLotteries().size();

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("로또 구입금 가져옴")
    @Test
    void getPurchaseAmount() {
        buyer.buyLotto(5000);

        var amount = buyer.getPurchaseAmount();

        assertThat(amount).isEqualTo(5000);
    }
}