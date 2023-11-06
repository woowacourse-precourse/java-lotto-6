package lotto.domain.lotto;

import lotto.exception.LottoNumRangeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumber {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static List<Integer> lottoNumbers;
    private final int num;

    private LottoNumber(int num) {
        validate(num);
        lottoNumbers.add(num);
        this.num = num;
    }

    public static void validate(int num) {
        if(num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM){
            throw new LottoNumRangeException();
        }
    }

    public int getNum(){
        return this.num;
    }


}
