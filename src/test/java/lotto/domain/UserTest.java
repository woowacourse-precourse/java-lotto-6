package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserTest {

    @DisplayName("사용자가 로또 구매시, 로또 개수와 로또 생성")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void purchaseLotto(String money, Integer lottoCount) {

        // given
        User user = new User();

        // when
        user.purchaseLotto(new Money(money));

        // then
        assertThat(user.lottoCount).isEqualTo(lottoCount);
        assertThat(user.lottos).isNotEmpty();

    }

}