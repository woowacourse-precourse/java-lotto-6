package lotto.core.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private static final List<Integer> numbers = List.of(1,2,34,5,6,7);
    private static final LottoTicket lottoTicket = new LottoTicket(numbers);
    @DisplayName("당첨 번호를 WinningNumbers 로 감싼다.")
    @Test
    void getNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(lottoTicket);
        Assertions.assertThat(winningNumbers.getNumbers()).isEqualTo(numbers);
    }
}