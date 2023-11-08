package lotto.serviceTest;

import java.util.List;
import java.util.Map;
import lotto.domain.WinningStatus;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryRandomLottoRepository;
import lotto.service.WinningCalculationService;
import lotto.service.WinningCalculationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningCalculationServiceTest {
    private LottoRepository lottoRepository;
    private WinningCalculationService winningCalculationService;

    @BeforeEach
    public void setUp() {
        lottoRepository = new MemoryRandomLottoRepository();
        winningCalculationService = new WinningCalculationServiceImpl(lottoRepository);
    }

    @DisplayName("서비스의 동작 여부 테스트")
    @Test
    void calculateWinningStatistics() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<WinningStatus, Integer> statistics = winningCalculationService.calculateWinningStatistics(winningNumbers,
                bonusNumber);

        assertThat(statistics).isNotNull();
        assertThat(statistics).containsKeys(WinningStatus.FIRST, WinningStatus.SECOND, WinningStatus.THIRD,
                WinningStatus.FOURTH, WinningStatus.FIFTH);
    }
}
