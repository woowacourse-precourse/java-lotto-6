package lotto.View;

import java.math.BigDecimal;

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

    public void print3Matchs(int cnt){
        System.out.println("3개 일치 (5,000원) - "+cnt+"개");
    }

    public void print4Matchs(int cnt){
        System.out.println("4개 일치 (50,000원) - "+cnt+"개");
    }

    public void print5Matchs(int cnt){
        System.out.println("5개 일치 (1,500,000원) - "+cnt+"개");
    }

    public void print5MatchsWithBonus(int cnt){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+cnt+"개");
    }

    public void print6Matchs(int cnt){
        System.out.println("6개 일치 (2,000,000,000원) - "+cnt+"개");
    }

    public void printProfit(String profit){
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }

}
