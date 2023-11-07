package lotto.view;

import lotto.global.SingletonRegistry;
import lotto.model.Lottos;

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
    public void outputResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        // TODO: 2023-11-07 일치 내역, 수익률
    }
}
