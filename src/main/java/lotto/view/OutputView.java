package lotto.view;

public class OutputView {

    public OutputView(){

    }

    public static void printRewardResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printRevenueResult(double EarningRate){
        System.out.println("총 수익률은"+ String.format("%.1f", EarningRate)+"입니다.");
    }

    public static void printRewardMessage(String message, int count){
        System.out.println(message + count + "개");
    }




}
