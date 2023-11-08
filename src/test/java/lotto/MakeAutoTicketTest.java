package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Model.MakeAutoTicket;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class MakeAutoTicketTest {
    @DisplayName("6개의 중복을 허용하지 않는 숫자")
    @Test
    void createMakeAutoTicket() {
        MakeAutoTicket autoTicket = new MakeAutoTicket();
        List<Integer> numbers = autoTicket.getnumbers();

        assertThat(numbers).hasSize(6);

        List<Integer> outOfRangeNumbers = numbers.stream()
                .filter(num -> num < 1 || num > 45)
                .collect(Collectors.toList());
        assertThat(outOfRangeNumbers).isEmpty();

        long distinctCount = numbers.stream().distinct().count();
        assertThat(distinctCount).isEqualTo(6);
    }
}