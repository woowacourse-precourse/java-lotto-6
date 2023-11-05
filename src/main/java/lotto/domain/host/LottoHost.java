package lotto.domain.host;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Config;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Utii;

public class LottoHost {
    private String winNumbers;
    private String bonusNumbers;

    public String pickWinNumbers() {
        // TODO: 11/5/23 입력 체크.
        winNumbers = Console.readLine();
        return winNumbers;
    }

    public String pickBonusNumber() {
        // TODO: 11/5/23 입력 체크.
        bonusNumbers = inputBonusNumbers();
        return bonusNumbers;
    }

    private String inputBonusNumbers() {
        String inputBonusNumber = Utii.InputStringLine();

        return inputBonusNumber;
    }


    public LottoTargetNumResults giveLottoTargetNumResults() {
        return Config.lottoTargetNumResults(winNumbers, bonusNumbers);
    }

}
