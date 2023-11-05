package lotto.domain.host;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Config;
import lotto.domain.num.LottoTargetNumResults;

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
        bonusNumbers = Console.readLine();
        return bonusNumbers;
    }


    public LottoTargetNumResults giveLottoTargetNumResults() {
        return Config.lottoTargetNumResults(winNumbers, bonusNumbers);
    }

    /**
     * 중복되는 번호가 있는지 확인한다.
     *
     * @return
     */
    // TODO: 11/5/23 삭제 
//    public Boolean checkDuplicateWinNum(String targetNum) {
//        Boolean isSame = false;
//        Integer target = Integer.valueOf(targetNum);
//
//        for (int indexOfSpecial = 0; indexOfSpecial < 7; indexOfSpecial++) {
//            isSame = lottoNumResults.isSame(target, indexOfSpecial);
//            if (isSame) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
