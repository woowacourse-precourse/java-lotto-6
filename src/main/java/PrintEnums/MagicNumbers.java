package PrintEnums;

public enum MagicNumbers {
    CHECK_NUMBER_ONE(1),
    CHECK_NUMBER_FOURTYFIVE(45);

    // print 출력값 포장할 것
    final private int PrintInterface;

    public int getMagicNumber() {
        return PrintInterface;
    }

    MagicNumbers(int printInterface) {
        this.PrintInterface = printInterface;
    }
}
