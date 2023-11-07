package lotto.service;

import lotto.controller.InputController;
import lotto.util.ErrorMessage;
import lotto.util.LottoValues;

public class LottoCountGenerator {

    public Integer getLottoCount(int customerPrice) {

        Integer lottoCount;

        while(true){
            try{
                lottoCount = parseLottoCount(customerPrice);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE);
                System.out.println();
            }
        }

        return lottoCount;
    }

    public Integer getCustomerPrice() {

        Integer customerPrice;

        while(true){
            try{
                customerPrice = InputController.inputPrice();
                break;
            }catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE);
                System.out.println();
            }
        }

        return customerPrice;
    }

    private int parseLottoCount(int customerPrice) throws IllegalArgumentException{
        if (canChangeCountByLottoPrice(customerPrice)) {
            throw new IllegalArgumentException();
        }
        return customerPrice / LottoValues.LOTTO_PRICE;
    }

    private static boolean canChangeCountByLottoPrice(int customerPrice) {
        return (customerPrice % LottoValues.LOTTO_PRICE != 0) || (customerPrice == 0);
    }
}
