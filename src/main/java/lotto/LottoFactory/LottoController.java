package lotto.LottoFactory;

public class LottoController {

    public void CheckDuplicateNum(LottoChecker lottoContainer, Lotto lotto, boolean isBonusDuplicate){
        int count = lottoContainer.countMatchingNum(lotto);  // Lotto 객체를 인자로 전달
        LottoRank.CheckAndStoreRank(count, count == 5 && isBonusDuplicate);
    }

    public int returnAllPrize(){
        return LottoRank.getAllPrizeMoney();
    }
}

