package lotto;

import lotto.enums.Prompt;
import lotto.view.InputView;

import java.util.List;

public class LottoMain {
    LottoMatcher lottoMatcher;
    List<Lotto> lottos;
    MatchStatusGatherer matchStatusGatherer;
    public LottoMain(){
        this.matchStatusGatherer = new MatchStatusGatherer();
    }
    public void run(){
        int price = InputView.readInt();
        this.lottos = LottoFactory.getLottoListByPrice(price);
        System.out.println(lottos.size() + Prompt.ENTERED_BUYING_EA.getPrompt());
        for(Lotto lotto: lottos){
            System.out.println(lotto.toString());
        }
        lottoMatcher = new LottoMatcher(WinningNumberFactory.getWinningNumber());
        for(Lotto lotto: lottos){
            matchStatusGatherer.addMatchStatus(lottoMatcher.getMatchStatus(lotto));
        }
        matchStatusGatherer.printResult();
    }
}
