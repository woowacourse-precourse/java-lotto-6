package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Service {
    private final Domain domain = Domain.getInstance();

    private Service() {
    }

    private class Singleton {
        private static final Service INSTANCE = new Service();
    }

    public static Service getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Integer> lottoGenerator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int numberGenerator() {
        return Randoms.pickNumberInRange(1, 45);
    }

    public void setPrice() {
        Domain.price = 1;
    }

    public int numberFrequencyCount(List<Integer> list) {
        Set<Integer> set = new HashSet<>(domain.NUMBERS);
        return (int) list.stream()
                .filter(set::contains)
                .count();
    }

    public void compareNumbers() {
        for (var e : Domain.getInstance().getMyLotto()) {
            domain.getCorrectNumberCount()
                    .add(numberFrequencyCount(e.getNumbers()));
        }
    }
}
