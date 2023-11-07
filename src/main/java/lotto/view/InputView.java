package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validation.ValidInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputView {

    private String paymentInput;
    private String bonusNumberInput;
    private ValidInput validInput;
    private List<Integer> numbersForValidation;
    private String winningTicketNumbersInput;
    private List<String> tmp;
    private int numberForValidation;
    private Lotto lotto;

    public InputView() {
        validInput = new ValidInput();
    }

    private String getUserInput() {
        String input = Console.readLine();
        return input;
    }

    public String askPayment() {
        paymentInput = getUserInput();
        try {
            validInput.validPayment(paymentInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askPayment();
        }
        return paymentInput;
    }

    public String askBonusNumber() {
        bonusNumberInput = getUserInput();
        try {
            validInput.validBonusNumber(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askBonusNumber();
        }
        return bonusNumberInput;
    }

    public List<Integer> askWinningTicket() {
        numbersForValidation = new ArrayList<Integer>();
        winningTicketNumbersInput = Console.readLine().replaceAll("\\p{Z}", "");
        tmp = Arrays.asList(winningTicketNumbersInput.split(","));
        // lotto 클래스는 List<Integer> 타입을 인자값으로 갖기 때문에 리스트의 요소들이 모두 숫자인지를 검사한다.
        for (String x : tmp) {
            try {
                validInput.validNumber(x);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                askWinningTicket();
                break;
            }
            numberForValidation = Integer.parseInt(x);
            numbersForValidation.add(numberForValidation);
        }
        // lotto 클래스를 생성하여 유효한 로또 번호인지를 검사한다.
        try {
            lotto = new Lotto(numbersForValidation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askWinningTicket();
        }
        return numbersForValidation;
    }

}
