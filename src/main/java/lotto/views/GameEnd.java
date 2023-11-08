package lotto.views;

import java.util.ArrayList;

public class GameEnd {
    public void showResult(ArrayList<Integer> n){
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0;i<n.size(); i++){
            int rightNum = n.get(i);
            int profit = rightNum*1000;
            String desc =Integer.toString(rightNum)+"개 일치 ("+Integer.toString(profit)+"원): "+Integer.toString(rightNum)+"개\n";
            result.add(desc);
            stringBuilder.append(result.get(i));
        }

        System.out.println(stringBuilder);
    }
    public void showProfit(int n){
        System.out.println("당첨통계\n---\n");

    }
}
