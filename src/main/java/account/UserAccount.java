package account;

public class UserAccount {
    private final Integer money;

    public UserAccount(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public int getTrialCount() {
        return money / 1000;
    }
}
