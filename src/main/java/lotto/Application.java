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
import lotto.View.OutputView.OutputView;


public class Application {


    public static void main(String[] args) {

        // 초기화
        PromptService Prompt = new PromptService();
        LottoTicketService number = new LottoTicketService(Prompt);
        LottoResultVerifier resultVerifier = new LottoResultVerifier(Prompt);
        ProfitRateService profitRateService = new ProfitRateService();
        OutputView outputView = new OutputView();


        //로또 발행
        LottoSet lottoList = number.GenerateLottoSet();

        outputView.lottoSetPrint(lottoList);

        //로또 결과 조회
        LottoWinningResult lottoWinningResult = resultVerifier.findWinningLotto(lottoList);
        //수익률 계산
        ProfitRate totalProfit = profitRateService.calculateProfit(lottoWinningResult);


        //당첨 통계
        outputView.profitRatePrint(lottoWinningResult);

        System.out.println("총수익률 : " + totalProfit.getStringProfitRate() +  "%");



    }

}
