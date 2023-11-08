package lotto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import lotto.repository.LottoRepository;
import lotto.repository.RankingRepository;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.Arrays;

class RankingServiceTest {

    @Mock
    private LottoRepository lottoRepository;

    @Mock
    private RankingRepository rankingRepository;

    @InjectMocks
    private RankingService rankingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("rankLottos()동작 테스트")
    void testRankLottos() {
        // Given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, 7);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)); // 2등

        when(lottoRepository.findNumberOfUserLotto()).thenReturn(2);
        when(lottoRepository.findUserLottoByIndex(0)).thenReturn(lotto1);
        when(lottoRepository.findUserLottoByIndex(1)).thenReturn(lotto2);

        // When
        rankingService.rankLottos(winningNumbers, bonusNumber);

        // Then
        verify(rankingRepository).increaseNumberOfRanking(1);
        verify(rankingRepository).increaseNumberOfRanking(2);
    }

    @Test
    @DisplayName("getNumbersOfRanking() 테스트")
    void testGetNumbersOfRanking() {
        // Given
        when(rankingRepository.findNumberOfRankingByRanking(1)).thenReturn(1);
        when(rankingRepository.findNumberOfRankingByRanking(2)).thenReturn(2);

        // When
        Integer[] numbersOfRanking = rankingService.getNumbersOfRanking();

        // Then
        assertEquals(1, numbersOfRanking[1]);
        assertEquals(2, numbersOfRanking[2]);
    }

    @Test
    @DisplayName("getProfitRatio() 동작 테스트")
    void testGetProfitRatio() {
        // Given
        when(rankingRepository.findTotalRewards()).thenReturn(150000L);
        when(lottoRepository.findNumberOfUserLotto()).thenReturn(10);

        // When
        Double profitRatio = rankingService.getProfitRatio();

        // Then
        assertEquals(15.0, profitRatio);
    }
}
