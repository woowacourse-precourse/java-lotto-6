package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("5천원일 경우 로또 5개를 발행한다.")
    @Test
    void makeFiveWithFiveThousand() {
        WinningNumbers winningNumbers = mock(WinningNumbers.class);
        Money fiveThousand = new Money(5_000);
        LottoMachine lottoMachine = new LottoMachine();
        LottoService lottoService = new LottoService(winningNumbers, lottoMachine);
        List<Lotto> lottos = lottoService.getLottosWith(fiveThousand);
        assertThat(lottos).hasSize(5);
    }
}
