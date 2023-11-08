package lotto.model;

import static lotto.common.ExceptionMessage.ERROR_NUMBERS_DUPLICATE;
import static lotto.common.ExceptionMessage.ERROR_NUMBERS_SIZE_INCORRECT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainNumbersTest {
    @DisplayName("주어진 문자열 리스트로부터 MainNumbers를 올바르게 생성한다.")
    @Test
    void createMainNumbersFromStrings() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
        MainNumbers mainNumbers = MainNumbers.from(numbers);

        assertThat(mainNumbers).extracting("mainNumbers", InstanceOfAssertFactories.list(MainNumber.class))
                .containsExactlyElementsOf(List.of(
                        MainNumber.from("1"),
                        MainNumber.from("2"),
                        MainNumber.from("3"),
                        MainNumber.from("4"),
                        MainNumber.from("5"),
                        MainNumber.from("6")));
    }

    @DisplayName("주어진 공백이 포함된 문자열 리스트로부터 MainNumbers를 올바르게 생성한다.")
    @Test
    void createMainNumbersFromStringsWithBlank() {
        List<String> numbers = List.of("1 ", " 2 ", "3", "4", "5", " 6");
        MainNumbers mainNumbers = MainNumbers.from(numbers);

        assertThat(mainNumbers).extracting("mainNumbers", InstanceOfAssertFactories.list(MainNumber.class))
                .containsExactlyElementsOf(List.of(
                        MainNumber.from("1"),
                        MainNumber.from("2"),
                        MainNumber.from("3"),
                        MainNumber.from("4"),
                        MainNumber.from("5"),
                        MainNumber.from("6")));
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외를 던진다.")
    @Test
    void throwExceptionForIncorrectSize() {
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        assertThatThrownBy(() -> MainNumbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NUMBERS_SIZE_INCORRECT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외를 던진다.")
    @Test
    void throwExceptionForDuplicateNumbers() {
        List<String> duplicateNumbers = List.of("1", "2", "3", "4", "5", "5");

        assertThatThrownBy(() -> MainNumbers.from(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NUMBERS_DUPLICATE);
    }

    @DisplayName("특정 숫자가 MainNumbers 내에 존재하는지 확인한다.")
    @Test
    void checkNumberExistence() {
        List<String> numbersAsString = List.of("1", "2", "3", "4", "5", "6");
        MainNumbers mainNumbers = MainNumbers.from(numbersAsString);
        int existingNumber = 3;
        int nonExistingNumber = 7;

        assertThat(mainNumbers.hasNumber(existingNumber)).isTrue();
        assertThat(mainNumbers.hasNumber(nonExistingNumber)).isFalse();
    }
}
