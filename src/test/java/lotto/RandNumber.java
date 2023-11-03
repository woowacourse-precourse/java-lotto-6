package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.RandNumber.makeRandNumber;

public class RandNumber {
    @DisplayName("랜덤 넘버 6개 뽑기")
    @Test
    void createRandomNumberTest() {
        RandNumber randNumber = new RandNumber();
        List<Integer> numbers =makeRandNumber();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

}
