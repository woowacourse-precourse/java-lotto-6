package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constants.ConstantNumbersManager.*;


public class Validation {
    private List<Integer> WINNING_NUMBERS;
    private int BONUS_NUMBER;

    public void inputFinalValue(List<Integer> WINNING_NUMBERS, int BONUS_NUMBER) {
        this.WINNING_NUMBERS = WINNING_NUMBERS;
        this.BONUS_NUMBER = BONUS_NUMBER;
    }

    public int lottoPurchaseNumber(int payment) {
        return payment / LOTTO_PRICE;
    }


    public List<Integer> winningStatics(List<List<Integer>> fullLottoValue) {
        List<Integer> winningStaticsResult = new ArrayList<>(Collections.nCopies(WINNING_LIST_SIZE, INDEX_RESET)); //list 0으로 초기화
        for(int outerIndex = INDEX_RESET; outerIndex < fullLottoValue.size(); outerIndex++) {
            int matchNumberSaver = 0;
            boolean bonusNumberValidator = comparisonBonusNumber(fullLottoValue.get(outerIndex));
            for(int innerIndex = INDEX_RESET; innerIndex < LOTTO_SIZE; innerIndex++) {
               matchNumberSaver = comparisonLotto(fullLottoValue.get(outerIndex).get(innerIndex), matchNumberSaver);
            }
            int checkLottoRank = checkLottoRank(matchNumberSaver, bonusNumberValidator);
            if(checkLottoRank == -1) {
                continue;
            }
            int indexValue = winningStaticsResult.get(checkLottoRank);
            winningStaticsResult.set(checkLottoRank, ++indexValue);
        }
        return winningStaticsResult;
    }

    private int comparisonLotto(int comparingNumber, int matchNumberSaver) {
        if(WINNING_NUMBERS.contains(comparingNumber)){
            return ++matchNumberSaver;
        }
        return matchNumberSaver;
    }
    private Boolean comparisonBonusNumber(List<Integer> oneLottoList) {
        return oneLottoList.contains(BONUS_NUMBER);
    }

    private int checkLottoRank(int matchNumber, Boolean bonusNumberValidator) {
        if(matchNumber == 3) {
            return 0;
        }
        if(matchNumber == 4) {
            return 1;
        }
        if(matchNumber == 5 && !bonusNumberValidator) {
            return 2;
        }
        if(matchNumber == 5) {
            return 3;
        }
        if(matchNumber == 6) {
            return 4;
        }
        return -1;
    }

    public double totalReturnCalculate(List<Integer> winningStaticsResult, int payment) {
        double totalReturn = 0;
        double income = 0;
        for(int index = INDEX_RESET; index < winningStaticsResult.size(); index++) {
            income += totalIncomeCalculate(winningStaticsResult.get(index), index);
        }
        //수익률 = ((투자 수익 - 투자 비용) / 투자 비용) * 100
        totalReturn = 100 + ((income - payment) / payment) * 100.0;
        return totalReturn;
    }
    private int totalIncomeCalculate(int staticIndexValue, int index) {
        if(index == 0 && staticIndexValue != 0) {
            return FIFTH_REWARD * staticIndexValue;
        }
        if(index == 1 && staticIndexValue != 0) {
            return FORTH_REWARD * staticIndexValue;
        }
        if(index == 2 && staticIndexValue != 0) {
            return THIRD_REWARD * staticIndexValue;
        }
        if(index == 3 && staticIndexValue != 0) {
            return SECOND_REWARD * staticIndexValue;
        }
        if(index == 4 && staticIndexValue != 0) {
            return FIRST_REWARD * staticIndexValue;
        }
        return 0;
    }

}
