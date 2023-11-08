package lotto.exception;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvalidInputTest {
    private ByteArrayOutputStream output;
    @BeforeEach
    void setUp(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @DisplayName("로또 번호가 (,)를 기준으로 구분되지 않으면 예외가 발생한다.")
    @Test
    void commaSeparatedFormatException(){
        //given
        InvalidInput invalidInput = new InvalidInput();
        String numbers = "1 2 3 4 5 6";

        //when
        boolean isNotCommaSeparated = invalidInput.commaSeparatedFormatException(numbers);

        //then
        assertThat(isNotCommaSeparated).isEqualTo(true);
        assertThat(output.toString()).contains("[ERROR] 로또 번호는 (,)를 기준으로 구분되어야 한다.");
    }

    @DisplayName("로또 넘버가 중복된 숫자면 예외가 발생한다.")
    @Test
    void duplicateNumberException(){
        //given
        InvalidInput invalidInput = new InvalidInput();

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3, 3, 5, 6));

        //when
        boolean isDuplicate = invalidInput.duplicateNumbersException(numbers);
        //then
        assertThat(isDuplicate).isEqualTo(true);
        assertThat(output.toString().contains("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다."));
    }

    @DisplayName("숫자가 1~45 범위가 아니면 예외가 발생한다.")
    @Test
    void outOfRangeException(){
        //given
        InvalidInput invalidInput = new InvalidInput();
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3, 4, 5, 100));

        //when
        boolean isOutOfRange = invalidInput.outOfRangeNumbersException(numbers);
        //then
        assertThat(isOutOfRange).isEqualTo(true);
        assertThat(output.toString().contains("[ERROR] 로또 번호의 숫자 범위는 1 ~ 45까지이다."));
    }

    @DisplayName("숫자가 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void notIntegerValueException(){
        //given
        InvalidInput invalidInput = new InvalidInput();
        String number = "a";

        //when
        boolean isNotInteger = invalidInput.notIntegerValueException(number);

        //then
        assertThat(isNotInteger).isEqualTo(true);
        assertThat(output.toString().contains("[ERROR] 번호와 금액은 정수여야 합니다."));
    }

    @DisplayName("로또가 6개의 숫자로 이루어져 있지 않으면 예외가 발생한다.")
    @Test
    void sizeExceededException(){
        //given
        InvalidInput invalidInput = new InvalidInput();
        List<Integer> numbers = new ArrayList<>();

        numbers.addAll(List.of(1, 2, 3, 4, 5, 6, 7));

        //when
        boolean isExceeded = invalidInput.sizeExceededException(numbers);

        //then
        assertThat(isExceeded).isEqualTo(true);
        assertThat(output.toString().contains("[ERROR] 로또는 6개의 숫자여야 합니다."));

    }

    @DisplayName("입력 받은 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void notThousandUnitException(){
        //given
        InvalidInput invalidInput = new InvalidInput();
        int cost = 500;

        //when
        boolean isNotThousand = invalidInput.notThousandUnitException(cost);

        // then
        assertThat(isNotThousand).isEqualTo(true);
        assertThat(output.toString().contains("[ERROR] 구입 금액은 1000 단위여야 한다."));

    }

}