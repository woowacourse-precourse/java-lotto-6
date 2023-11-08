package lotto.domain;

import lotto.exception.ErrorStatus;
import lotto.generator.NumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    private static class MockNumberGenerator implements NumbersGenerator {

        private final List<List<Integer>> numbers;
        private int index = 0;

        MockNumberGenerator(List<List<Integer>> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generate() {
            return numbers.get(index++);
        }
    }

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(
                new MockNumberGenerator(
                        List.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 7)
                        )
                )
        );
    }

    @DisplayName("1000원을 내면 로또 한 장을 받는다.")
    @Test
    void buyLottos() {
        //given
        //when
        Lottos lottos = lottoMachine.buyLottos(1000);
        //then
        assertThat(lottos.getLottos()).hasSize(1)
                .extracting("numbers")
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6)
                );
    }



    @DisplayName("로또를 구매할 때 금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 금액이 {0}원이면 예외가 발생한다.")
    @ValueSource(ints = {-2, 0, 500, 900, 999})
    void buyLottosException(int money) {
        //given
        //when
        //then
        assertThatThrownBy(() -> lottoMachine.buyLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.MONEY_RANGE_ERROR.getMessage());
    }

    @DisplayName("금액을 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 금액이 {0}원이면 예외가 발생한다.")
    @ValueSource(ints = {1001, 1999, 2001, 2500, 3500, 4500 })
    void buyLottosException2(int money) {
        //given
        //when
        //then
        assertThatThrownBy(() -> lottoMachine.buyLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.MONEY_UNIT_ERROR.getMessage());
    }

}