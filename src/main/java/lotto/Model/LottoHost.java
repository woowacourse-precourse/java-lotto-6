package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoHost {

    private Lotto lottoAnswer;
    private Integer bonusNumber;

    public Lotto generateLotto(){
        return new Lotto(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers(){
        List<Integer> host = new ArrayList<>();
        while (host.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!host.contains(randomNumber)) {
                host.add(randomNumber);
            }
        }
        return host;
    }
}
