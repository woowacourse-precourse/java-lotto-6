package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Process {
    private static final int LOTTO_NUMEBER_RANGE_START = 1;
    private static final int LOTTO_NUMEBER_RANGE_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> lottoNumbers;
    List<Integer> eachLottoNumber;

    //로또 개수 환산하기
    public int countLottos(int purchaseAmount){
        int purchaseCount;

        purchaseCount = purchaseAmount / 1000;

        return purchaseCount;
    }


    //로또 개수만큼 로또 번호 생성
    public List<Integer> generateLottoNumbers(){

        //값을 하드 코딩하지 않는다 - 2주차 피드백
        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMEBER_RANGE_START, LOTTO_NUMEBER_RANGE_END, LOTTO_NUMBER_COUNT);

        return lottoNumbers;
    }




//    Lotto lotto = new Lotto(lottoNumbers);
//    eachLottoNumber = lotto.getLottoNumbers();

//    Lotto(lottoNumbers);



}
