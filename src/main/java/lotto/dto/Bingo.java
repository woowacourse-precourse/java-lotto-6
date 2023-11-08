package lotto.dto;

public class Bingo {
    int bingoNum;
    boolean checkBonus;
    public int correctLotto = 0;

    private Bingo(int bingoNum, boolean checkBonus){
        this.bingoNum = bingoNum;
        this.checkBonus = checkBonus;
    }

    private static Bingo bingo3 = new Bingo(3,false);
    private static Bingo bingo4 = new Bingo(4,false);
    private static Bingo bingo5 = new Bingo(5,false);
    private static Bingo bingo5wB = new Bingo(5,true);
    private static Bingo bingo6 = new Bingo(6,false);

    public static Bingo getBingo3() { return bingo3; }
    public static Bingo getBingo4() { return bingo4; }
    public static Bingo getBingo5() { return bingo5; }
    public static Bingo getBingo5wB() { return bingo5wB; }
    public static Bingo getBingo6() { return bingo6; }

}
