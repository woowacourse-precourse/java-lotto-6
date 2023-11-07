package lotto.domain;

public class WinningLottoNumber {

    private static int treeSameNumLotto = 0;
    private static int fourSameNumLotto = 0;
    private static int fiveSameNumLotto = 0;
    private static int fiveAndBonusSameNumLotto = 0;
    private static int sixSameNumLotto = 0;

    public static int getTreeSameNumLotto() {
        return treeSameNumLotto;
    }

    public static int getFourSameNumLotto() {
        return fourSameNumLotto;
    }

    public static int getFiveSameNumLotto() {
        return fiveSameNumLotto;
    }

    public static int getFiveAndBonusSameNumLotto() {
        return fiveAndBonusSameNumLotto;
    }

    public static int getSixSameNumLotto() {
        return sixSameNumLotto;
    }

    public static void increaseTreeSameNumLotto(){
        treeSameNumLotto++;
    }
    public static void increaseFourSameNumLotto(){
        fourSameNumLotto++;
    }
    public static void increaseFiveSameNumLotto(){
        fiveSameNumLotto++;
    }
    public static void increaseFiveAndBonusSameNumLotto(){
        fiveAndBonusSameNumLotto++;
    }
    public static void increaseSixSameNumLotto(){
        sixSameNumLotto++;
    }

}
