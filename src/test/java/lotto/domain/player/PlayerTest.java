package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    List<Integer> numbers;
    Lotto lotto;
    LottoNumber bonusNumber;
    PurchaseAmount purchaseAmount;
    Player player;

    @BeforeEach
    void setUp() {
        // given
        numbers = List.of(1, 2, 3, 4, 5, 6);
        lotto = Lotto.create(numbers);
        bonusNumber = LottoNumber.create(7);
        purchaseAmount = PurchaseAmount.create(8000);

    }

    @Test
    @DisplayName("Player 객체를 생성한다.")
    void create() {
        // when
        player = Player.create(lotto, bonusNumber, purchaseAmount);

        // then
        Assertions.assertThat(player.getLotto().getIntegerNumbers()).isEqualTo(numbers);
        Assertions.assertThat(player.getBonusNumber()).isEqualTo(bonusNumber.getLottoNumber());
        Assertions.assertThat(player.getPurchaseAmount()).isEqualTo(purchaseAmount.getPurchaseAmount());
    }

    @Test
    @DisplayName("주어진 구입 금액을 로또 가격으로 나누어 구입 가능 로또 개수를 반환한다.")
    void getPurchasedLottoCount() {
        // when
        int purchasedLottoCount = purchaseAmount.calculatePurchasedLottoCount(purchaseAmount);

        // then
        Assertions.assertThat(purchasedLottoCount).isEqualTo(8);
    }
}