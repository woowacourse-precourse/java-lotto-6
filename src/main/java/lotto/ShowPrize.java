package lotto;

public class ShowPrize {
    public static void showPrizeCount() {
        System.out.println("3개 일치 (5,000원) - "+Prize.THREE_MATCH.getMatchCount()+"개");
        System.out.println("4개 일치 (50,000원) - "+Prize.FOUR_MATCH.getMatchCount()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+Prize.FIVE_MATCH.getMatchCount()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+Prize.FIVE_MATCH_WITH_BONUS.getMatchCount()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+Prize.SIX_MATCH.getMatchCount()+"개");

    }
}
