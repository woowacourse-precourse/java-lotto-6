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
            int matchNumberSaver = VARIABLE_RESET;
            boolean bonusNumberValidator = comparisonBonusNumber(lottoList);

            for (int number : lottoList) {
                matchNumberSaver = comparisonLotto(number, matchNumberSaver);
            }

            int checkLottoRank = checkLottoRank(matchNumberSaver, bonusNumberValidator);

            if (checkLottoRank != NOT_RANKED) {
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
        if (matchNumber == COINCIDE_THREE) {
            return 0;
        }
        if (matchNumber == COINCIDE_FOUR) {
            return 1;
        }
        if (matchNumber == COINCIDE_FIVE && !bonusNumberValidator) {
            return 2;
        }
        if (matchNumber == COINCIDE_FIVE_BONUS) {
            return 3;
        }
        if (matchNumber == COINCIDE_SIX) {
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
        if (index == FIFTH_RANK && staticIndexValue != NOTHING) {
            return FIFTH_REWARD * staticIndexValue;
        }
        if (index == FOURTH_RANK && staticIndexValue != NOTHING) {
            return FORTH_REWARD * staticIndexValue;
        }
        if (index == THIRD_RANK && staticIndexValue != NOTHING) {
            return THIRD_REWARD * staticIndexValue;
        }
        if (index == SECOND_RANK && staticIndexValue != NOTHING) {
            return SECOND_REWARD * staticIndexValue;
        }
        if (index == FIRST_RANK && staticIndexValue != NOTHING) {
            return FIRST_REWARD * staticIndexValue;
        }
        return 0;
    }
}