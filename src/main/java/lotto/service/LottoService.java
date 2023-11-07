package lotto.service;

import lotto.model.LottoDatas;

public class LottoService {

    private final LottoDatas lottoDatas;

    public LottoService(final LottoDatas lottoDatas) {
        this.lottoDatas = lottoDatas;
    }

    public void convertPurchaseToCount(String inputPurchase) {
        int integerPurchase = parseIntPurchase(inputPurchase);
        int lottoCount = convertCount(integerPurchase);
        lottoDatas.saveCount(lottoCount);
    }

    public int parseIntPurchase(String inputPurchase) {
        Validator.ParseIntNumber(inputPurchase);
        return Integer.parseInt(inputPurchase);
    }

    public int convertCount(int integerPurchase) {
        Validator.notZeroOfRestDividedThousand(integerPurchase);
        return divideByThousand(integerPurchase);
    }

    public int divideByThousand(int integerPurchase) {
        return integerPurchase / 1000;
    }

    public int convertToArray(String winningNumbers) {
        String[] ArrayWinningNumbers = winningNumbers.split(",");
    }

}
