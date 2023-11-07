package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();
    private final int price;

    public Lottos(int price) {
        validate(price);
        this.price = price;
        int numberOfLotto = price / 1000;
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(numbers));
        }
    }

    private void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottos() {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
