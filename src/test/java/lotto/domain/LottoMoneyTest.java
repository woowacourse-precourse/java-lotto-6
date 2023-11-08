package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @DisplayName("구입 금액이 올바르지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "2500", "-1000"})
    void createLottoMoneyByInvalidInput(String input) {
        assertThatThrownBy(() -> new LottoMoney(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액을 1000으로 나눈 숫자를 반환한다.")
    @Test
    void getLottoCount() {
        LottoMoney lottoMoney = new LottoMoney("5000");

        assertThat(lottoMoney.getLottoCount()).isEqualTo(5);
    }

    @DisplayName("정해진 갯수 만큼 로또를 구입한다.")
    @Test
    void buyLottosSatisfyLottoCount() {
        LottoMoney lottoMoney = new LottoMoney("5000");

        List<Lotto> result = lottoMoney.buyLottos();

        assertThat(result.size()).isEqualTo(5);
    }
}