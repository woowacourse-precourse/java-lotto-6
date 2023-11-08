package lotto;

import lotto.LottoManager;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();
        lottoManager.insertMoney();
        lottoManager.buyLottoAmount();
        lottoManager.showBuyAmount();
        lottoManager.loopCreateLottoCandidateNumbers();
        lottoManager.showAllLottoCandidateSets();
        lottoManager.insertLottoNumbers();
        lottoManager.insertBonusNumber();
        lottoManager.loopJudgeLottoCandidateSetsResult();
    }
}
