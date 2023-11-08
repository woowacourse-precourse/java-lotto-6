package lotto.controller;

import static org.mockito.Mockito.*;

import lotto.service.RankingService;
import lotto.view.InputView;
import lotto.view.OutputView;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class RankingControllerTest {

    @Mock
    private InputView inputView;

    @Mock
    private OutputView outputView;

    @Mock
    private RankingService rankingService;

    @InjectMocks
    private RankingController rankingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("결과 출력 성공")
    void testRankLottos() {
        List<Integer> winningNumbersInput = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumberInput = 7;

        when(inputView.inputWinningNumbers()).thenReturn(winningNumbersInput);
        when(inputView.inputBonusNumber()).thenReturn(bonusNumberInput);

        Integer[] numberOfRanking = {1, 1, 1, 1, 1, 1};
        Double profitRatio = 38592.5;

        when(rankingService.getNumbersOfRanking()).thenReturn(numberOfRanking);
        when(rankingService.getProfitRatio()).thenReturn(profitRatio);

        rankingController.rankLottos();

        verify(outputView).printReceiptTitle();
        verify(outputView).printRankingResult(5, 1);
        verify(outputView).printRankingResult(4, 1);
        verify(outputView).printRankingResult(3, 1);
        verify(outputView).printRankingResult(2, 1);
        verify(outputView).printRankingResult(1, 1);
        verify(outputView).printProfitRatio(38592.5);

        verify(inputView, times(1)).inputWinningNumbers();
        verify(inputView, times(1)).inputBonusNumber();
        verify(rankingService, times(1)).getNumbersOfRanking();
        verify(rankingService, times(1)).getProfitRatio();
    }
}
