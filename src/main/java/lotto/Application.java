package lotto;

import com.sun.source.tree.SynchronizedTree;
import java.util.List;
import java.util.Map;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Model.ProfitRate.ProfitRate;
import lotto.Service.LottoResultService.LottoResultVerifier;
import lotto.Service.LottoTicketService.LottoTicketService;
import lotto.Service.ProfitRateService.ProfitRateService;
import lotto.Service.PromptService.PromptService;


public class Application {


    public static void main(String[] args) {
        PromptService Prompt = new PromptService();
        LottoTicketService number = new LottoTicketService(Prompt);
        LottoSet lottoList = number.GenerateLottoSet();
        LottoResultVerifier resultVerifier = new LottoResultVerifier(Prompt,lottoList);
        ProfitRateService profitRateService = new ProfitRateService();



        // 생성된 로또 번호 출력
        for (Lotto lotto : lottoList.getLottoSet()) {
            System.out.print("로또번호 : ");
            for (Integer a : lotto.getNumbers()) {
                System.out.print(a + ",");
            }
            System.out.println();
        }

        LottoWinningResult lottoWinningResult = resultVerifier.findWinningLotto();

        ProfitRate totalProfit = profitRateService.calculateProfit(lottoWinningResult);

        for (Map.Entry< Integer, List<Lotto>> entry : lottoWinningResult.getMatchingResults().entrySet()) {
            Integer key = entry.getKey();
            List<Lotto> values = entry.getValue();
            System.out.println("Key: " + key);
            for (Lotto a : values ) {
                System.out.print("로또번호 : ");
                for( Integer b : a.getNumbers()){
                    System.out.print(b + ",");
                }
                System.out.println();
            }
        }

        System.out.println("총수익률 : " + totalProfit.getStringProfitRate() +  "%");



    }

}
