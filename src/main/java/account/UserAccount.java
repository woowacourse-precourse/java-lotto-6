package account;

public class UserAccount {
    private final Integer money;
    private static final int MONEY_UNIT = 1000; // 돈의 단위 숫자
    private static final int NUMBER_FOR_ROUND = 10; // 반올림을 위한 수 (100 * 10)
    private static final int PERCENT = 100;
    public UserAccount(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money){
        if (money % MONEY_UNIT != 0){
            throw new IllegalArgumentException();
        }
    }

    public int getTrialCount() {
        return money / MONEY_UNIT;
    }

    public double getEarningRate(long totalWinning) {
        double earningRate = (double) totalWinning / money;
        return (double) Math.round(earningRate * PERCENT * NUMBER_FOR_ROUND) / NUMBER_FOR_ROUND;
    }
}
