package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

public class AutoLotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int CNT_LOTTO_NUMBER = 6;

    private static List<Integer> lottoNums = new ArrayList<>();
    public AutoLotto(){
        createAutoLotto();
    }
    public  void createAutoLotto(){
        lottoNums = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        lottoNums = sortLotto(lottoNums);
    }
    public List<Integer> sortLotto(List<Integer> lottoNums){
        List<Integer> sortLottoList = new ArrayList<>(lottoNums);
        sortLottoList.sort(Comparator.naturalOrder());
        return sortLottoList;
    }
    public static List<Integer> getAutoLotto(){
        return lottoNums;
    }
}
