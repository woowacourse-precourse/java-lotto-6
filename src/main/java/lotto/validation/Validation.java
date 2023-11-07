package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public void totalWinngLottoCheck(List<Integer> lottos) {
        checkWinningLottoRange(lottos);
        checkWinningLottoSize(lottos);
        checkWinningLottoDuplicate(lottos);
    }

    public void totalBonusNumCheck(List<Integer> lottos, int bonus) {
        checkBonusNumRange(bonus);
        checkBonusNumDuplicate(lottos, bonus);
    }

    public int checkWinningNum(String winningNum) {
        try {
            return Integer.parseInt(winningNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 올바르게 입력 하세요.");
        }
    }

    private void checkWinningLottoRange(List<Integer> lottos) {
        for (Integer lotto : lottos) {
            if (lotto <= 0 || lotto > 45)
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 0 ~ 45 사이에서 입력해 주세요.");
        }
    }

    private void checkWinningLottoSize(List<Integer> lottos) {
        if (lottos.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해 주세요.");
        }
    }

    private void checkWinningLottoDuplicate(List<Integer> lottos) {
        Set<Integer> winningSizeCheck = new HashSet<>(lottos);
        if (winningSizeCheck.size() != 6)
            throw new IllegalArgumentException("[ERROR] 서로 다른 6개의 당첨 번호를 입력해 주세요.");
    }

    public int checkBonusNum(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 올바르게 입력 하세요.");
        }
    }

    private void checkBonusNumDuplicate(List<Integer> lotts, int bonus) {
        if (lotts.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되어 있지 않은 번호를 보너스 번호로 입력해 주세요.");
    }

    private void checkBonusNumRange(int bonus) {
        if (bonus <= 0 || bonus > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 0 ~ 45 사이에서 입력해 주세요.");
    }
}
