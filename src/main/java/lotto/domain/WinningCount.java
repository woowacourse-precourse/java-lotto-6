package lotto.domain;

public class WinningCount {
    private int three;
    private int four;
    private int five;
    private int fiveBonus;
    private int six;

    public void addWinningCount(Winning winning) {
        if (winning.isThree()) {
            ++three;
        }

        if (winning.isFour()) {
            ++four;
        }

        if (winning.isFive()) {
            ++five;
        }

        if (winning.isFiveBonus()) {
            ++fiveBonus;
        }

        if (winning.isSix()) {
            ++six;
        }
    }

    public int getCount(int number) {
        if (number == 3) {
            return three;
        }

        if (number == 4) {
            return four;
        }

        if (number == 5) {
            return five;
        }

        if (number == 6) {
            return six;
        }

        return fiveBonus;
    }
}
