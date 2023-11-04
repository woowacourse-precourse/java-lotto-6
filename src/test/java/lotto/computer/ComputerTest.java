package lotto.computer;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerTest {

    private Computer computer;

    public ComputerTest() {
        this.computer = new Computer();
    }

    @ParameterizedTest
    @MethodSource("lotto.computer.MoneyArgumentsProvider#provideCorrectInput")
    @DisplayName("사용자 로또 발급")
    void 사용자_로또_발급(int money) {
        Lottos userLottos = computer.createUserLottos(money);
        assertThat(userLottos.lottos().size()).isEqualTo(money / 1000);
    }
}