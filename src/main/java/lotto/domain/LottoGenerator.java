package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utility.enums.Standards;

import java.lang.reflect.Array;
import java.util.*;

public class LottoGenerator {
    private List<Integer> lottoNumbers;
    private List<Lotto> lottoCollection;


    public LottoGenerator(){
        lottoCollection = new ArrayList<>();
    }

    public List<Lotto> generate(int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers = sortNumbers(lottoNumbers);
            Lotto lotto = new Lotto(Collections.unmodifiableList(lottoNumbers));
            lottoCollection.add(lotto);
        }
        Collections.unmodifiableList(lottoCollection);

        return lottoCollection;
    }

    private List<Integer> sortNumbers(List<Integer> lottoNumbers){
        int arrSize = lottoNumbers.size();
        Integer arr[] = lottoNumbers.toArray(new Integer[arrSize]);
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }
}
