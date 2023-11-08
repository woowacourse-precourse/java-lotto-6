package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Buyer {

    private int money;
    private List<List<Integer>> lottoCollection = new ArrayList<>();

    public Buyer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setLottoCollection(List<Integer> lotto) {
        List<Integer> sortedLotto = lotto.stream()
                .sorted()
                .collect(Collectors.toList());
        lottoCollection.add(sortedLotto);
    }

    public List<Integer> getLottoCollection(int num) {
        return lottoCollection.get(num);
    }

    public List<List<Integer>> getAllLottoCollection() {
        return lottoCollection;
    }

}
