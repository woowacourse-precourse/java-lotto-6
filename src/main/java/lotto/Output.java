package lotto;

import java.util.List;

public class Output {
    public static Rank rank = Rank.MISS;
    public static void printLottoQuantity(int totalPrice){
        System.out.println(totalPrice/1000 + "개를 구매했습니다.");
    }

    public static void printAllLotto(List<Lotto> lottoList){
        for(Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers(lotto));
        }
    }

    public static void printWinResult(int[] result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=1; i<result.length-1; i++){
            rank = rank.getRank(i);
            System.out.println(rank.getMessage() + result[i] + "개");
        }
    }

    public static void printReturnRate(double ReturnRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", ReturnRate) + "%입니다.");
    }
}
