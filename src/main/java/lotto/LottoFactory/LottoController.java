package lotto.LottoFactory;

public class LottoController {

    public void CheckDuplicateNum(LottoChecker lottoContainer, Lotto lotto, boolean isBonusDuplicate){
        int count = lottoContainer.countMatchingNum(lotto);
        LottoRank.CheckAndStoreRank(count, count == 5 && isBonusDuplicate);
    }

    public int returnAllPrize(){
        return LottoRank.getAllPrizeMoney();
    }

}

