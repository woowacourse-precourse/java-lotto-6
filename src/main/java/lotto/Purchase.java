package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Purchase {
    private int price;
    private final int numLotto;
    List<List<Integer>> buyLottos = new ArrayList<>();

    public Purchase(int price) {
        validate(price);
        this.price = price;
        this.numLotto = price / 1000;
        generateNumbers();
    }

    private void validate(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void generateNumbers() {
        for (int i = 0; i < numLotto; i++) {
            List<Integer> buyLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            buyLottos.add(buyLotto);
        }
        print();
    }

    private void print() {
        System.out.println("\n" + numLotto + "개를 구매했습니다.");
        for (List<Integer> buyLotto : buyLottos) {
            System.out.println(Arrays.toString(buyLotto.toArray()));    // todo: check print format
        }
    }

    public int getPrice() {
        return price;
    }

    public List<List<Integer>> getBuyLottos() {
        return buyLottos;
    }
}
