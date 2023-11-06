package lotto.controller;

import java.util.List;
import lotto.Service.StatisticsService;
import lotto.model.CompareResult;
import lotto.model.PurchasePrice;

public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public void getStatics(List<CompareResult> result, PurchasePrice purchasePrice) {
        // 로또 통계
        statisticsService.calculateStatistics(result, purchasePrice.getPurchasePrice());
    }
}
