package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.RandomNumber;
import org.junit.jupiter.api.Test;

public class LottoDrawTest {

    @Test
    void 구입_로또_생성_테스트() {
        mockStatic(RandomNumber.class);
        when(RandomNumber.createRandomLottoNumber())
                .thenReturn(List.of(1,2,3,4,5,6))
                .thenReturn(List.of(1,3,4,5,6,7))
                .thenReturn(List.of(3,4,5,25,11,32));

        LottoDraw lottoDraw = new LottoDraw();
        Lottos lottos = lottoDraw.createLottos(3);

        List<Lotto> expectedLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,3,4,5,6,7)),
                new Lotto(List.of(3,4,5,25,11,32))
        );


        for (int i = 0; i < 3; i++) {
            assertEquals(expectedLottos.get(i).toString(), lottos.getLottos().get(i).toString());
        }
    }
}
