package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoDatas;
import lotto.view.OutputView;

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
        Validator.parseIntNumber(inputPurchase);
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

    public void checkBonusNumber(String bonusNumber) {
        int integerBonusNumber = parseIntBonusNumbers(bonusNumber);
        checkDuplicateBonusNumber(integerBonusNumber);
        checkOutOfBonusNumericalRange(integerBonusNumber);
        lottoDatas.inputBonusNumber(Integer.parseInt(bonusNumber));
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
            Validator.parseIntNumber(arrayWinningNumbers[arrayIndex]);
            listWinningNumbers.add(Integer.valueOf(arrayWinningNumbers[arrayIndex]));
        }
        return listWinningNumbers;
    }

    public int parseIntBonusNumbers(String bonusNumbers) {
        Validator.parseIntNumber(bonusNumbers);
        return Integer.parseInt(bonusNumbers);
    }

    public void checkDuplicateBonusNumber(int integerBonusNumber) {
        Validator.duplicateBonusNumber(integerBonusNumber, lottoDatas.getWinningNumbers());
    }

    public void checkOutOfBonusNumericalRange(int integerBonusNumber) {
        Validator.outOfLottoNumericalRange(integerBonusNumber);
    }

    public void printLottoCount() {
        OutputView.printPurChaseCount(lottoDatas.getLottoCount());
    }

    public void printLottoNumbers() {

        for (int lottoCountIndex = 0; lottoCountIndex < lottoDatas.getLottoCount(); lottoCountIndex++) {
            StringBuilder printLottoNumbers = new StringBuilder();
            printLottoNumbers.append("[");
            printLottoNumbers = getEachLottoNumber(printLottoNumbers, lottoCountIndex);
            printLottoNumbers.append("]");
            OutputView.printLottoNumbers(printLottoNumbers);
        }
    }

    private StringBuilder getEachLottoNumber(StringBuilder printLottoNumbers, int lottoCountIndex) {
        List<Integer> lottoNumbers = lottoDatas.getlottoNumbers(lottoCountIndex);
        for (int lottoLength = 0; lottoLength < lottoNumbers.size(); lottoLength++) {
            printLottoNumbers.append(lottoNumbers.get(lottoLength));
            if (lottoLength != lottoNumbers.size() - 1) {
                printLottoNumbers.append(", ");
            }
        }
        return printLottoNumbers;
    }

}
