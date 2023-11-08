package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.strategy.LottoStrategy;
import lotto.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ModelTest {
    @Mock
    private LottoStrategy lottoStrategy;
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new Model(lottoStrategy);
    }

    @Test
    @DisplayName("주어진 구매 횟수만큼 로또 번호 목록을 생성한다.")
    void generateLottos_GivenPurchase_GeneratesLottos() {

        Purchase purchase = mock(Purchase.class);
        when(purchase.getFinalRound()).thenReturn(5);
        when(lottoStrategy.generateNumbers()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = model.generateLottos(purchase);

        assertEquals(5, lottos.size());
        verify(lottoStrategy, times(5)).generateNumbers();
    }
}
