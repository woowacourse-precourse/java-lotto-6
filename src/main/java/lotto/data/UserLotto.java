package lotto.data;

public class UserLotto {
    private Lotto lotto;
    private int correctCnt;
    private int bonusCnt;

    public UserLotto(Lotto lotto) {
        this.lotto = lotto;
        this.correctCnt = 0;
        this.bonusCnt = 0;
    }

    public int getCorrectCnt() {
        return correctCnt;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusCnt() {
        return bonusCnt;
    }

    public void compareNumber(Lotto systemLotto) {
        correctCnt = (int) lotto.getNumbers().stream()
                .filter(number -> systemLotto.getNumbers().contains(number)).count();
    }

    public void compareBonus(int number) {
        if (lotto.getNumbers().contains(number)) {
            if (correctCnt == 5) {
                bonusCnt++;
                return;
            }

            correctCnt++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(lotto.getNumbers().get(0));
        for (int i = 1; i < lotto.getNumbers().size(); i++) {
            sb.append(", ").append(lotto.getNumbers().get(i));
        }
        sb.append("]");

        return sb.toString();
    }
}
