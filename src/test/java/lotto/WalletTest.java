package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WalletTest {
    @DisplayName("구입 금액에 숫자가 아닌 값이 있으면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자아님", "notNumber", "1섞어2MIX3"})
    void createWinningLottoByNonNumericValueBonusNumber(String money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 구입 금액에 숫자가 아닌 값이 들어왔습니다.");
    }
}
