package lotto.Domain;

import static lotto.Validator.InputValidator.checkCommaDelimiter;
import static lotto.Validator.InputValidator.checkDistinctBetweenWinningAndBonusNumber;
import static lotto.Validator.InputValidator.checkDistinctNumbers;
import static lotto.Validator.InputValidator.checkSixNumber;
import static lotto.Validator.InputValidator.isEmpty;
import static lotto.Validator.InputValidator.isNumber;
import static lotto.Validator.InputValidator.isValidRangeNumber;
import static lotto.Validator.TypeCaster.convertStringToIntegerList;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {
    private List<Integer> lottoWinningNumbers;
    private int lottoBonusNumber;

    public LottoSystem(String lottoWinningNumber, String lottoBonusNumber) {

        if (isEmpty(lottoWinningNumber)) {
            lottoWinningNumber = lottoWinningNumber.replaceAll("\\s*,\\s*", ",");
            if (isNumber(lottoWinningNumber) && isValidRangeNumber(lottoWinningNumber)) {
                checkCommaDelimiter(lottoWinningNumber);
                checkSixNumber(lottoWinningNumber);
                checkDistinctNumbers(lottoWinningNumber);
            }
            this.lottoWinningNumbers = convertStringToIntegerList(lottoWinningNumber);
        }

        if (isEmpty(lottoBonusNumber)) {
            lottoBonusNumber = lottoBonusNumber.replaceAll("\\s*,\\s*", ",");
            if (isNumber(lottoBonusNumber) && isValidRangeNumber(lottoBonusNumber)) {
                checkDistinctBetweenWinningAndBonusNumber(lottoWinningNumber, lottoBonusNumber);
                this.lottoBonusNumber = Integer.parseInt(lottoBonusNumber);
            }
        }
    }

    public void print() {
        for (int num : this.lottoWinningNumbers) {
            System.out.print(num + " ");
        }
        System.out.println(this.lottoBonusNumber);
    }

    public List<Integer> compareLottoNumbers(List<String> purchasedLottos) {
        List<Integer> matchingNumbersCounts = new ArrayList<>();

        for (String purchasedTicket : purchasedLottos) {
            List<Integer> ticketNumbers = convertStringToIntegerList(purchasedTicket);
            int countMatchingNumber = 0;
            boolean bonusNumberflag = false;

            for (int ticketNumber : ticketNumbers) {
                countMatchingNumber = checkContainWinningNumber(this.lottoWinningNumbers, ticketNumber, countMatchingNumber);
                bonusNumberflag = checkContainBonusNumber(this.lottoBonusNumber, ticketNumber);
            }
            countMatchingNumber = checkBonusNumber(countMatchingNumber, bonusNumberflag);
            matchingNumbersCounts.add(countMatchingNumber);
        }
        return matchingNumbersCounts;
    }

    private int checkBonusNumber(int countMatchingNumber, boolean bonusNumberflag) {
        if (countMatchingNumber == 6 || (countMatchingNumber == 5 && bonusNumberflag == true)) {
            return ++countMatchingNumber;
        }
        return countMatchingNumber;
    }

    private int checkContainWinningNumber(List<Integer> lottoWinningNumbers, int ticketNumber,
                                          int countMatchingNumber) {
        if (lottoWinningNumbers.contains(ticketNumber)) {
            return ++countMatchingNumber;
        }
        return countMatchingNumber;
    }

    private boolean checkContainBonusNumber(int bonusNumber, int ticketNumber) {
        if (bonusNumber == ticketNumber) {
            return true;
        }
        return false;
    }
}
