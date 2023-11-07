package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.GameConstants;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoCreService {
    public List<Lotto> createRandomLottos(int count){
        List<Lotto> randomLottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> unSortNumbers = Randoms.pickUniqueNumbersInRange(
                    GameConstants.STARTINCLUSIVE,
                    GameConstants.ENDINCLUSIVE,
                    GameConstants.LOTTO_SIZE
            );
            List<Integer> sortedNumbers = unSortNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            randomLottos.add(new Lotto(sortedNumbers));
        }
        return randomLottos;
    }
}
