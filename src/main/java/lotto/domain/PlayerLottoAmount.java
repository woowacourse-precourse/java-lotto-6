package lotto.domain;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PlayerLottoAmount(String LottoAmount) {
        int lottoAmount = validateNumber(LottoAmount);
        validatePrice(lottoAmount);
        this.amount = lottoAmount;
    }

    public int purchaseTicketCount() {
        return this.amount / LOTTO_PRICE;
    }

    private void validatePrice(int lottoAmount) {
        if (lottoAmount % LOTTO_PRICE != 0) {
            ExceptionMessage.divisionException();
            throw new IllegalArgumentException();
        }
    }

    private int validateNumber(String lottoAmount) {
        if (checkInputEmpty(lottoAmount)) {
            throw new IllegalArgumentException();
        }
        if (!checkInputNumber(lottoAmount)) {
            throw new IllegalArgumentException();
        }
        if (checkInputNegativeNumber(lottoAmount)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(lottoAmount);
    }

    private boolean checkInputEmpty(String input) {
        return input.equals("");
    }
    private boolean checkInputNegativeNumber(String input) {
        return Integer.parseInt(input) < 0;
    }
    private boolean checkInputNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}