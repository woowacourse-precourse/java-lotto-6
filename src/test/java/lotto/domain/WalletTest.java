package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WalletTest {
    /*@ParameterizedTest
    @ValueSource(ints = {14500,13600,15210})
    @DisplayName("로또 구매시 잔금이 남아 구매를 할 수 없다.")
    void createRemain(int wallet){
        assertThatThrownBy(() -> new Wallet(wallet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "15000,15", "16000,16"}, delimiter = ',')
    @DisplayName("로또 구입을 얼만큼 할 수 있는지 확인한다.")
    void createCount(int wallet, int count){
        // given
        Wallet test = new Wallet(wallet);

        // when
        int ticketCount = test.ticketCount();

        // then
        assertThat(ticketCount).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"8000,5000"}, delimiter = ',')
    @DisplayName("로또 수익률을 계산한다.")
    void createReturns(int wallet, int prizeAmount){
        // given
        Wallet test = new Wallet(wallet);

        // when
        double returns = test.returnsPercent(prizeAmount);

        // then
        assertThat(returns).isEqualTo(62.5);
    }*/
}
