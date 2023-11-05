package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandMachineTest {

    @DisplayName("로또 번호 생성 시 6개의 숫자를 반환하는지 검증")
    @Test
    void givenRandMachine_whenGenerateNumbers_thenReturnSixNumbers() {
        List<Integer> numbers = RandMachine.generateRandomNumbers();
        assertThat(numbers.size()).isEqualTo(6);
    }


    @Test
    @DisplayName("로또 번호를 생성할 때, 1~45 범위의 숫자가 반환되어야 한다.")
    void givenRandMachine_whenGenerateNumbers_thenShouldReturnNumbersInRange() {
        // when
        List<Integer> numbers = RandMachine.generateRandomNumbers();

        // then
        for (int number : numbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @DisplayName("로또 번호 생성 시 중복되지 않는 숫자를 반환하는지 검증")
    @Test
    void givenRandMachine_whenGenerateNumbers_thenReturnUniqueNumbers() {
        // when
        List<Integer> numbers = RandMachine.generateRandomNumbers();

        // then
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }

}