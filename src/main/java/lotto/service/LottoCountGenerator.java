package lotto.service;

import lotto.controller.InputController;
import lotto.controller.RepeatController;
import lotto.util.ErrorMessage;
import lotto.util.LottoValues;

public class LottoCountGenerator {

    public Integer getLottoCount(int customerPrice) {
        Integer lottoCount = parseLottoCount(customerPrice);
        return lottoCount;
    }

    public Integer getCustomerPrice() {
        Integer customerPrice = RepeatController.repeat(() -> inputAndValidateCustomerPrice());

        return customerPrice;
    }

    private int parseLottoCount(int customerPrice) {
        return customerPrice / LottoValues.LOTTO_PRICE;
    }

    private boolean canChangeCountByLottoPrice(int customerPrice) {
        return (customerPrice % LottoValues.LOTTO_PRICE != 0) || (customerPrice == 0);
    }

    private Integer inputAndValidateCustomerPrice(){
        int customerPrice = InputController.inputPrice();

        if (canChangeCountByLottoPrice(customerPrice)) {
            System.out.println(ErrorMessage.ERROR_LOTTO_COUNT_MESSAGE);
            System.out.println();
            throw new IllegalArgumentException();
        }
        return customerPrice;
    }
}
