package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoRepositoryTest {

    LottoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LottoRepository();
    }


    @Test
    void buyTicket_12장_구매시_정상작동() {
        int count = repository.buyTicket(12000);
        assertThat(count).isEqualTo(12);
        assertThat(repository.getMyTickets().size()).isEqualTo(count);

        for (Lotto ticket : repository.getMyTickets()) {
            List<Integer> expected = ticket.getNumbers();
            Collections.sort(expected);
            assertThat(ticket.getNumbers()).isEqualTo(expected);
            assertThat(expected.size()).isEqualTo(6);
        }
    }

    @Test
    void drawLotto_정상작동() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 7;
        repository.drawLotto(new Lotto(numbers), number);

        WinningNumber expected = new WinningNumber(new Lotto(numbers), number);
        WinningNumber actual = repository.getWinningNumber();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}