package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;

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

    public void showStatistic(Result result){
        System.out.println("\n당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + result.getThree() +"개");
        System.out.println("4개 일치 (50,000원) - " + result.getFour() +"개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getFive() +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getFiveNBonus() +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getSix() +"개");
    }

    public void showEarningLate(String earningRate){
        System.out.println("총 수익률은 "+earningRate+"%입니다.");
    }

}
