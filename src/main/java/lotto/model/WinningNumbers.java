package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoRules;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;
    int essentialCommaCount = LottoRules.LOTTO_NUMBER_COUNT.getValue() - 1;
    int startNumber = LottoRules.START_NUMBER.getValue();
    int endNumber = LottoRules.END_NUMBER.getValue();

    public WinningNumbers() {
    }

    public void generateWinningNumbers() {
        String winningNumbersBeforeSplit = askWinningNumbers();
        List<Integer> splitedWinningNumbers = splitWinningNumbersByComma(winningNumbersBeforeSplit);
        validateWinningNumbers(splitedWinningNumbers);
        this.winningNumbers = splitedWinningNumbers;
    }

    public String askWinningNumbers() {
        return Console.readLine();
    }

    public List<Integer> splitWinningNumbersByComma(String winningNumbersBeforeSplit) {
        validateCanSplitWinningNumbersByComma(winningNumbersBeforeSplit);
        List<Integer> splitedWinningNumbers = splitWinningNumbers(winningNumbersBeforeSplit);
        return splitedWinningNumbers;
    }

    public void validateCanSplitWinningNumbersByComma(String winningNumbersBeforeSplit) {
        try {
            IsContainEssentialComma(winningNumbersBeforeSplit);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 콤마를 기준으로 당첨 번호를 입력해 주세요.");
            generateWinningNumbers();
        }
    }

    public void IsContainEssentialComma(String winningNumbersBeforeSplit) {
        String winningNumbersremovedComma = winningNumbersBeforeSplit.replace(",", "");
        int essentialWinningNumbersCount = winningNumbersBeforeSplit.length() - essentialCommaCount;

        if (winningNumbersremovedComma.length() != essentialWinningNumbersCount) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> splitWinningNumbers(String winningNumbersBeforeSplit) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] a = winningNumbersBeforeSplit.split(",");
        for (String character : a) {
            checkIsNumeric(character);
        }
        return winningNumbers;
    }

    public void checkIsNumeric(String character) {
        try {
            Integer.parseInt(character);
        } catch (NumberFormatException e) {
            System.out.println("[Error] 당첨 번호는 숫자로 입력해 주세요.");
            generateWinningNumbers();
        }

    }


    public void validateWinningNumbers(List<Integer> splitedWinningNumbers) throws IllegalArgumentException{
        validateWinningNumbersUnique(splitedWinningNumbers);
        validateWinningNumbersInRange(splitedWinningNumbers);
    }

    public void validateWinningNumbersUnique(List<Integer> splitedWinningNumbers) {

        try{
            checkWinningNumbersUnique(splitedWinningNumbers);
        }catch (IllegalArgumentException e){
            System.out.println("[Errpr] 중복된 당첨 번호가 입력되었습니다.");
            generateWinningNumbers();
        }
    }

    public void checkWinningNumbersUnique(List<Integer> splitedWinningNumbers) {
        List<Integer> distinctWinningNumbers = splitedWinningNumbers
                .stream()
                .distinct()
                .toList();

        if (distinctWinningNumbers.size() != splitedWinningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbersInRange(List<Integer> splitedWinningNumbers) {
        try {
            checkIsInRange(splitedWinningNumbers);
        }catch (IllegalArgumentException e){
            System.out.println("[Error] 당첨 번호가 범위를 벗어났습니다.");
            generateWinningNumbers();
        }
    }

    public void checkIsInRange(List<Integer> splitedWinningNumbers){
        for (int number : splitedWinningNumbers) {
            if (number < startNumber | number > endNumber) {
                throw new IllegalArgumentException();
            }
        }
    }
}