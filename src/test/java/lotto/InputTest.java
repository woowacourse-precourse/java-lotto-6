package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputTest 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputTest {



    private void setUp(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000"})
    public void rightAmountInput(String console){
        //given
        setUp(console);
        // then
        int expect = 8000;
        int actual = Input.getAmount();
        assertThat(expect).isEqualTo(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    public void testAmountValid(String wrongAmount) {
        //given
        setUp(wrongAmount);

        // then
        assertThatThrownBy(() -> {
                    Input.getAmount();
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void inputLottoNumberRight(String rightNumbers){
        //given
        setUp(rightNumbers);

        //when
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = Input.getLottoNumbers();

        //then
        assertThat(expect).isEqualTo(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    public void testValidLottoFormat(String wrongFormat) {
        //given
        setUp(wrongFormat);

        // then
        assertThatThrownBy(() -> {
            Input.getLottoNumbers();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,46"})
    public void testLottoRangeValid(String wrongNumbers) {
        //given
        setUp(wrongNumbers);

        // then
        assertThatThrownBy(() -> {
            Input.getLottoNumbers();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7"})
    public void testBonusNumber(String bonusNumber) {
        //given
        setUp(bonusNumber);

        // when
        int expect = 7;

        assertThat(expect).isEqualTo(Input.getBonusNumber());
    }
}
