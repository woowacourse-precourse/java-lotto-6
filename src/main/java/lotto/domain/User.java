package lotto.domain;

import java.math.BigDecimal;

public class User {
    private BigDecimal budget;
    private BigDecimal payed;
    private LottoPaper lottoPaper;

    private User(BigDecimal budget) {
        this.budget = budget;
    }

    public static User createByBudget(BigDecimal budget) {
        return new User(budget);
    }

    public void setBudget(BigDecimal money) {
        this.budget = money;
    }

    // 전체 예산을 지불
    public BigDecimal pay() {
        payed = budget;
        budget = BigDecimal.ZERO;
        return payed;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public LottoPaper getLottoPaper() {
        return LottoPaper.copy(lottoPaper);
    }

    public void setLottoPaper(LottoPaper lottoPaper) {
        this.lottoPaper = LottoPaper.copy(lottoPaper);
    }

    public BigDecimal getPayed() {
        return payed;
    }
}