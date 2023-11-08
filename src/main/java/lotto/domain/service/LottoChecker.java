package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.StyledEditorKit.BoldAction;
import lotto.domain.model.Lotto;
import lotto.domain.view.OutputView;

public class LottoChecker {
    public void checkNumberOfWinningLotto(List<Lotto> lottos, Lotto winningNumber, int bonusNumber) {
        List<Integer> matchingCountList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.checkWinningNumber(winningNumber);
            matchingCountList.add(matchCount);
        }
        OutputView outputView = new OutputView();
        outputView.printWinningStatistics(matchingCountList, checkBonusNumber(lottos,bonusNumber));
    }

    public List<Boolean> checkBonusNumber(List<Lotto> lottos, int bonusNumber) {
        List<Boolean> isMatchBonusNumber = new ArrayList<>();
        for (Lotto lotto : lottos) {
            for (int number : lotto.getNumbers()) {
                if (number == bonusNumber) {
                    isMatchBonusNumber.add(true);
                } else {
                    isMatchBonusNumber.add(false);
                }
            }
        }
        return isMatchBonusNumber;
    }
}
