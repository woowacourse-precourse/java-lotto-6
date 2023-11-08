package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("입력 값을 정수로 변환할 수 없는 경우 테스트")
    @Test
    void insertMoney_notParsableNumber() {
        assertThatThrownBy(() -> new LottoMachine().insertMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수인 경우 테스트")
    @Test
    void insertMoney_notPositiveNumber() {
        assertThatThrownBy(() -> new LottoMachine().insertMoney("-123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1000으로 나눠 떨어지지 않는 경우 테스트")
    @Test
    void insertMoney_notDividedWithThousand() {
        assertThatThrownBy(() -> new LottoMachine().insertMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 문제가 없는 경우 테스트")
    @Test
    void insertMoney_success() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insertMoney("2000");
        assertThat(lottoMachine.lottoCount).isEqualTo(2);
    }

    @DisplayName("입력값에 맞는 개수의 로또가 생성되었는지 테스트")
    @Test
    void generateLottoBundle_success() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insertMoney("2000");
        lottoMachine.generateLottoBundle();
        assertThat(lottoMachine.lottoBundle.size()).isEqualTo(2);
    }

}