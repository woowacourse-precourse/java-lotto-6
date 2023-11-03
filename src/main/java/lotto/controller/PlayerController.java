package lotto.controller;

import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static lotto.constant.ExceptionMessage.INSUFFICIENT_PRICE_TO_BUY;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.PlayerService;

public class PlayerController {

    private final PlayerService playerService = new PlayerService();

    public List<Lotto> purchaseLotto(String input) {
        validateIsNumeric(input);
        Long price = Long.parseLong(input);
        validateIsMinimumPrice(price);
        return playerService.purchaseLotto(price);
    }

    private void validateIsNumeric(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR.getMessage());
            }
        }
    }

    private void validateIsMinimumPrice(Long price) {
        if (price < LOTTO_PRICE.getInfo()) {
            throw new IllegalArgumentException(INSUFFICIENT_PRICE_TO_BUY.getMessage());
        }
    }

}
