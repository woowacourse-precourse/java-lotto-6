package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.FinalGrade;
import lotto.domain.Lotto;
import lotto.domain.PlayerLotto;
import lotto.domain.Rank;
import lotto.domain.WinningInformation;
import lotto.dto.WinningStatisticsDto;
import lotto.service.numbergenerator.NumberGenerator;

public class LottoGameService {
    private final NumberGenerator numbersGenerator;
    private final YieldCalculator yieldCalculator;

    public LottoGameService(NumberGenerator numbersGenerator, YieldCalculator yieldCalculator) {
        this.numbersGenerator = numbersGenerator;
        this.yieldCalculator = yieldCalculator;
    }

    public List<Lotto> createPlayerLotto(final int totalCounts) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < totalCounts; count++) {
            lottos.add(new Lotto(numbersGenerator.generate()));
        }
        return Collections.unmodifiableList(lottos);
    }

    public WinningStatisticsDto calculateWinningStatistics(final PlayerLotto playerLotto,
                                                           final WinningInformation winningInformation) {
        FinalGrade finalGrade = playerLotto.calculateFinalGrade(winningInformation);
        EnumMap<Rank, Integer> eachRankCounts = finalGrade.getEachRankCounts();
        BigDecimal yieldRate = yieldCalculator.calculate(finalGrade);

        return new WinningStatisticsDto(eachRankCounts, yieldRate);
    }
}
