package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private final static Integer MIN_MONEY = 1000;
    private final Integer buyPrice;
    private final Map<Integer, List<Integer>> lottoNumbers = new LinkedHashMap<>();
    private Integer winPrice;

    private Customer(Integer buyPrice,Integer winPrice) {
        this.buyPrice = buyPrice;
    }

    public static Customer create(Integer buyPrice) {
        if(buyPrice % MIN_MONEY != 0 || buyPrice == 0 ) {
            throw new IllegalArgumentException();
        }
        return new Customer(buyPrice, 0);
    }

    public void putLottoNumber(int key, List<Integer> value) {
        lottoNumbers.put(key, value);
    }

    public Map<Integer, List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }


}
