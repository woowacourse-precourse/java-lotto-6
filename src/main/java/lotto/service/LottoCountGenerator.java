package lotto.service;

import lotto.controller.InputController;
import lotto.exception.NumberValidator;
import lotto.util.LottoValues;

public class LottoCountGenerator {

    public Integer getCustomerPrice() {
        Integer customerPrice = InputController.repeat(() -> inputAndValidateCustomerPrice());
        return customerPrice;
    }

    public Integer getLottoCount(int customerPrice) {
        Integer lottoCount = parseLottoCount(customerPrice);
        return lottoCount;
    }

    private int parseLottoCount(int customerPrice) {
        return customerPrice / LottoValues.LOTTO_PRICE;
    }

    private Integer inputAndValidateCustomerPrice(){
        int customerPrice = InputController.inputPrice();

        NumberValidator.validateLottoCount(customerPrice);
        return customerPrice;
    }
}
