package lotto.view;

import lotto.domain.dto.LottosDto;
import lotto.domain.dto.StatisticsDto;

public interface OutputView {
    void printPurchase(LottosDto lottosDto);
    void printStatistics(StatisticsDto statisticsDto);
    void printNewLineForSeparation();
}
