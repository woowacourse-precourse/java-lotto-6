package lotto.domain;

import java.util.List;
import lotto.util.constants.DomainConstants;

public class LottoJudge {

    private final JudgeCounter judgeCounter;

    public LottoJudge() {
        this.judgeCounter = new JudgeCounter();
    }

    public JudgeCounter judgeLottoTicket(LottoTicket lottoTicket, WinnerNumbers winnerNumbers,
                                         BonusNumber bonusNumber) {
        List<Lotto> ticket = lottoTicket.getLottos();
        List<Integer> winnerLottoNumbers = winnerNumbers.getWinnerNumbers();
        int bonusLottoNumber = bonusNumber.getBonusNumber();

        int judgeCount;

        for (Lotto lotto : ticket) {
            judgeCount = compare(lotto, winnerLottoNumbers);
            boolean checkBonus = isContainBonusNumber(lotto, bonusLottoNumber);
            manageJudgeCount(judgeCount, checkBonus);
        }
        return judgeCounter;
    }

    private int compare(Lotto lotto, List<Integer> winnerNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        lottoNumbers.retainAll(winnerNumbers);
        return lottoNumbers.size();
    }

    private boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    private void manageJudgeCount(int judgeCount, boolean checkBonus) {
        int BONUS_CHECK_CONDITION = DomainConstants.BONUS_CHECK_CONDITION.getConstants();
        if (judgeCount == BONUS_CHECK_CONDITION) {
            addJudgeCountByBonus(judgeCount, checkBonus);
            return;
        }
        addJudgeCount(judgeCount);
    }

    private void addJudgeCount(int judgeCount) {
        int FIRST_RANK = DomainConstants.FIRST_RANK.getConstants();
        int FIRST_RANK_CONDITION = DomainConstants.FIRST_RANK_CONDITION.getConstants();
        int FOURTH_RANK_CONDITION = DomainConstants.FOURTH_RANK_CONDITION.getConstants();
        int FIFTH_RANK_CONDITION = DomainConstants.FIFTH_RANK_CONDITION.getConstants();

        if (judgeCount == FIFTH_RANK_CONDITION || judgeCount == FOURTH_RANK_CONDITION) {
            judgeCounter.addCount(8 - judgeCount);
            return;
        }
        if (judgeCount == FIRST_RANK_CONDITION) {
            judgeCounter.addCount(FIRST_RANK);
        }
    }

    private void addJudgeCountByBonus(int judgeCount, boolean isContainBonusNumber) {
        int SECOND_RANK_CONDITION = DomainConstants.SECOND_RANK_CONDITION.getConstants();
        int THIRD_RANK_CONDITION = DomainConstants.THIRD_RANK_CONDITION.getConstants();
        int SECOND_RANK = DomainConstants.SECOND_RANK.getConstants();
        int THIRD_RANK = DomainConstants.THIRD_RANK.getConstants();

        if (judgeCount == THIRD_RANK_CONDITION && !isContainBonusNumber) {
            judgeCounter.addCount(THIRD_RANK);
            return;
        }

        if (judgeCount == SECOND_RANK_CONDITION && isContainBonusNumber) {
            judgeCounter.addCount(SECOND_RANK);
        }
    }
}
