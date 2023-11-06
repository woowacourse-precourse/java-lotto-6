package lotto.controller.converter;

public class PurchaseAmountConverter implements Converter<Integer> {
    @Override
    public Integer convert(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}