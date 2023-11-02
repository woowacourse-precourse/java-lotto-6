package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class StartLotto {
    private List<Lotto> lottoList;
    private int purchasePrice;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public StartLotto() {
        this.purchasePrice = 0;
        this.bonusNumber = 0;
        this.winningNumbers = new ArrayList<Integer>();
    }

    private int changeStringToInteger(String inputString) {
        try{
            return Integer.parseInt(inputString);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private List<Integer> changeStringToInteger(String[] inputString) {
        List<Integer> retVal = new ArrayList<Integer>();

        for(String s: inputString) {
            int number = changeStringToInteger(s);
            checkNumberInRange(number);
            checkDuplicatedNumber(number, retVal);
            retVal.add(number);
        }

        return retVal;
    }

    private void checkNumberInRange(int number) {
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(int number, List<Integer> numberList) {
        for(Integer oneNumber: numberList) {
            if(number == oneNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void inputPurchasePrice() {
        printMessageForInputPurchasePrice();

        String purchasePrice = Console.readLine();

        int purchaseNumber = changeStringToInteger(purchasePrice);
        checkIs1000wonUnit(purchaseNumber);
        this.purchasePrice = purchaseNumber;
    }

    private void printMessageForInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void checkIs1000wonUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void inputWinningNumbers() {
        printMessageForInputWinningNumbers();
        String winningNumbers = Console.readLine();

        String[] splitWinningNumbers = splitInputString(winningNumbers);
        this.winningNumbers = changeStringToInteger(splitWinningNumbers);
    }

    private void printMessageForInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String[] splitInputString(String winningNumbers) {
        winningNumbers = winningNumbers.replaceAll(" ", "");
        return winningNumbers.split(",", 0);
    }

    private void inputBonusNumber() {
        printMessageForInputBonusNumber();
        String bonusNumberString = Console.readLine();

        int bonusNumber = changeStringToInteger(bonusNumberString);
        checkNumberInRange(bonusNumber);
        checkDuplicatedNumber(bonusNumber, this.winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void printMessageForInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
    }
}
