package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;

public class GenerateLotto {

    private final OutputService outputService = new OutputService();

    public List<Lotto> generateLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(generateNumbers());
            outputService.printLotto(lotto.getNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
