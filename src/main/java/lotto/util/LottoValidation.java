package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.LOTTO_MAX_SIZE;
import static lotto.util.exception.ErrorMessage.INVALID_RANGE;
import static lotto.util.exception.ErrorMessage.INVALID_LOTTO_COUNT;
import static lotto.util.exception.ErrorMessage.INVALID_DUPLICATE_NUMBER;

public class LottoValidation {
    private LottoValidation(){}

    public static void isPermitRange(final int number,final String type){
        if(number < MIN_RANGE || number > MAX_RANGE)
            throw new IllegalArgumentException(String.format(INVALID_RANGE.getErrorMessage(),type));
    }
    public static void lottoCountIsSix(final List<Integer> lotto){
        if(!(lotto.size() == LOTTO_MAX_SIZE))
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getErrorMessage());
    }
    public static void duplicateLottoNumber(final List<Integer> lotto){
        Set<Integer> lottoCount = new HashSet<>(lotto);
        if(lottoCount.size() != LOTTO_MAX_SIZE)
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
    }
    public static void duplicationLottoAndBonusNumber(final List<Integer> lotto, final String bonusNumber){
        if(lotto.contains(Integer.parseInt(bonusNumber)))
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
    }
}
