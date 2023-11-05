package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
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
        assertThatThrownBy(() -> lottoMachine.insertMoney("-500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력한 값이 0 이하의 숫자입니다.");
    }

    @DisplayName("입력한 값을 1000으로 나눌 수 없는 경우 예외가 발생한다.")
    @Test
    void insertMoney_notDividedWithThousand() {
        assertThatThrownBy(() -> lottoMachine.insertMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000으로 나눠 떨어지지 않습니다.");
    }

    @DisplayName("생성된 숫자가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void generateLottoNumbers_notSixNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(() -> lottoMachine.generateLottoNumbers())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42)
        );
    }

    @DisplayName("생성된 숫자 중 중복되는 값이 있는 경우 예외가 발생한다.")
    @Test
    void generateLottoNumbers_duplicateNumber() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(() -> lottoMachine.generateLottoNumbers())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 41)
        );
    }

    @DisplayName("생성된 값 중에 1~45의 범위가 아닌 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void generateLottoNumbers_numberNotInRange() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(() -> lottoMachine.generateLottoNumbers())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("[ERROR]");
                },
                List.of(8, 100, 23, 41, 50, 10)
        );
    }
}