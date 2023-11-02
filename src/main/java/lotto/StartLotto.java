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

    private void inputPurchasePrice() {
        printMessageForInputPurchasePrice();

        String purchasePrice = Console.readLine();

        this.purchasePrice = changeStringToInteger(purchasePrice);
        checkIs1000wonUnit();
    }

    private void printMessageForInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void checkIs1000wonUnit() {
        if(this.purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void inputWinningNumbers() {
        printMessageForInputWinningNumbers();
        String winningNumbers = Console.readLine();

        String[] splitWinningNumbers = splitInputString(winningNumbers);
        changeStringToInteger(splitWinningNumbers);
    }

    private void printMessageForInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String[] splitInputString(String winningNumbers) {
        winningNumbers = winningNumbers.replaceAll(" ", "");
        return winningNumbers.split(",", 0);
    }

    private void changeStringToInteger(String[] inputString) {
        for(int i = 0; i < inputString.length; i++) {
            int winningNumber = changeStringToInteger(inputString[i]);
            checkWinningNumberInRange(winningNumber);
            checkDuplicatedNumber(winningNumber);
            this.winningNumbers.add(winningNumber);
        }
    }

    private void checkWinningNumberInRange(int winningNumber) {
        if(winningNumber < 1 || 45 < winningNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(int winningNumber) {
        for(int i = 0; i < this.winningNumbers.size(); i++) {
            if(winningNumber == this.winningNumbers.get(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
