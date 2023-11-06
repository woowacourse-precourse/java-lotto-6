package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Amount;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumRandomGenerator {

    private static final int MIN=1;
    private static final int MAX=45;
    private static final int AMOUNT=6;

    public List<Lotto> purchaseLottery(Amount amount){
        List<Lotto> result = new ArrayList<>();

        for(int count=0;count<amount.getCount();count++){
            Lotto lotto = new Lotto(setRandomNum());
            result.add(lotto);
        }

        return result;
    }

    public List<Integer> setRandomNum(){
        List<Integer> result=sortRandomNum(Randoms.pickUniqueNumbersInRange(MIN, MAX, AMOUNT));
        return result;
    }

    private List<Integer> sortRandomNum(List<Integer> randomNum){
        Collections.sort(randomNum);
        return randomNum;
    }
}
