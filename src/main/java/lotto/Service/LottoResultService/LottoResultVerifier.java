package lotto.Service.LottoResultService;

import java.util.List;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Service.PromptService.PromptService;

public class LottoResultVerifier {

    public LottoWinningResult findWinningLotto(LottoSet lottoSet) {
        LottoWinningResult winningResultList = new LottoWinningResult();

        for(Lotto lotto : lottoSet.getLottoSet()){
            winningResultList.addMatchingLotto(matchingLottoCount(lotto),lotto);
        }

        return winningResultList;
    }

    private int matchingLottoCount(Lotto lotto){
        List<Integer> winningNumber = getLottoWinningNumber();
        Integer bonusNumber = getLottoBonusNumber();

        return Math.toIntExact(winningNumber.stream()
                .filter(lotto.getNumbers()::contains)
                .count());

    }

    private List<Integer> getLottoWinningNumber(){
        PromptService Prompt = new PromptService();
        return Prompt.getLottoWinningNumber().getWinningNumber();
    }

    private Integer getLottoBonusNumber(){
        PromptService Prompt = new PromptService();
        return Prompt.getLottoBonusNumber().getBonusNumber();
    }

}
