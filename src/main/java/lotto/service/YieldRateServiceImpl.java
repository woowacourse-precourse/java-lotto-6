package lotto.service;

import java.text.DecimalFormat;
import java.util.Optional;
import lotto.domain.Amount;
import lotto.enums.Rank;

public class YieldRateServiceImpl implements YieldRateService{

    private final DecimalFormat formatter;

    public YieldRateServiceImpl() {
        formatter = new DecimalFormat("###,###.0");
    }

    @Override
    public String calculateYieldRate() {
        Optional<Long> totalPrizeMoney = Rank.calculatePrizeMoney();
        return formatter.format(Amount.calculateYieldRate(totalPrizeMoney.orElse(null)));
    }
}
