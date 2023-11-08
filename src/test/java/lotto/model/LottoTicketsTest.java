package lotto.model;

import lotto.WinningLotto;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LottoTicketsTest {
    @InjectMocks
    LottoTickets lottoTickets;

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);

        when(randomNumberGenerator.getRandomNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        lottoTickets = new LottoTickets(randomNumberGenerator);
    }

    @Test
    void createTicket() {
        lottoTickets.createTicket(3);

        assertThat(lottoTickets.getLottoTicketsSize()).isEqualTo(3);
        for (int i = 0; i < 3; i++) {
            assertThat(lottoTickets.getLottoTickets().get(i).getNumbers())
                    .containsExactly(1, 2, 3, 4, 5, 6);
        }
    }

    @Test
    void calculateWinningLottoFirst() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.FIRST)).isEqualTo(3);
    }

    @Test
    void calculateWinningLottoSecond() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 6);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.SECOND)).isEqualTo(3);
    }

    @Test
    void calculateWinningLottoThird() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 9);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.THIRD)).isEqualTo(3);
    }

    @Test
    void calculateWinningLottoFourth() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 7, 8), 9);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.FOURTH)).isEqualTo(3);
    }

    @Test
    void calculateWinningLottoFifth() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 7, 8, 9), 10);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.FIFTH)).isEqualTo(3);
    }

    @Test
    void calculateWinningLottoOther() {
        lottoTickets.createTicket(3);

        WinningLotto winningLotto = new WinningLotto(List.of(7, 8, 9, 10, 11, 12), 13);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);

        assertThat(resultIntegerHashMap.get(Result.FALSE)).isEqualTo(3);
    }
}