package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGenerateMachineTest {

    private List<Lotto> lottoTickets;
    private int startInclusive;
    private int endInclusive;
    private int count;
    private int ticketCount;
    private LottoGenerateMachine machine;

    @BeforeEach
    void setup() {
        // given
        startInclusive = 1;
        endInclusive = 45;
        count = 6;
        ticketCount = 5;
        machine = new LottoGenerateMachine(startInclusive, endInclusive, count);
    }

    @DisplayName("티켓을 1000으로 나눈 몫만큼 로또가 생성된다.")
    @Test
    void tc1() {
        // when
        lottoTickets = machine.generate(ticketCount);

        // then
        assertThat(lottoTickets).hasSize(ticketCount);
    }

    @DisplayName("로또 번호는 오름차운 정렬되어 생성된다.")
    @Test
    void tc2() {
        // when
        lottoTickets = machine.generate(ticketCount);

        // then
        lottoTickets.forEach(
                lotto -> assertThat(lotto.getNumbers()).isSorted()
        );
    }

    @DisplayName("로또 번호는 1, 45 를 포함한 범위 안에서 생성된다.")
    @Test
    void tc3() {
        // when
        lottoTickets = machine.generate(ticketCount);

        // then
        lottoTickets.forEach(
                lotto -> assertThat(lotto.getNumbers()).allMatch(number -> number >= startInclusive && number <= endInclusive)
        );
    }

    @DisplayName("로또 번호는 6개의 숫자로 구성된다.")
    @Test
    void tc4() {
        // when
        lottoTickets = machine.generate(ticketCount);

        // then
        lottoTickets.forEach(
                lotto -> assertThat(lotto.getNumbers()).hasSize(count)
        );
    }

}
