package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.RandNumber.*;

public class RandNumberTest {
    @DisplayName("랜덤 넘버 6개 뽑기")
    @Test
    void createRandomNumberTest() {
        List<Integer> numbers =makeRandNumber();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("랜덤 숫자가 중복되면 다시 뽑는다.")
    @Test
    void checkDuplicateTest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        for (int n : makeUniqueNumber()) {
            System.out.println(n);
        }
        Assertions.assertThat(checkDuplicate(numbers)).isNotEqualTo(numbers);
    }

}
