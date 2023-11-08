package lotto.model;

import static lotto.util.constants.Numbers.LOTTO_PRICE;
import static lotto.util.constants.Numbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.util.constants.Numbers.MINIMUM_LOTTO_NUMBER;
import static lotto.util.constants.Numbers.VALID_NUMBER_LIST_SIZE;
import static lotto.util.constants.Strings.NEXT_LINE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublishedLotto {
    private final List<Lotto> publishedLotto;

    PublishedLotto(final Integer money) {
        publishedLotto = new ArrayList<>();
        publishLotto(money);
    }

    public static PublishedLotto getInstance(final Integer money) {
        return new PublishedLotto(money);
    }

    /**
     * 발행된 로또의 개수를 반환하는 메서드.
     *
     * @return 발행된 로또의 개수(Integer)
     */
    public Integer getCount() {
        return publishedLotto.size();
    }

    @Override
    public String toString() {
        return publishedLotto.stream()
                .map(Object::toString)
                .collect(Collectors.joining(NEXT_LINE.getString()));
    }

    List<Lotto> getPublishedLotto() {
        return publishedLotto;
    }

    private void publishLotto(Integer money) {
        while (money > 0) {
            money -= LOTTO_PRICE.getNumber();
            List<Integer> numbers = generateRandomList();
            publishedLotto.add(new Lotto(numbers));
        }
    }

    private List<Integer> generateRandomList() {
        int minimum = MINIMUM_LOTTO_NUMBER.getNumber();
        int maximum = MAXIMUM_LOTTO_NUMBER.getNumber();
        int count = VALID_NUMBER_LIST_SIZE.getNumber();
        return Randoms.pickUniqueNumbersInRange(minimum, maximum, count);
    }
}
