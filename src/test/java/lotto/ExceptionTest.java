package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final InputValidator inputValidator = new InputValidator();

    @BeforeEach()
    void setEach() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","-1000000"})
    void 음수인_금액_입력_테스트(String negativeNumber){

        assertThatThrownBy(() -> inputValidator.amountValidator(negativeNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음수를 입력받았습니다. : " + negativeNumber);

    }
    @ParameterizedTest
    @ValueSource(strings = {"notNumber","<>","-="})
    void 숫자가_아닌_금액_입력_테스트(String notNumber){

        assertThatThrownBy(() -> inputValidator.amountValidator(notNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자가 아닙니다. : " + notNumber);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5","10,9,45,1,45"})
    void 중복된_로또_번호_입력_테스트(String overlapNumber){

        assertThatThrownBy(() -> inputValidator.numbersValidator(overlapNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자 입니다. : ");

    }

    @ParameterizedTest
    @ValueSource(strings = {"100,2,3,4,5,6","10,9,45,1,0"})
    void 범위를_벗어난_로또_번호_입력_테스트(String overRangeNumber){

        assertThatThrownBy(() -> inputValidator.numbersValidator(overRangeNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 범위를 벗어난 숫자입니다. : ");

    }

    @ParameterizedTest
    @ValueSource(strings = {"notNumber,2,3,4,5,6","10,9,45,1,-=","1,2,3,,4,5"})
    void 숫자가_아닌_로또_번호_입력_테스트(String notNumber){

        assertThatThrownBy(() -> inputValidator.numbersValidator(notNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닙니다. : ");

    }

    @ParameterizedTest
    @ValueSource(strings = {"notNumber","-=",""})
    void 숫자가_아닌_보너스_번호_입력_테스트(String notNumber){

        List<Integer> lottoNumbers = List.of(5,10,15,20,25,30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닙니다. : ");

    }

    @ParameterizedTest
    @ValueSource(strings = {"46","0"})
    void 범위를_벗어난_보너스_번호_입력_테스트(String notNumber){

        List<Integer> lottoNumbers = List.of(5,10,15,20,25,30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 범위를 벗어난 숫자입니다. : ");

    }

    @ParameterizedTest
    @ValueSource(strings = {"10","30"})
    void 중복된_보너스_번호_입력_테스트(String notNumber){

        List<Integer> lottoNumbers = List.of(5,10,15,20,25,30);

        assertThatThrownBy(() -> inputValidator.bonusValidator(lottoNumbers, notNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자 입니다. : ");

    }

}
