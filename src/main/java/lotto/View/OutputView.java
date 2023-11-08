package lotto.View;

public class OutputView {

    public void printNumberPurchase(int cnt){
        System.out.println("\n"+cnt+"개를 구매했습니다.");
    }

    public void printGeneratedNums(String output){
        System.out.println(output);
    }

    public void printWinningStatistics(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void printStatistics(String comment, int cnt){
        System.out.printf(comment+'\n', cnt);
    }

    public void printProfit(String profit){
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }

}
