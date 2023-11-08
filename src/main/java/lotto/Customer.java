package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private final static Integer MIN_MONEY = 1000;
    private final static Integer ZERO = 0;
    private final static String ERROR_1000_LESS_THAN = "1000원 단위로 입력해주세요.";
    private final static String ERROR_NOT_NUMBER = "숫자를 입력해주세요.";
    private final Integer buyPrice;
    private  Map<Integer, List<Integer>> lottoNumbers = new LinkedHashMap<>();
    private Integer winPrice = 0;

    private Customer(Integer buyPrice,Integer winPrice) {
        this.buyPrice = buyPrice;
    }

    public static Customer create(String buyPrice) {
        validateBuyPrice(buyPrice);
        Integer price = Integer.parseInt(buyPrice);
        if(price % MIN_MONEY != ZERO || price.equals(ZERO)) {
            throw new IllegalArgumentException(ERROR_1000_LESS_THAN);
        }
        return new Customer(price, 0);
    }

    public void putLottoNumber(Map<Integer, List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Map<Integer, List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
    public Integer getBuyCount() {
        return buyPrice / MIN_MONEY;
    }

    private static void validateBuyPrice(String buyPrice) {
        try {
            Integer.parseInt(buyPrice);
        }catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NOT_NUMBER);
        }
    }
    public void winPrice(Map<Integer, Integer> result) {
        for(Integer key : result.keySet()) {
            winPrice += (key * result.get(key));
        }
    }
    public Double calcRateOfReturn() {
        return winPrice / (double) buyPrice * 100;
    }
}
