package lotto.Model.Enums;

public enum Prices {
    ONE_LOTTO(1000);

    final private int number;
    Prices(int number) {this.number = number;}

    public int intValue(){return number;}
}
