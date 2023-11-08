package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.consts.ConstsString.MIN_LOTTO_NUMBER;
import static lotto.consts.ConstsString.MAX_LOTTO_NUMBER;
import static lotto.consts.ConstsString.LOTTO_NUMBERS;

public class LottoNumberGenerator {
    private List<Lotto> lottoNumbers = new ArrayList<>();
    public List<Lotto> generateLottoList(int tickets){
        for(int i = 0; i < tickets; i++){
            lottoNumbers.add(makeLottoNumber());
        }
        return lottoNumbers;
    }

    private Lotto makeLottoNumber(){
        List<Integer> lotto = getRandomNumber();
        return new Lotto(lotto);
    }

    private List<Integer> getRandomNumber(){
        List<Integer> lotto = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_NUMBERS)
        );
        Collections.sort(lotto);
        return lotto;
    }

    public List<Lotto> getLottoNumbers(){
        return lottoNumbers;
    }
}
