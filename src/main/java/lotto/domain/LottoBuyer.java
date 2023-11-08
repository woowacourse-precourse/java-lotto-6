package lotto.domain;

import lotto.common.LottoPrice;
import lotto.validator.ValidatorLottoBuy;

import java.math.BigDecimal;

public class LottoBuyer {

    private final BigDecimal lottoCount;
    private final BigDecimal buyingMoney;

    private LottoBuyer(BigDecimal lottoCount, BigDecimal buyingMoney) {
        this.lottoCount = lottoCount;
        this.buyingMoney = buyingMoney;
    }

    public static LottoBuyer fromString(String buyingLottoNumber) {
        ValidatorLottoBuy.validateString(buyingLottoNumber);
        return new LottoBuyer(convertLottoCount(buyingLottoNumber), convertBigDecimal(buyingLottoNumber));
    }

    private static BigDecimal convertLottoCount(String buyingLottoNumber) {
        BigDecimal buyingMoney = convertBigDecimal(buyingLottoNumber);
        ValidatorLottoBuy.validateNumber(buyingMoney, LottoPrice.PRICE.getBigDecimalPrice());
        return buyingMoney.divide(LottoPrice.PRICE.getBigDecimalPrice());
    }

    private static BigDecimal convertBigDecimal(String buyingLottoNumber) {
        return new BigDecimal(buyingLottoNumber);
    }

    public int getLottoCount() {
        return lottoCount.toBigInteger().intValue();
    }
    
    public BigDecimal getBuyingMoney(){
        return buyingMoney;
    }

}
