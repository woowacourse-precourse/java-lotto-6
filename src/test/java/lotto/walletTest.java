package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class walletTest {

    @DisplayName("천 단위로 입력된 금액이면 wallet 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 3_000, 4_000, 5_000, 100_000, 100_000_000})
    void createThousandUnitMoneyByThousandUnit(int thousandUnit) {
        Assertions.assertThat(new wallet(thousandUnit))
                .isInstanceOf(wallet.class);
    }

    @DisplayName("천 단위로 입력된 금액이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 2_021, 2_020, 3_400, 4_530, 5_431, 100_100_100, 100_100_001})
    void createThousandUnitMoneyByNotThousandUnit(int notThousandUnit) {
        Assertions.assertThatThrownBy(() -> new wallet(notThousandUnit))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void purchaseLottoTest() {
        wallet wallet = new wallet(1_000);

        Assertions.assertThat(wallet.buyLotto()).isInstanceOf(Lotto.class);
        Assertions.assertThatThrownBy(() -> wallet.buyLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
