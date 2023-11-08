package lotto.model;

public class Player {
    private static int THREE_MATCH = 0;
    private static int FOUR_MATCH = 0;
    private static int FIVE_MATCH = 0;
    private static int FIVE_MATCH_WITH_BONUS = 0;
    private static int SIX_MATCH = 0;
    private int payment;
    private Lotto lotto;
    private int bonusNumber;

    public Player(int payment, Lotto lotto, int bonusNumber) {
        this.payment = payment;
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getThreeMatch() {
        return THREE_MATCH;
    }

    public int getFourMatch() {
        return FOUR_MATCH;
    }

    public int getFiveMatch() {
        return FIVE_MATCH;
    }

    public int getFiveMatchWithBonus() {
        return FIVE_MATCH_WITH_BONUS;
    }

    public int getSixMatch() {
        return SIX_MATCH;
    }

    public void addThreeMatch() {
        THREE_MATCH++;
    }

    public void addFourMatch() {
        FOUR_MATCH++;
    }

    public void addFiveMatch() {
        FIVE_MATCH++;
    }

    public void addFiveMatchWithBonus() {
        FIVE_MATCH_WITH_BONUS++;
    }

    public void addSixMatch() {
        SIX_MATCH++;
    }
}
