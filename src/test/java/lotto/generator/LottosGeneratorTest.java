package lotto.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosGeneratorTest {

    @DisplayName("TicketCount 수만큼 로또가 생성되는지 Test")
    @Test
    void generateByTicketCount() {
        LottoNumbersGenerator lottoNumbersGenerator = mock(LottoNumbersGenerator.class);
        when(lottoNumbersGenerator.generate()).thenReturn(List.of(1, 2, 3, 4, 5, 7))
                .thenReturn(List.of(1, 2, 3, 4, 5, 7));
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        List<Lotto> lottos = lottosGenerator.generate(2);
        assertEquals(2, lottos.size());
    }
}
