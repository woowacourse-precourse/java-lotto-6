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
        System.out.println(String.format("3개 일치 (5,000원) - %d개",lottoResult.get(5)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개",lottoResult.get(4)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개",lottoResult.get(3)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",lottoResult.get(2)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - 0개",lottoResult.get(1)));
    }

    public void outputRateOfReturn(double rateOfReturn){
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 "+df.format(rateOfReturn)+"%입니다.");
    }
}
