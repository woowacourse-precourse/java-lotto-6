package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Lotto;

public class LottoService {

    public Integer getCount(int money){
        if(money % 1000 > 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 수를 입력해 주세요.");
        }
        return money / 1000;
    }

    public List<Lotto> lottoGenerate(int count){
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());

    }

}
