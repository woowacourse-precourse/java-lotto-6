package lotto.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class MyLottosTest {

    @Order(3)
    @ParameterizedTest
    @ValueSource(ints = {10, 5, 3})
    void 구입금액만큼_로또_생성_확인(int amount) {
        MyLottos myLottos = new MyLottos(amount);

        assertThat(myLottos.getLottos().size()).isEqualTo(amount);
    }
}