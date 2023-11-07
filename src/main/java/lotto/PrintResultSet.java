package lotto;

final class PrintResultSet {
    private int printThree;
    private int printFour;
    private int printFive;
    private int printFivePlusBonus;
    private int printSix;
    private int profitSum;

    public PrintResultSet() {
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
        if (countMatch == 3) {
            printThree += 1;
            profitSum += 5000;
        }
        return printThree;
    }

    public int checkMatchFour(int countMatch) {
        if (countMatch == 4) {
            printFour += 1;
            profitSum += 50000;
        }
        return printFour;
    }

    public int checkMatchFive(Score score) {
        if (score.getCountMatch() == 5 && !score.isCheckBonus()) {
            printFive += 1;
            profitSum += 1500000;
        }
        return printFive;
    }

    public int checkMatchFivePlus(Score score) {
        if (score.getCountMatch() == 5 && score.isCheckBonus()) {
            printFivePlusBonus += 1;
            profitSum += 30000000;
        }
        return printFivePlusBonus;
    }

    public int checkMatchSix(int countMatch) {
        if (countMatch == 6) {
            printSix += 1;
            profitSum += 2000000000;
        }
        return printSix;
    }


}
