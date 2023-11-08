package lotto.Domain;

import static lotto.Util.InputValidator.checkCommaDelimiter;
import static lotto.Util.InputValidator.checkDistinctBetweenWinningAndBonusNumber;
import static lotto.Util.InputValidator.checkDistinctNumbers;
import static lotto.Util.InputValidator.checkSixNumber;
import static lotto.Util.InputValidator.isValidRangeNumber;
import static lotto.Util.TypeCaster.convertStringToIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSystem {
    private List<Integer> lottoWinningNumbers;
    private int lottoBonusNumber;

    public void storeLottoWinningNumber(String lottoWinningNumber){
        lottoWinningNumber = lottoWinningNumber.replaceAll("\\s*,\\s*", ",");
        if (isValidRangeNumber(lottoWinningNumber)) {
            checkCommaDelimiter(lottoWinningNumber);
            checkSixNumber(lottoWinningNumber);
            checkDistinctNumbers(lottoWinningNumber);
        }
        this.lottoWinningNumbers = convertStringToIntegerList(lottoWinningNumber);
        Collections.sort(this.lottoWinningNumbers);
    }

    public void storeLottoBonusNumber(String lottoBonusNumber){
        lottoBonusNumber.trim();
        if (isValidRangeNumber(lottoBonusNumber)) {
            checkDistinctBetweenWinningAndBonusNumber(lottoWinningNumbers, lottoBonusNumber);
            this.lottoBonusNumber = Integer.parseInt(lottoBonusNumber);
        }
    }

    public Map<String, Integer> compareLottoNumbers(List<String> purchasedLottos) {
        List<Integer> matchingNumbersCounts = new ArrayList<>();

        for (String purchasedTicket : purchasedLottos) {
            List<Integer> ticketNumbers = convertStringToIntegerList(purchasedTicket);
            int countMatchingNumber = 0;
            boolean bonusNumberflag = false;

            for (int ticketNumber : ticketNumbers) {
                countMatchingNumber = checkContainWinningNumber(this.lottoWinningNumbers, ticketNumber,
                        countMatchingNumber);
                bonusNumberflag = checkContainBonusNumber(this.lottoBonusNumber, ticketNumber);
            }
            countMatchingNumber = checkBonusNumber(countMatchingNumber, bonusNumberflag);
            matchingNumbersCounts.add(countMatchingNumber);
        }
        return makeStatistics(matchingNumbersCounts);
    }

    private Map<String, Integer> makeStatistics(List<Integer> matchingNumbersCounts) {
        Map<String, Integer> statistics = new HashMap<>();
        for (int count : matchingNumbersCounts) {
            if (!statistics.containsKey(Integer.toString(count))) {
                statistics.put(Integer.toString(count), 1);
                continue;
            }
            int value = statistics.get(Integer.toString(count));
            value += 1;
            statistics.put(Integer.toString(count), value);
        }
        return statistics;
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
