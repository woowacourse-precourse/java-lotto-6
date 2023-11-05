package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Util.LottoNumGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    List<Lotto> lottos;

    @DisplayName("3개의 로또를 발행한다.")
    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(LottoNumGenerator.generate()),
                new Lotto(LottoNumGenerator.generate()),
                new Lotto(LottoNumGenerator.generate()));
    }

    @DisplayName("1000원 단위의 돈이 아니라면 예외가 발생한다.")
    @Test
    void createUserByNotLottoPriceUnitMoney() {
        int money = 1100;
        Assertions.assertThatThrownBy(() -> new User(money, lottos)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만의 돈이라면 예외가 발생한다.")
    @Test
    void createUserByLowerThanLottoPriceUnit() {
        int money = 900;
        Assertions.assertThatThrownBy(() -> new User(money, lottos)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매할 돈의 단위 갯수와 구매된 로또의 갯수가 같지 않으면 예외가 발생한다.")
    @Test
    void createUserByNotConsistentLottoNumWithUnitMoney() {
        int money = 2000;
        Assertions.assertThatThrownBy(() -> new User(money, lottos)).isInstanceOf(IllegalArgumentException.class);

    }

}