package model;

import static constants.ConstantNumbersManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validation {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void userInputValue(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int lottoPurchaseNumber(int payment) {
        return payment / ONE_LOTTO_PRICE;
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
            return FIFTH_RANK;
        }
        if (matchNumber == COINCIDE_FOUR) {
            return FOURTH_RANK;
        }
        if (matchNumber == COINCIDE_FIVE && !bonusNumberValidator) {
            return THIRD_RANK;
        }
        if (matchNumber == COINCIDE_FIVE_BONUS) {
            return SECOND_RANK;
        }
        if (matchNumber == COINCIDE_SIX) {
            return FIRST_RANK;
        }
        return NOT_RANKED;
    }

    public double totalReturnCalculate(List<Integer> winningStaticsResult, int payment) {
        double income = VARIABLE_RESET;

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
        return NOTHING;
    }
}