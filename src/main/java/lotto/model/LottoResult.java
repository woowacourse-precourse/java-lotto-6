package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoResult {
    FIFTH_PRIZE(3, false, 5000, 0),
    FOURTH_PRIZE(4, false, 50000,1),
    THIRD_PRIZE(5, false, 1500000,2),
    SECOND_PRIZE(5, true, 30000000,3),
    FIRST_PRIZE(6, false, 2000000000,4),
    NO_PRIZE(0, false, 0,-1);

    private final Integer matchedWinningNumberCount;
    private final Boolean matchedBonusNumber;
    private final Integer prizeMoney;
    private final Integer index;

    LottoResult(Integer matchedWinningNumberCount, Boolean matchedBonusNumber, Integer prizeMoney,Integer index) {
        this.matchedWinningNumberCount = matchedWinningNumberCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.prizeMoney = prizeMoney;
        this.index = index;
    }

    public static LottoResult determinePrize(Integer matchedWinningNumberCount, Boolean matchedBonusNumber) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> checkLottoResult(lottoResult, matchedWinningNumberCount, matchedBonusNumber))
                .findAny()
                .orElse(NO_PRIZE);
    }

    private static Boolean checkLottoResult(LottoResult lottoResult, Integer matchedWinningNumberCount, Boolean matchedBonusNumber){
        if(lottoResult.matchedWinningNumberCount.equals(matchedWinningNumberCount) &&
                lottoResult.matchedBonusNumber.equals(matchedBonusNumber)){
            return true;
        }
        return false;
    }

    public static void sort(List<LottoResult> lottoResults){
        Collections.sort(lottoResults, new Comparator<LottoResult>() {
            @Override
            public int compare(LottoResult o1, LottoResult o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

    }

    public Integer getIndex(){
        return index;
    }

    public static LottoResult findByIndex(int index){
        return Arrays.stream(LottoResult.values())
                .filter(lr -> lr.getIndex().equals(index))
                .findAny().orElseThrow();
    }

    public Integer getMatchedWinningNumberCount() {
        return matchedWinningNumberCount;
    }

    public Boolean matchedBonusNumber() {
        return matchedBonusNumber;

    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}