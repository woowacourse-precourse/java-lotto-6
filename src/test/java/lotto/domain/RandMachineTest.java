package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandMachineTest {

    @DisplayName("로또 번호 생성 시 6개의 숫자를 반환하는지 검증")
    @Test
    void givenRandMachine_whenGenerateNumbers_thenReturnSixNumbers() {
        List<Integer> numbers = RandMachine.generateRandomNumbers();
        assertThat(numbers.size()).isEqualTo(6);
    }

}