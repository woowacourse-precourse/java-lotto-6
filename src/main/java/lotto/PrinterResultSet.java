package lotto;

final class PrinterResultSet {
    private int printThree;
    private int printFour;
    private int printFive;
    private int printFivePlusBonus;
    private int printSix;
    private int profitSum;

    public PrinterResultSet() {
        this.printThree = 0;
        this.printFour = 0;
        this.printFive = 0;
        this.printFivePlusBonus = 0;
        this.printSix = 0;
        this.profitSum = 0;
    }

    public int getPrintThree() {
        return printThree;
    }

    public int getPrintFour() {
        return printFour;
    }

    public int getPrintFive() {
        return printFive;
    }

    public int getPrintFivePlusBonus() {
        return printFivePlusBonus;
    }

    public int getPrintSix() {
        return printSix;
    }


    public int getProfitSum() {
        return profitSum;
    }

    public int checkMatchThree(int countMatch) {
        if (countMatch == NumberOfMatch.THREE.getMatchCount()) {
            printThree += 1;
            profitSum += NumberOfMatch.THREE.getWinningPrice();
        }
        return printThree;
    }

    public int checkMatchFour(int countMatch) {
        if (countMatch == NumberOfMatch.FOUR.getMatchCount()) {
            printFour += 1;
            profitSum += NumberOfMatch.FOUR.getWinningPrice();
        }
        return printFour;
    }

    public int checkMatchFive(Score score) {
        if (score.getCountMatch() == NumberOfMatch.FIVE.getMatchCount() && !score.isCheckBonus()) {
            printFive += 1;
            profitSum += NumberOfMatch.FIVE.getWinningPrice();
        }
        return printFive;
    }

    public int checkMatchFivePlus(Score score) {
        if (score.getCountMatch() == NumberOfMatch.FIVE_PLUS.getMatchCount() && score.isCheckBonus()) {
            printFivePlusBonus += 1;
            profitSum += NumberOfMatch.FIVE_PLUS.getWinningPrice();
        }
        return printFivePlusBonus;
    }

    public int checkMatchSix(int countMatch) {
        if (countMatch == NumberOfMatch.SIX.getMatchCount()) {
            printSix += 1;
            profitSum += NumberOfMatch.SIX.getWinningPrice();
        }
        return printSix;
    }
}
