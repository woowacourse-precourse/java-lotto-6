package lotto.view;

import lotto.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void outputLottoTickets(int lottoSize, List<Lotto> lottos){
        System.out.println(String.format("\n%d개를 구매했습니다.",lottoSize));
        for (int i = 0; i< lottos.size(); i++){
            System.out.println(lottos.get(i));
        }
    }

    public void outputLottoResult(List<Integer> lottoResult){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
    }

    public void outputRateOfReturn(double rateOfReturn){
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println(df.format(rateOfReturn));
    }
}
