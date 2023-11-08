package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {
    int min = 1;
    int max = 45;

    @Test
    @DisplayName("주어진 리스트의 길이가 6인지 확인합니다.")
    void lengthTest() {
        // given
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});

        // when
        int length = numbers.size();

        // then
        assertThat(length).isEqualTo(6);
    }

    @Test
    @DisplayName("주어진 리스트에 중복 숫자가 있는지 확인합니다.")
    void duplicationTest() {
        // given
        List<Integer> numbers = Arrays.asList(new Integer[]{2, 2, 3, 4, 5, 6});

        // when
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // then
        assertThat(uniqueNumbers.size() == 6).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자 범위 테스트")
    void validateNumberRangeTest() {
        // given
        int value = 100;

        // when
        boolean check = value > max || value < min;

        // then
        assertThat(check).isEqualTo(true);
    }

    @Test
    @DisplayName("모든 숫자가 1-45 사이의 값인지 확인합니다.")
    void validateLottoNumbersRangeTest() {
        // given
        boolean check = true;
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});

        // when
        for (Integer number : numbers) {
            if (number > max || number < min) {
                check = false;
            }
        }

        assertThat(check).isEqualTo(true);
    }

    @Test
    @DisplayName("입력 값이 숫자인지 확인합니다.")
    void isIntegerTest() {
        String input = "1,000";

        assertThatThrownBy(() -> {
            Integer.parseInt(input);
        }).isInstanceOf(NumberFormatException.class);
    }
}
