package lotto.view;

import static lotto.model.SystemConstant.DataType.INTEGER;
import static lotto.model.SystemConstant.DataType.INTEGER_LIST;
import static lotto.model.SystemConstant.DataType.LONG;
import static lotto.view.ErrorMessage.NOT_NUMBER;
import static lotto.view.InputView.inputData;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import lotto.model.SystemConstant.DataType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @AfterEach
    public void closeConsole() {
        Console.close();
    }

    @DisplayName("숫자 입력 테스트")
    @ParameterizedTest
    @MethodSource("provideInputAndDataType")
    void 정상테스트_inputData_Number(String input, DataType type) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        //when
        String result = inputData(type);
        //then
        assertThat(result).isEqualTo(input);
    }

    private static Stream<Arguments> provideInputAndDataType() {
        return Stream.of(
                Arguments.of("1423", LONG),
                Arguments.of("412312", LONG),
                Arguments.of("123123", LONG),
                Arguments.of("2147483647", LONG),
                Arguments.of("9223372036854775807", LONG),
                Arguments.of("1423", INTEGER),
                Arguments.of("412312", INTEGER),
                Arguments.of("123123", INTEGER),
                Arguments.of("2147483647", INTEGER)
        );
    }

    @DisplayName("타입에 맞지 않거나 숫자 타입 자료로 변환되지 않으면 예외발생")
    @ParameterizedTest
    @MethodSource("provideExceptionInputAndDataType")
    void 예외테스트_inputData_Number(String input, DataType type) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        //when
        assertThatThrownBy(() -> inputData(type))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER.getMessage());
    }

    private static Stream<Arguments> provideExceptionInputAndDataType() {
        return Stream.of(
                Arguments.of(" 1423", LONG),
                Arguments.of("412312 ", LONG),
                Arguments.of("123 123", LONG),
                Arguments.of("214748a3647", LONG),
                Arguments.of("9223372036854775808", LONG),
                Arguments.of(" 1423", INTEGER),
                Arguments.of("412a312", INTEGER),
                Arguments.of("123 123", INTEGER),
                Arguments.of("2147483648", INTEGER),
                Arguments.of("9223372036854775808", INTEGER)
        );
    }

    @DisplayName("int list 형 자료 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3,4,5", "6,4,5", "23,521,323,2,5,214123"})
    void 정상테스트_inputIntegerListData(String input) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String expect = input;
        //when
        String result = inputData(INTEGER_LIST);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("int list 형 자료로 변환되지 않으면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {" ,3,4,2", ",3,4,5", "3,4,5,", "3,4,5,,,,", ",,,,23,4,2", "3,4,5,,,,3,2", "a,s,d,v",
            "1,2,3,4,5,a"})
    void 예외테스트_inputIntegerListData(String input) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        //when
        assertThatThrownBy(() -> inputData(INTEGER_LIST))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
