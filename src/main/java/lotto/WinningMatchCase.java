package lotto;

public enum WinningMatchCase {
    MATCH_3_NUMBER(3),
    MATCH_4_NUMBER(4),
    MATCH_5_NUMBER(5),
    MATCH_5A_NUMBER(7),
    MATCH_6_NUMBER(6) ;

    private final int count;

    private WinningMatchCase(int matchnumber) {
        this.count = matchnumber;
    }

    public static WinningMatchCase getcase(int count) {

        if (count == 3) {
            return MATCH_3_NUMBER;
        }

        if (count == 4) {
            return MATCH_4_NUMBER;
        }

        if (count == 5) {
            return MATCH_5_NUMBER;
        }

        if (count == 6) {
            return MATCH_6_NUMBER;
        }

        if (count == 7) {
            return MATCH_5A_NUMBER;
        }

        return null;
    }

}
