package lotto.domain;

import static lotto.util.ErrorMessage.PRICE_IS_LOWER_ERROR;
import static lotto.util.ErrorMessage.PRICE_IS_NOT_FORMATTED_MESSAGE;

import java.util.List;
import lotto.controller.dto.ResultResponseDto;

public class PurchasePrice {

    private final int price;
    public static final int LOTTO_PRICE = 1000;

    public PurchasePrice(int price) {
        this.price = price;
        validatePriceFormat();
        validatePriceIsOverLotto();
    }

    private void validatePriceIsOverLotto() {
        if (price < LOTTO_PRICE) {
            throw new IllegalStateException(PRICE_IS_LOWER_ERROR.getMessage());
        }
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    public double getReturnRate(int profit) {
        return Math.round(((double) profit / this.price) * 10000) / 100.0f;
    }

    public double calculatePriceRate(List<ResultResponseDto> dtos) {
        return getReturnRate(getSum(dtos));
    }

    private int getSum(List<ResultResponseDto> dtos) {
        return dtos.stream()
                .mapToInt(dto -> dto.getTotalCount() * dto.getWinnerPrice())
                .sum();
    }


    private void validatePriceFormat() {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalStateException(PRICE_IS_NOT_FORMATTED_MESSAGE.getMessage());
        }
    }

}
