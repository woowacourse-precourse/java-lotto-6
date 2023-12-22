package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTicketTest {

    @ValueSource(ints = {-1, 46})
    @ParameterizedTest
    void validateBonusNumberRangeTest(int bonusNumber) {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThatThrownBy(() -> new WinningLottoTicket(lottoTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDistinctBonusNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        Assertions.assertThatThrownBy(() -> new WinningLottoTicket(lottoTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
