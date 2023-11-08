package lotto.domain;

import static lotto.util.errorMessage.BUY_NOTHING_ERROR;
import static lotto.util.errorMessage.DATA_TYPE_ERROR;
import static lotto.util.errorMessage.DIFFERENT_UNIT_ERROR;
import static lotto.util.errorMessage.EXCESSIVE_NUMBER_ERROR;

public class LottoPrice {
    private final int lottoPrice;
    private static Long MAXIMUM_PRICE = 10000000L;
    private static int PRICE_PER_LOTTO = 1000;
    private static int BUY_NOTHING = 0;

    public LottoPrice(String inputLottoPrice){
        Long dataTypeValidatePrice = dataTypeValidate(inputLottoPrice);
        buyNothingValidate(dataTypeValidatePrice);
        buyLimitValidate(dataTypeValidatePrice);
        int buyLimitValidatePrice = dataTypeValidatePrice.intValue();;
        divisionByThousand(buyLimitValidatePrice);

        this.lottoPrice = buyLimitValidatePrice;
    }

    public int getLottoPrice(){
        return lottoPrice;
    }

    private Long dataTypeValidate(String inputLottoPrice){
        try{
            return Long.parseLong(inputLottoPrice);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(DATA_TYPE_ERROR.getMessage());
        }
    }

    private void buyNothingValidate(Long dataTypeValidatePrice){
        if(dataTypeValidatePrice==BUY_NOTHING){
            throw new IllegalArgumentException(BUY_NOTHING_ERROR.getMessage());
        }
    }

    private void buyLimitValidate(Long dataTypeValidatePrice){
        if(dataTypeValidatePrice > MAXIMUM_PRICE){
            throw new IllegalArgumentException(EXCESSIVE_NUMBER_ERROR.getMessage());
        }
    }

    private void divisionByThousand(Integer buyLimitValidatePrice){
        if(buyLimitValidatePrice%PRICE_PER_LOTTO!=0){
            throw new IllegalArgumentException(DIFFERENT_UNIT_ERROR.getMessage());
        }
    }


}
