package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublishedLottos {
    private final List<Lotto> publishedLottos;

    PublishedLottos(Integer money) {
        publishedLottos = new ArrayList<>();
        publishLottos(money);
    }

    public static PublishedLottos getInstance(Integer money) {
        return new PublishedLottos(money);
    }

    public Integer getCount() {
        return publishedLottos.size();
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        publishedLottos.forEach(element -> print.append(element.toString()));
        return print.toString();
    }

    private void publishLottos(Integer money) {
        while (money > 0) {
            money -= 1000;
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            publishedLottos.add(new Lotto(numbers));
        }
    }
}
