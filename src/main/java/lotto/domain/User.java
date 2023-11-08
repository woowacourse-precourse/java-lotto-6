package lotto.domain;

public class User {
    private int budget;
    private int payed;
    private LottoPaper lottoPaper;

    private User(int budget) {
        this.budget = budget;
    }

    public static User createByBudget(int budget) {
        return new User(budget);
    }

    public void setBudget(int money) {
        this.budget = money;
    }

    // 전체 예산을 지불
    public int pay() {
        payed = budget;
        budget = 0;
        return payed;
    }

    public int getBudget() {
        return budget;
    }

    public LottoPaper getLottoPaper() {
        return LottoPaper.copy(lottoPaper);
    }

    public void setLottoPaper(LottoPaper lottoPaper) {
        this.lottoPaper = LottoPaper.copy(lottoPaper);
    }

    public int getPayed() {
        return payed;
    }
}