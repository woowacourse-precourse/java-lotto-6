package lotto.views;

import java.util.ArrayList;

public class GameEnd {
    public void showResult(ArrayList<Integer> n, String[] price, int isSpecial) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("당첨통계\n---\n");

        for (int i = 3; i < n.size(); i++) {
            int rightNum = n.get(i);
            String profit = price[i];
            String desc = i + "개 일치 (" + profit + "원): " + rightNum + "개\n";
            stringBuilder.append(desc);
            if(i==5){
                showSpecialBall(isSpecial);
            }
        }

        System.out.println(stringBuilder);
    }

    public void showSpecialBall(int n){
        StringBuilder stringBuilder = new StringBuilder();
        int rightNum = n;
        String profit = "30,000,000원";
        stringBuilder.append("5개 일치, 보너스 볼 일치 (");
        stringBuilder.append(profit);
        stringBuilder.append("원): ");
        stringBuilder.append(rightNum);
        stringBuilder.append( "개\n");
        System.out.println(stringBuilder);
    }

    public void showProfit(double n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(n);
        stringBuilder.append("% 입니다.");
        System.out.print(stringBuilder);
    }
}
