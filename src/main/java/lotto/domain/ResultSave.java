package lotto.domain;

import lotto.domain.db.PurchaseLotto;
import lotto.domain.db.WinningLotto;

import java.util.List;

public class ResultSave {
    public static int[] getSaveData(List<PurchaseLotto> pLottoList, WinningLotto wLotto) {
        int[] saveData = new int[8];
        for (PurchaseLotto pLotto : pLottoList) {
            int curResult = new ResultCounter().counter(pLotto.getLottoNumbers(), wLotto.getLottoNumbers());
            if (BonusFlag.flag(pLotto, wLotto) && (curResult == 5)) {
                curResult += 2;
            }
            saveData[curResult]++;
        }
        return saveData;
    }
}
