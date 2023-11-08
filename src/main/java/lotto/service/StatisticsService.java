package lotto.service;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;

public interface StatisticsService {
    Result calculateResult();
    double calculateRevenueRate(List<Lotto> lottos, Result result);
}
