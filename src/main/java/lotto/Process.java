package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    //각 로또 번호들 오름차순으로 정리
    public void sortLottoNumbers(List<Integer> lottoNumbers){
        Collections.sort(lottoNumbers);
    }


    public List<Object> compareLottos(List<Integer> eachLottoNumber, List<Integer> winningNumbers, int bonusNumber){
        int mainNumberMatchCount = 0;
        boolean matchBonusNumber = false;
        List<Object> result = new ArrayList<>();


        for(var element : eachLottoNumber){
            if(winningNumbers.contains(element)){
                mainNumberMatchCount++;
            }
            if(element == bonusNumber){
                matchBonusNumber = true;
            }
        }

        result.add(mainNumberMatchCount);
        result.add(matchBonusNumber);

        return result;
    }



//    Lotto lotto = new Lotto(lottoNumbers);
//    eachLottoNumber = lotto.getLottoNumbers();

//    Lotto(lottoNumbers);



}
