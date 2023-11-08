package lotto.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

    @Test
    void 개수만큼_로또를_자동으로_생성한다() {
        // when
        int quantity = 3;

        // when
        LottoTicket lottoTicket = lottoMachine.createLottoTicketByAuto(quantity);

        // then
        assertThat(lottoTicket.count()).isEqualTo(quantity);
    }

    @Test
    void 로또를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = lottoMachine.createLotto(numbers);

        // then
        assertThat(lotto.numbers()).hasSize(numbers.size());
    }

    @Test
    void 로또를_생성하면_오름차순으로_정렬된다() {
        // given
        List<Integer> numbers = List.of(6, 5, 4, 3, 2, 1);

        // when
        Lotto lotto = lottoMachine.createLotto(numbers);

        // then
        assertThat(lotto.numbers()).isSorted();
    }

    @Test
    void 로또_번호를_생성한다() {
        // given
        int number = 1;

        // when
        LottoNumber lottoNumber = lottoMachine.createLottoNumber(number);

        // then
        assertThat(lottoNumber.toString()).isEqualTo("1");
    }
}