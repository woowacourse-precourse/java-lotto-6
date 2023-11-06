package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottosTest {
    NumbersGenerator numbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("입력받는 money값이 1000의 배수가 아니면 예외를 발생시킨다")
    @Test
    void createLottosByTenMultipleTest() {
        assertThatThrownBy(() -> new Lottos(1, numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 로또의 가격을 반환한다")
    @Test
    void getMoneyTest() {
        //given
        Lottos lottos = new Lottos(1000, numbersGenerator);

        //when
        int money = lottos.getMoney();

        //then
        Assertions.assertEquals(1000, money);
    }

    @DisplayName("모든 로또의 갯수를 반환한다")
    @Test
    void getAmountTest() {
        //given
        Lottos lottos = new Lottos(1000, numbersGenerator);

        //when
        int amount = lottos.getAmount();

        //then
        Assertions.assertEquals(1, amount);
    }

}
