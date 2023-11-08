package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningServiceTest {
    @DisplayName("당첨 번호를 예외없이 생성한다.")
    @Test
    void createWinningNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        // when
        WinningService winningService = new WinningService();
        // then
        assertThatCode(() -> {
            WinningLotto winningLotto = winningService.createWinningNumber(winningNumbers, bonusNumber);
        }).doesNotThrowAnyException();
    }

    @DisplayName("당첨 결과를 올바르게 계산한다.")
    @Test
    void calculateResults() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        List<Lotto> lottoTickets = new ArrayList<>();
        Lotto lottoTicket1 = new Lotto(lottoNumbers);
        lottoTickets.add(lottoTicket1);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        // when
        WinningService winningService = new WinningService();
        WinningResult winningResult = winningService.calculateResults(lottoTickets, winningLotto);
        // then
        assertThat(winningResult.getCount(Rank.SECOND)).isEqualTo(1);
    }

}