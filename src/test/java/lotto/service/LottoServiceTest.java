package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("입력된 문자열을 Lotto 객체로 변환한다.")
    @Test
    void stringToLotto() {
        String input = "1,2,3,4,5,6";
        Lotto lotto = lottoService.stringToLotto(input);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교한다.")
    @Test
    void compareTicketsWithWinninLotto() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        Result result = lottoService.compare(tickets, winningLotto);

        assertAll(
                () -> assertThat(result.getResult().get(WinningType.FIRST)).isEqualTo(0),
                () -> assertThat(result.getResult().get(WinningType.SECOND)).isEqualTo(0),
                () -> assertThat(result.getResult().get(WinningType.THIRD)).isEqualTo(0),
                () -> assertThat(result.getResult().get(WinningType.FOURTH)).isEqualTo(0),
                () -> assertThat(result.getResult().get(WinningType.FIFTH)).isEqualTo(1),
                () -> assertThat(result.getResult().get(WinningType.MISS)).isEqualTo(7)

        );
    }

    @DisplayName("구매한 로또 번호 숫자와 당첨 번호 숫자가 일치하는 개수를 반환한다.")
    @Test
    void countTicketDuplicateNumWithWinningLotto() {
        Lotto ticket = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        assertThat(lottoService.countDuplicateNum(ticket, winningLotto))
                .isEqualTo(3);

    }
}
