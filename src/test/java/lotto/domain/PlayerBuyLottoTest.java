package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerBuyLottoTest {

    @ParameterizedTest
    @CsvSource({"j","1111","-1"})
    @DisplayName("올바르지 않은 금액일 경우")
    void failedBuying(String inputBuy) {
        assertThatThrownBy(() -> new PlayerBuyLotto(inputBuy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1000,1","8000,8"})
    @DisplayName("올바르지 않은 금액일 경우")
    void calcLottoCount(String number1, int amount){
        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto(number1);
        int result = playerBuyLotto.calcLottoCount();
        assertThat(result).isEqualTo(amount);
    }
}