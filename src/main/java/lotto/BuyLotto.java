package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BuyLotto {

    private final Map<Integer, Lotto> buyLotto;
    public BuyLotto(int inputValue) {
        Map<Integer, Lotto> value = getIntegerListMap(inputValue);
        this.buyLotto = value;
    }


    private Map<Integer, Lotto> getIntegerListMap(int inputValue) {

        Map<Integer, Lotto> value = new HashMap<>();

        for(int i = 0; i < inputValue; i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);

            value.put(i, lotto);

        }
        return value;
    }

    public void consoleBuyLotto(){
        for(int i = 0; i< buyLotto.size(); i++){
            System.out.println(buyLotto.get(i).getNumbers());
        }
    }

    public Map<Integer, Lotto> getBuyLotto() {
        return buyLotto;
    }
}