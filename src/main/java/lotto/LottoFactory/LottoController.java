package lotto.LottoFactory;

public class LottoController {

    public void CheckDuplicateNum(LottoChecker lottoContainer, Lotto lotto, boolean isBonusDuplicate){
        int count = lottoContainer.countMatchingNum(lotto);  // Lotto 객체를 인자로 전달
        if(count == 5 && isBonusDuplicate){
            LottoRank.CheckAndStoreRank(count, true);
        } else {
            LottoRank.CheckAndStoreRank(count, false);
        }
    }

    public int returnAllPrize(){
        return LottoRank.getAllPrizeMoney();
    }

}
