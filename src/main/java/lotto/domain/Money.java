package lotto.domain;

import lotto.config.GameConfig;

public record Money(int amount) {

    public Money {
        validateMoney(amount);
    }

    private void validateMoney(int amountOfMoney) {
       validateRange(amountOfMoney);
       validateUnit(amountOfMoney);
    }

    private void validateRange(int amountOfMoney) {
        if (amountOfMoney < GameConfig.MONET_MIN_NUMBER) {
            throw new IllegalArgumentException();  // TODO: custom 예외 만들기
        }
    }

    private void validateUnit(int amountOfMoney) {
        if (amountOfMoney % GameConfig.LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException();  // TODO: custom 예외 만들기
        }
    }
}
