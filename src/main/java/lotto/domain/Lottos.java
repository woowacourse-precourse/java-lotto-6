package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lottos {
    List<Lotto> lottos;

    public void generateLottos(int count) {
        lottos = new ArrayList<>();
        for(int i =0; i<count; i++){
            List<Integer> lottoNumbers = new ArrayList<>(generateLottoNumbers());
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
