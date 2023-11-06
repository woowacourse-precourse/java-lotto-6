package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberCreateTest {
    @DisplayName("sort 기능이 잘 작동하는지 확인")
    @Test
    void judgingLottoNumberSize() {
        List<Integer> number = null;
        List<Integer> sortedNumber = null;
        List<Integer> result = null;
        RandomNumberCreate randomNumberCreate = new RandomNumberCreate(1);
        number.add(45);
        number.add(23);
        number.add(33);
        sortedNumber = randomNumberCreate.sortNumber(number);
        Assertions.assertThat(sortedNumber).isEqualTo(result);
    }
}