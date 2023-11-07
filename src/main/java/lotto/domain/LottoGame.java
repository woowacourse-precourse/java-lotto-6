package lotto.domain;

import java.util.List;
import lotto.config.RankConfig;
import lotto.config.ValidatorConfig;
import lotto.util.Validation;

public class LottoGame {

    private final int bonus;
    private final Lotto winningLotto;


    public LottoGame(int bonus, Lotto winningLotto){
        this.winningLotto = winningLotto;

        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus){
        Validation.validateNumberInRange(bonus);
        if(winningLotto.contains(bonus))
            throw new IllegalArgumentException(ValidatorConfig.DUPLICATED_NUMBER_IN_LIST_ERROR.getMessage());
    }

    public LottoGameResult checkGameResult(List<Lotto> lottoNumbers){
        LottoGameResult result = new LottoGameResult();
        for(Lotto lotto : lottoNumbers) {
            RankConfig rankConfig = Rank.ranking(countMatchLotto(lotto), matchBonus(lotto));
            result.setLottoResult(rankConfig);
        }
        return result;
    }

    private boolean matchBonus(Lotto otherLotto){
        boolean check = otherLotto.contains(bonus);
        return check;
    }

    private int countMatchLotto(Lotto otherLotto){
        int count = otherLotto.countMatchNumbers(winningLotto);

        return count;
    }


}
