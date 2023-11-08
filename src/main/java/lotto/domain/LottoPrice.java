package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }
    }

    private void buyNothingValidate(Long dataTypeValidatePrice){
        if(dataTypeValidatePrice==BUY_NOTHING){
            throw new IllegalArgumentException("[ERROR] 살 수 없는 금액입니다.");
        }
    }

    private void buyLimitValidate(Long dataTypeValidatePrice){
        if(dataTypeValidatePrice > MAXIMUM_PRICE){
            throw new IllegalArgumentException("[ERROR] 너무 많은 갯수를 구입할 수 없습니다.");
        }
    }

    private void divisionByThousand(Integer buyLimitValidatePrice){
        if(buyLimitValidatePrice%PRICE_PER_LOTTO!=0){
            throw new IllegalArgumentException("[ERROR] 천 단위로 입력해 주세요.");
        }
    }


}
