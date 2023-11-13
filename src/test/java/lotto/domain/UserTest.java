package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserTest {
    private User user;

    @BeforeEach
    void beforeEach() {
        user = new User();
    }

    @DisplayName("사용자가 로또 구매시, 구매 가격에 따라 로또 개수 생성")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void purchaseLottoCount(String money, Integer lottoCount) {
        // when
        user.purchaseLotto(new Money(money));

        // then
        assertThat(user.lottoCount).isEqualTo(lottoCount);
    }

    @DisplayName("사용자가 로또 구매시, 구매 가격에 따라 로또 생성")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void purchaseLottos(String money, Integer lottoCount) {
        // when
        user.purchaseLotto(new Money(money));

        // then
        assertThat(user.lottos).isNotEmpty();
        assertThat(user.lottos.size()).isEqualTo(lottoCount);
    }
}