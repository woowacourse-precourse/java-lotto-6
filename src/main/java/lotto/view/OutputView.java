package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String PURCHASE_INFORMATION = "개를 구매했습니다.";

    //발행한 로또 수량 및 번호를 출력하는 기능
    public void lottoTickets(List<Lotto> lottos) {

        System.out.printf("%d%s %n", lottos.size(), PURCHASE_INFORMATION);

        for(int i=0; i<lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }


    }

    //당첨통계를 출력하는 기능
    public void winningRecords(List<Integer> rankResult) {

        System.out.printf("3개 일치 (5,000원) - %d개 %n", rankResult.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개 %n", rankResult.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개 %n", rankResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개 %n", rankResult.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개 %n", rankResult.get(0));
    }

    //상금 수익율을 보여주는 기능
    public void prizesSummary(float rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

}
