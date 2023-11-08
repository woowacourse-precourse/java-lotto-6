package lotto.Model.Enums;

public enum Prices {
    ONE_LOTTO(1000),
    WIN_1ST(2000000000),
    WIN_2ND(30000000),
    WIN_3RD(1500000),
    WIN_4TH(50000),
    WIN_5TH(5000),
    LOSE(0);

    final private int number;
    Prices(int number) {this.number = number;}

    public int intValue(){return number;}
}
