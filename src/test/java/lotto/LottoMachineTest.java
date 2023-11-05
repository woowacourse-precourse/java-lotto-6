package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    static LottoMachine lottoMachine;

    @BeforeAll
    public static void beforeAll() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("입력한 값을 정수로 변환할 수 없는 경우 예외가 발생한다.")
    @Test
    void insertMoney_notParsableNumber() {

        assertThatThrownBy(() -> lottoMachine.insertMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력한 값을 정수로 변환할 수 없습니다.");
    }

    @DisplayName("입력한 값이 0 이하의 정수인 경우 예외가 발생한다.")
    @Test
    void insertMoney_notValidNumber() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.insertMoney("-500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력한 값이 0 이하의 숫자입니다.");
    }

    @DisplayName("입력한 값을 1000으로 나눌 수 없는 경우 예외가 발생한다.")
    @Test
    void insertMoney_notDividedWithThousand() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.insertMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000으로 나눠 떨어지지 않습니다");
    }
}