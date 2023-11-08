package lotto.view;

import lotto.model.WinningRank;

import java.util.List;

public class OutputView {
    public static void printCount(int count){
        System.out.println("\n"+count+"개를 구매했습니다.");
    }
    public static void printLotto(List<Integer> numbers){
        System.out.println(numbers);
    }
    public static void printResult(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }
    public static void printRanking(List<Integer> count){
        int i=0;
        for(WinningRank winningRank : WinningRank.values()){
            if(winningRank!=WinningRank.MISS){
                String message = winningRank.getMessage();
                System.out.println(message + count.get(i)+"개");
                i++;
            }
        }
    }
    public static void printTotalReturn(double rate){
        System.out.println("총 수익률은 "+ String.format("%.1f",  rate )+"%입니다.");
    }
}
