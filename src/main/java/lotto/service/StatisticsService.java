package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

public interface StatisticsService {
    Result calculateResult();
    double calculateRevenueRate(List<Lotto> lottos, Result result);
}
