package view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void guideUserInsertMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void guideUserLottoInfo(List<Lotto> lottos){
        System.out.println(
                String.format("%d개를 구매했습니다.", lottos.size())
        );
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    public void guideUserInsertWinnerNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void guideUserInsertBounsNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void guideUserLottoResults(String result, double amountRatio){
        System.out.println("당첨 통계\n---");
        System.out.print(result);
        guideUserRateOfReturn(amountRatio);
    }

    public void guideUserRateOfReturn(double amountRatio){
        System.out.printf("총 수익률은 %.1f%%입니다.", amountRatio);
    }

}
