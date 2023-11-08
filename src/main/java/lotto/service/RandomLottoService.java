package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Customer;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoService {
    public List <Lotto> createRandomLotto(int money){
        int num = money / 1000;
        List <Lotto> lottos = Stream.generate(()-> new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)))
                .limit(num)
                .toList();
        return lottos;
    }
}
