package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

public class User {

    private int numberOfLottoTickets;

    public String input() {
        return Console.readLine().trim();
    }

    // 로또 구입 금액 입력 및 발행 횟수 확인
    public int countLottoTicketIssues(String input) {
        checkIsInputNumber(input);
        int inputNumber = Integer.parseInt(input);
        inputMoneyValidator(inputNumber);
        numberOfLottoTickets = inputNumber / 1000;
        return numberOfLottoTickets;
    }

    private void checkIsInputNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            Calculator calculator = new Calculator();
            calculator.requestPurchaseAmount();
        }

    }


    public void inputMoneyValidator(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력하세요.");
        }
    }

}
