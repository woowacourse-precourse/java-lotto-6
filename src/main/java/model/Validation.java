package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constants.ConstantNumbersManager.*;


public class Validation {
    private final List<Integer> WINNING_NUMBERS;
    private final int BONUS_NUMBER;

    public Validation(List<Integer> winningNumbers, int bonusNumber) {
        this.WINNING_NUMBERS = new ArrayList<>(winningNumbers);
        this.BONUS_NUMBER = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {//타 클래스에 WINNING_NUMBERS 제공 위한 메서드
        return WINNING_NUMBERS;
    }

    public int getBonusNumber() {//타 클래스에 BONUS_NUMBER 제공 위한 메서드
        return BONUS_NUMBER;
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
}
