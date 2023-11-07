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
    public void winningRecords() {

    }

    //상금 수익율을 보여주는 기능
    public void prizesSummary() {

    }

}
