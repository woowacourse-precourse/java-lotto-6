package lotto.core.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private static final List<Integer> numbers = List.of(1, 2, 34, 5, 6, 7);
    private static final LottoTicket lottoTicket = new LottoTicket(numbers);

    @DisplayName("당첨 번호를 WinningNumbers 로 감싼다.")
    @Test
    void getNumbers() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(lottoTicket);

        //when
        List<Integer> rawWinningNumbers = winningNumbers.getNumbers();

        //then
        Assertions.assertThat(rawWinningNumbers).isEqualTo(numbers);
    }
}