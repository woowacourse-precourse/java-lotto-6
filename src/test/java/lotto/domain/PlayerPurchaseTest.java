package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.PlayerPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerPurchaseTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abc", "0", "156", "1234"})
    @DisplayName("잘못된 구입 금액을 입력하면 예외가 발생한다.")
    void inputLottoPrice(String inputPrice) {
        assertThatThrownBy(() -> new PlayerPurchase(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입한 로또 개수")
    void calculateLottoCount() {
        PlayerPurchase playerPurchase = new PlayerPurchase("8000");
        assertThat(playerPurchase.calculateLottoCount()).isEqualTo(8);
    }
}
