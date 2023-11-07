package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

//로또 번호 생성(1-45)
public class LottoNumbers {

    public LottoNumbers(){

    }

    public static final int CNT_LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;

    public  static final int MAX_LOTTO_NUMBER = 45;



    public static List<Integer>lottoNumbers;


    public static List<Integer>RandomLottoNumbers(){
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,CNT_LOTTO_NUMBER);
        List<Integer> lottoNumbersList =  new ArrayList<>(lottoNumbers);//lottoNumbers를 lottoNumbersList로 복제하여 반환
        Collections.sort(lottoNumbersList);
        return lottoNumbersList;
    }

}
