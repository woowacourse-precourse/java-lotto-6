package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvalidInputTest {

    @DisplayName("로또 넘버가 중복된 숫자면 예외가 발생한다.")
    @Test
    void duplicateNumberException(){
        //given
        InvalidInput invalidInput = new InvalidInput();

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1, 2, 3, 3, 5, 6));

        //when //then
        assertThatThrownBy(() -> invalidInput.duplicateNumberException(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

}