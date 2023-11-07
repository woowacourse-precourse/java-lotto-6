package lotto;

final class Score {
    private final int countMatch;
    private final boolean checkBonus;

    public Score(int countMatch, boolean checkBonus) {
        this.countMatch = countMatch;
        this.checkBonus = checkBonus;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public boolean isCheckBonus() {
        return checkBonus;
    }

}
