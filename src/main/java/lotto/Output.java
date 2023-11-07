package lotto;

import java.util.List;
import java.text.DecimalFormat;

public class Output {
    public static void startMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void checkLottoNumberMessage(List<List<Integer>> tickets){
        for(List<Integer> ticket : tickets){
            System.out.println(ticket);
        }
    }

    public static void howManyLottoMessage(int countLotto){
        System.out.println("\n" + countLotto + "개를 구매했습니다.");
    }

    public static void winningNumberGuide(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumberGuide(){
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
    }

    public static void resultLotto(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()){
            System.out.println(rank.getMessage() + " (" + decimalFormat.format(rank.getPrice()) + "원) - " + rank.getCnt() + "개") ;
        }
    }

    public static void RateOfReturn(){
        double rate = Rate.calculateRate();
        rate = Math.round(rate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
