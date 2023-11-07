package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utility.enums.Standards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private List<Integer> lottoNumbers;
    private List<Lotto> lottoCollection;

    public LottoGenerator(){
        lottoCollection = new ArrayList<>();
    }

    public List<Lotto> generate(int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(Collections.unmodifiableList(lottoNumbers));
            lottoCollection.add(lotto);
        }
        Collections.unmodifiableList(lottoCollection);

        return lottoCollection;
    }
}
