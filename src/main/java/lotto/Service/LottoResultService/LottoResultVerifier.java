package lotto.Service.LottoResultService;

import java.util.List;
import java.util.Objects;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Service.PromptService.PromptService;

public class LottoResultVerifier {

    private Integer bonusNumber;
    private List<Integer> winningNumber;
    private final LottoWinningResult winningResultList;
    private final LottoSet lottoSet;
    private final PromptService Prompt;


    public LottoResultVerifier(PromptService Prompt, LottoSet lottoSet) {
        this.Prompt = Prompt;
        this.lottoSet = lottoSet;
        this.winningResultList = new LottoWinningResult();
    }

    public LottoWinningResult findWinningLotto() {

        this.winningNumber = Prompt.getLottoWinningNumber().getWinningNumber();
        this.bonusNumber = Prompt.getLottoBonusNumber().getBonusNumber();

        for (Lotto lotto : lottoSet.getLottoSet()) {
            int matchingCount = matchingLottoCount(lotto);
            if (matchingCount == 5) {
                matchingCountFive(lotto, matchingCount);
            }
            if (matchingCount != 5) {
                winningResultList.addMatchingLotto(matchingCount, lotto);
            }
        }

        return winningResultList;
    }

    private void matchingCountFive(Lotto lotto, int matchingCount) {
        boolean isMatchingBonus = matchingBonusCount(lotto);
        if (isMatchingBonus) {
            winningResultList.addMatchingLotto(7, lotto);
        }
        if (!isMatchingBonus) {
            winningResultList.addMatchingLotto(matchingCount, lotto);
        }

    }

    private boolean matchingBonusCount(Lotto lotto) {
        long count = lotto.getNumbers().stream().filter(number -> Objects.equals(number, bonusNumber)).count();
        return count > 0;
    }

    private int matchingLottoCount(Lotto lotto) {
        return (int) winningNumber.stream()
                .filter(lotto.getNumbers()::contains)
                .count();

    }
}
