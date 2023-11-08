package lotto.view;

import lotto.constant.WinningReward;
import lotto.model.Result;

import java.sql.SQLOutput;

public class LastResultOutputView {

    final private String START_MESSAGE = "당첨 통계";

    public LastResultOutputView(Result result, int inputCost){
        System.out.println(START_MESSAGE);
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result.getFifth()+"개");
        System.out.println("4개 일치 (50,000원) - "+result.getFourth()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result.getThird()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.getSecond()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result.getFifth()+"개");
        System.out.println("총 수익률은 "+calculateReturnRate(result,inputCost)+"%입니다.");
    }

    private double calculateReturnRate(Result result, int inputCost){
        double resultValue = result.getFirst()* WinningReward.FIRST.getReward()+
                result.getSecond()* WinningReward.SECOND.getReward()+
                result.getThird()* WinningReward.THIRD.getReward()+
                result.getFourth()* WinningReward.FOURTH.getReward()+
                result.getFifth()*WinningReward.FIFTH.getReward();
        return (resultValue/inputCost)*100;

    }
}
