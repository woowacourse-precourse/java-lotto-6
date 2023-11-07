package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.Reward;

import java.util.Map;

public class Output {
    public void showNumberOfLotto(int number){
        System.out.println("\n" + number+"개를 구매했습니다.");
    }

    public void showLottoNumbers(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.getNumbers());
        }
        System.out.println(" ");
    }

    public void showResult(Result result){
        showStatistic(result);
        showEarningLate(result);
    }

    private void showStatistic(Result result){
        Map<Reward,Integer> finalResult = result.getResult();
        finalResult.get(Reward.FAIL);
        System.out.println("\n당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + finalResult.get(Reward.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) - " + finalResult.get(Reward.FOURTH) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + finalResult.get(Reward.THIRD) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + finalResult.get(Reward.SECOND) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + finalResult.get(Reward.FIRST) +"개");
    }

    private void showEarningLate(Result result){
        System.out.println("총 수익률은 "+result.getEarningRate()+"%입니다.");
    }

}
