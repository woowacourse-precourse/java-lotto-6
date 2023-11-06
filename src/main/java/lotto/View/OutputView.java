package lotto.View;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void askPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberPurchase(int cnt){
        System.out.println("\n"+cnt+"개를 구매했습니다.");
    }

    public void printGeneratedNums(List<Integer> nums){
        System.out.println(nums.stream().map(i -> i.toString()).collect(Collectors.joining(", ", "[", "]")));
    }

    public void askWinningNums(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void askBonusNum(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
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

    public void printProfit(double profit){
        BigDecimal bigDecimal = new BigDecimal(Double.parseDouble(Double.toString(profit)));
        System.out.println("총 수익률은 "+String.format("%,.1f", bigDecimal)+"%입니다.");
    }

}
