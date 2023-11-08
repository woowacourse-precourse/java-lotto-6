package lotto.view;

import lotto.global.SingletonRegistry;
import lotto.model.Lottos;
import lotto.model.Result;

import static lotto.model.LottoInfo.Prize.*;

public class OutputView {
    private OutputView(){}
    public static OutputView getInstance(){
        String key = "outputView";
        if(SingletonRegistry.getInstance(key)==null){
            SingletonRegistry.register(key,new OutputView());
        }
        return (OutputView) SingletonRegistry.getInstance(key);
    }


    public void outputPayment(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void outputBuy(Lottos lottos){
        System.out.println(lottos.getSize()+"개를 구매했습니다.");
        System.out.println(lottos);
    }
    public void outputGoal(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void outputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void outputResult(Result result,int money){
        int[] results = result.getResults();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 ("+PRIZE_5ST+") - "+results[5]+"개");
        System.out.println("4개 일치 ("+PRIZE_4ST+") - "+results[4]+"개");
        System.out.println("5개 일치 ("+PRIZE_3ST+") - "+results[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+PRIZE_2ST+") - "+results[2]+"개");
        System.out.println("6개 일치 ("+PRIZE_1ST+") - "+results[1]+"개");
        System.out.println("총 수익률은 "+ Math.round(((double) result.getTotalPrize()/money*100)*10)/10.0+"%입니다.");
    }
}
