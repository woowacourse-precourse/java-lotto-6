package lotto.controller;

import lotto.domain.ResultSave;
import lotto.domain.db.PurchaseLottoCollection;
import lotto.domain.db.WinningLotto;

import java.util.List;

public class SaveResultController {
    public static int[] resultControl(PurchaseLottoCollection pc, WinningLotto wl) {
        int[] result = ResultSave.getSaveData(pc.getPurchaseLottos(), wl);
        return result;
    }
}
