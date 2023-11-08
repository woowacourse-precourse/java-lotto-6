package lotto.views;

import java.util.ArrayList;

public class GameEnd {
    public void showResult(ArrayList<Integer> n, String[] price) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        System.out.println("당첨통계\n---\n");

        for (int i = 3; i < n.size(); i++) {
            int rightNum = n.get(i);
            String profit = price[i];
            String desc = i + "개 일치 (" + profit + "원): " + rightNum + "개\n";
            stringBuilder.append(desc);
        }

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
