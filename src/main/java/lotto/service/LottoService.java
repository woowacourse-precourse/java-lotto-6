package lotto.service;

import java.util.ArrayList;
import java.util.List;
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

    public void convertToIntegerList(String winningNumbers) {
        String[] arrayWinningNumbers = winningNumbers.split(",");
        List<Integer> ListWinningNumbers = parseIntWinningNumbers(arrayWinningNumbers);
        checkValidLength(ListWinningNumbers);
        checkDuplicateInputNumber(ListWinningNumbers);
        checkOutOfLottoNumericalRange(ListWinningNumbers);
        lottoDatas.inputWinningNumber(ListWinningNumbers);
    }

    private void checkValidLength(List<Integer> listWinningNumbers) {
        Validator.validateInputLength(listWinningNumbers);
    }

    private void checkDuplicateInputNumber(List<Integer> listWinningNumbers) {
        Validator.duplicateInputWinningNumbers(listWinningNumbers);
    }

    private void checkOutOfLottoNumericalRange(List<Integer> listWinningNumbers) {
        for (int listIndex = 0; listIndex < listWinningNumbers.size(); listIndex++) {
            Validator.outOfLottoNumericalRange(listWinningNumbers.get(listIndex));
        }
    }

    public List<Integer> parseIntWinningNumbers(String[] arrayWinningNumbers) {
        List<Integer> listWinningNumbers = new ArrayList<>();
        for (int arrayIndex = 0; arrayIndex < arrayWinningNumbers.length; arrayIndex++) {
            Validator.ParseIntNumber(arrayWinningNumbers[arrayIndex]);
            listWinningNumbers.add(Integer.valueOf(arrayWinningNumbers[arrayIndex]));
        }
        return listWinningNumbers;
    }

}
