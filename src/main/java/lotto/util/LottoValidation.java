package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.LOTTO_MAX_SIZE;
public class LottoValidation {
    private LottoValidation(){}

    public static boolean isPermitRange(final String number){
        return Integer.parseInt(number) >= MIN_RANGE && Integer.parseInt(number) <= MAX_RANGE;
    }
    public static boolean lottoCountIsSix(final List<Integer> lotto){
        return lotto.size() == LOTTO_MAX_SIZE;
    }
    public static boolean duplicateLottoNumber(final List<Integer> lotto){
        Set<Integer> lottoCount = new HashSet<>(lotto);
        return lotto.size() == lottoCount.size();
    }
    public boolean duplicationLottoAndBonusNumber(final List<Integer> lotto, final String bonusNumber){
        return lotto.contains(Integer.parseInt(bonusNumber));
    }
}
