package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Class : 로또 발급 관리 기계 클래스
 */
public class LottoMachine {

    private int startNumber;
    private int endNumber;
    private int count;

    private LottoMachine() {
    }

    public LottoMachine(int startNumber, int endNumber, int count) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.count = count;
    }

    public List<Lotto> getLottoList(int price, int amount) {
        return IntStream.range(0, amount / price)
                .mapToObj(i -> {
                    List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count));
                    randomNumbers.sort(Integer::compareTo);
                    return new Lotto(randomNumbers);
                })
                .collect(Collectors.toList());
    }
}
