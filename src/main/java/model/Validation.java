package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constants.ConstantNumbersManager.*;

public class Validation {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void userInputValue(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int lottoPurchaseNumber(int payment) {
        return payment / LOTTO_PRICE;
    }

    public List<Integer> winningStatics(List<List<Integer>> fullLottoValue) {
        List<Integer> winningStaticsResult = new ArrayList<>(Collections.nCopies(WINNING_LIST_SIZE, INDEX_RESET));

        for (List<Integer> lottoList : fullLottoValue) {
            int matchNumberSaver = 0;
            boolean bonusNumberValidator = comparisonBonusNumber(lottoList);

            for (int number : lottoList) {
                matchNumberSaver = comparisonLotto(number, matchNumberSaver);
            }

            int checkLottoRank = checkLottoRank(matchNumberSaver, bonusNumberValidator);

            if (checkLottoRank != -1) {
                int indexValue = winningStaticsResult.get(checkLottoRank);
                winningStaticsResult.set(checkLottoRank, ++indexValue);
            }
        }
        return winningStaticsResult;
    }

    private int comparisonLotto(int comparingNumber, int matchNumberSaver) {
        if (winningNumbers.contains(comparingNumber)) {
            return ++matchNumberSaver;
        }
        return matchNumberSaver;
    }

    private boolean comparisonBonusNumber(List<Integer> oneLottoList) {
        return oneLottoList.contains(bonusNumber);
    }

    private int checkLottoRank(int matchNumber, boolean bonusNumberValidator) {
        if (matchNumber == 3) {
            return 0;
        }
        if (matchNumber == 4) {
            return 1;
        }
        if (matchNumber == 5 && !bonusNumberValidator) {
            return 2;
        }
        if (matchNumber == 5) {
            return 3;
        }
        if (matchNumber == 6) {
            return 4;
        }
        return -1;
    }

    public double totalReturnCalculate(List<Integer> winningStaticsResult, int payment) {
        double income = 0;

        for (int index = INDEX_RESET; index < winningStaticsResult.size(); index++) {
            income += totalIncomeCalculate(winningStaticsResult.get(index), index);
        }

        double totalReturn = ((income - payment) / payment) * 100.0;
        return 100 + totalReturn;
    }

    private int totalIncomeCalculate(int staticIndexValue, int index) {
        if (index == 0 && staticIndexValue != 0) {
            return FIFTH_REWARD * staticIndexValue;
        }
        if (index == 1 && staticIndexValue != 0) {
            return FORTH_REWARD * staticIndexValue;
        }
        if (index == 2 && staticIndexValue != 0) {
            return THIRD_REWARD * staticIndexValue;
        }
        if (index == 3 && staticIndexValue != 0) {
            return SECOND_REWARD * staticIndexValue;
        }
        if (index == 4 && staticIndexValue != 0) {
            return FIRST_REWARD * staticIndexValue;
        }
        return 0;
    }
}