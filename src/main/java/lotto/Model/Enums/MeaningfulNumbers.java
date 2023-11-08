package lotto.Model.Enums;

public enum MeaningfulNumbers {
    LOTTO_NUMBER_WITHOUT_BONUS(6),
    LOTTO_RANGE_MIN(1),
    LOTTO_RANGE_MAX(45);
    final private int number;
    MeaningfulNumbers(int number) {this.number = number;}

    public int intValue(){return number;}
}
