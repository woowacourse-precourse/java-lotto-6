package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyTest {

    @DisplayName("1000단위로 구매하지 않으면 예외가 발생한다.")
    @Test
    void enterMoneyByMissMatchUnit() {
        Assertions.assertThatThrownBy(() -> new Buy("14300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000단위로 구매하면 구매할수 장수를 반환")
    @Test
    void enterMoneyByCorrectUnit() {
        Assertions.assertThat(new Buy("14000").getCount()).isEqualTo(14);
    }
}