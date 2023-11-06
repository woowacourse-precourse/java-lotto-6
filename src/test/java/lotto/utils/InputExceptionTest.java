package lotto.utils;

import lotto.domain.PrintMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "22000"})
    @DisplayName("입력이 숫자인지 확인하는 메서드 테스트")
    void isDigitTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isDigit(input);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "thousandwon", "1000won"})
    @DisplayName("입력이 숫자인지 확인하는 메서드 예외처리 테스트")
    void isDigitExceptionTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isDigit(input);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_DIGIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 20000})
    @DisplayName("입력이 천원 단위인지 확인하는 메서드 테스트")
    void isThousandUnitTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isThousandUnit(num);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1001, 2020, 23300})
    @DisplayName("입력이 천원 단위인지 확인하는 메서드 예외처리 테스트")
    void isThousandUnitExceptionTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isThousandUnit(num);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_THOUSAND_UNIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000,2000,30000", "100000,5000,77000"})
    @DisplayName("번호를 쉼표(,)로 숫자를 나누었는지 확인하는 메서드 테스트")
    void isContainCommaTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isContainComma(input);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000/2000/30000", "100000.5000.77000"})
    @DisplayName("번호를 쉼표(,)로 숫자를 나누었는지 확인하는 메서드 예외처리 테스트")
    void isContainCommaExceptionTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isContainComma(input);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SPLIT_COMMA);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 20, 30, 40, 44, 45})
    @DisplayName("번호가 1에서 45 사이의 숫자인지 확인하는 메서드 테스트")
    void isBetweenOneAndFourtyfiveTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isBetweenOneAndFourtyfive(num);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0, 46, 100})
    @DisplayName("번호가 1에서 45 사이의 숫자인지 확인하는 메서드 예외처리 테스트")
    void isBetweenOneAndFourtyfiveExceptionTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isBetweenOneAndFourtyfive(num);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.BETWEEN_ONE_AND_FORTYFIVE);
    }

    @Test
    @DisplayName("번호가 중복되는지 확인하는 메서드 테스트")
    void isDuplicationTest() {
        // given
        List<List<Integer>> lists = new ArrayList<>(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 6, 10, 14, 18, 22),
                List.of(5, 10, 20, 30, 40, 45)
        ));

        // when
        Throwable throwable1 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(0));
        });
        Throwable throwable2 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(1));
        });
        Throwable throwable3 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(2));
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
        assertThat(throwable3).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("번호가 중복되는지 확인하는 메서드 예외처리 테스트")
    void isDuplicationExceptionTest() {
        // given
        List<List<Integer>> lists = new ArrayList<>(List.of(
                List.of(1, 1, 3, 4, 5, 6),
                List.of(2, 6, 6, 6, 18, 22),
                List.of(5, 20, 20, 30, 45, 45),
                List.of(5, 15, 20, 30, 15, 45)
        ));

        // when
        Throwable throwable1 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(0));
        });
        Throwable throwable2 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(1));
        });
        Throwable throwable3 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(2));
        });
        Throwable throwable4 = catchThrowable(() -> {
            InputException.isDuplication(lists.get(3));
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATION);
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATION);
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATION);
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATION);
    }

    @Test
    @DisplayName("리스트의 길이를 확인하는 메서드 테스트")
    void checkSizeTest() {
        // given
        List<List<Integer>> lists = new ArrayList<>(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 6, 10, 14, 18, 22),
                List.of(5, 10, 20, 30, 40, 45)
        ));

        // when
        Throwable throwable1 = catchThrowable(() -> {
            InputException.checkSize(lists.get(0));
        });
        Throwable throwable2 = catchThrowable(() -> {
            InputException.checkSize(lists.get(1));
        });
        Throwable throwable3 = catchThrowable(() -> {
            InputException.checkSize(lists.get(2));
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
        assertThat(throwable3).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("리스트의 길이를 확인하는 메서드 예외처리 테스트")
    void checkSizeExceptionTest() {
        // given
        List<List<Integer>> lists = new ArrayList<>(List.of(
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        ));

        // when
        Throwable throwable1 = catchThrowable(() -> {
            InputException.checkSize(lists.get(0));
        });
        Throwable throwable2 = catchThrowable(() -> {
            InputException.checkSize(lists.get(1));
        });
        Throwable throwable3 = catchThrowable(() -> {
            InputException.checkSize(lists.get(2));
        });
        Throwable throwable4 = catchThrowable(() -> {
            InputException.checkSize(lists.get(3));
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SIX_NUMBER);
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SIX_NUMBER);
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SIX_NUMBER);
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SIX_NUMBER);
    }
}