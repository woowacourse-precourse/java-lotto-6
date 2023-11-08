package lotto;

public class LottoComparison {
    private final int countDuplication;
    private final boolean checkBonus;

    public LottoComparison(int countDuplication, boolean checkBonus) {
        this.countDuplication = countDuplication;
        this.checkBonus = checkBonus;
    }

    public int getCountDuplication() {
        return countDuplication;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }
}