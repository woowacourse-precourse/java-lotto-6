package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class UserTest {

    User user;

    @DisplayName("현금만큼 로또 구매수 구하기")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "10000,10", "22000, 22"}, delimiter = ',')
    public void 로또_구매수(String money, int number) {
        //given (주어진 값)
        user = new User(money);

        //when (기능 작동)
        List<Lotto> lottos = user.getLottos();

        //then (기능 작동 후 결과)
        Assertions.assertThat(lottos.size()).isEqualTo(number);
    }
}