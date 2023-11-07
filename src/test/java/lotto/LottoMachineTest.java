package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 발행기 테스트")
class LottoMachineTest {
    @DisplayName("성공: 입력한 금액에 맞게 로또번호를 생성할 수 있다.")
    @Test
    void test1() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.inputPurchasePrice(8000);
    }

    @DisplayName("실패: 금액이 나누어 떨어지지 않으면 에러가 발생한다.")
    @Test
    void test2() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThatCode(() -> lottoMachine.inputPurchasePrice(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessage.CHANGE);
    }
}