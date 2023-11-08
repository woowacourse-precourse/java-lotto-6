package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 티켓이 6개 숫자를 포함하는지 확인")
    void generateTicket_ShouldContainSixNumbers() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket ticket = lottoMachine.generateTicket();
        List<Integer> numbers = ticket.getNumbers();

        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 중복되지 않는지 확인")
    void generateTicket_NumbersShouldNotHaveDuplicates() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket ticket = lottoMachine.generateTicket();
        List<Integer> numbers = ticket.getNumbers();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertThat(uniqueNumbers).hasSize(numbers.size());
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 1과 45 사이인지 확인")
    void generateTicket_NumbersShouldBeBetweenOneAndFortyFive() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket ticket = lottoMachine.generateTicket();
        List<Integer> numbers = ticket.getNumbers();

        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 정렬된 순서인지 확인")
    void generateTicket_NumbersShouldBeSorted() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket ticket = lottoMachine.generateTicket();
        List<Integer> numbers = ticket.getNumbers();

        assertThat(numbers).isSorted();
    }
}
