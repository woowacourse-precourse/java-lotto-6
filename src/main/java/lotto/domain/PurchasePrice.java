package lotto.domain;

import java.util.List;
import lotto.controller.dto.ResultResponseDto;

public class PurchasePrice {

    private final int price;
    public static final int LOTTO_PRICE = 1000;
    private static final String PRICE_IS_NOT_FORMATTED_MESSAGE = "[ERROR] 로또의 가격이 맞지 않습니다.";

    public PurchasePrice(int price) {
        this.price = price;
        validatePriceFormat();
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    public double getReturnRate(int profit){
        return Math.round(((double) profit / this.price) * 10000) / 100.0f;
    }

    public double calculatePriceRate(List<ResultResponseDto> dtos) {
        int sum = 0;
        for (ResultResponseDto dto : dtos) {
            int temp = dto.getTotalCount() * dto.getWinnerPrice();
            sum = sum + temp;
        }
        return getReturnRate(sum);
    }


    private void validatePriceFormat() {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalStateException(PRICE_IS_NOT_FORMATTED_MESSAGE);
        }
    }

}
