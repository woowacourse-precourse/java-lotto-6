package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.GameConstant;

public class LottoGenerator {
    public List<Lotto> makeLotto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(GameConstant.NUMBER_MIN,
                    GameConstant.NUMBER_MAX, GameConstant.NUMBER_SIZE)
                    .stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }
}
