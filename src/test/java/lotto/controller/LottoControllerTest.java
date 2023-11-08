package lotto.controller;

import static org.mockito.Mockito.*;

import lotto.model.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

class LottoControllerTest {

    @Mock
    private InputView inputView;

    @Mock
    private OutputView outputView;

    @Mock
    private LottoService lottoService;

    @InjectMocks
    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("로또 구매 성공")
    void testGenerateLottos() {
        Long paidMoney = 1000L;

        when(inputView.inputPurchaseAmount()).thenReturn(paidMoney);
        when(lottoService.generateLotto()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoController.generateLottos();

        verify(outputView).printNumberOfPurchaseMessage(1);
        verify(outputView).printLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        verify(inputView, times(1)).inputPurchaseAmount();
        verify(lottoService, times(1)).generateLotto();
    }
}
