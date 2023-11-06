package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private boolean validation = true;
    private String input;
    public int askPayment() {
        boolean isValidatePayment = true;
        while(isValidatePayment) {
            input = Console.readLine();
            isValidatePayment = validatePayment(input);
        }
        int payment = Integer.parseInt(input);
        System.out.println();
        return payment;
    }

    public List<Integer> askWinningTicketNumbers() {
        List<Integer> winningTicketNumbers = new ArrayList<Integer>();
        String input = Console.readLine().replaceAll("\\p{Z}", "");
        String[] temp = input.split(",");
        validateWinningTicketNumbers(temp);
        List<Integer> tmp = new ArrayList<Integer>();
        for (String x : temp) {
            int i = Integer.parseInt(x);
            tmp.add(i);
        }
        Lotto lotto = new Lotto(tmp);
        winningTicketNumbers = lotto.getNumbers();
        System.out.println();
        return winningTicketNumbers;
    }

    public int askBonusNumber() {
        int bonusNumber = 0;
        String input = readLine();
        validateBonusNumber(input);
        bonusNumber = Integer.parseInt(input);
        System.out.println();
        return bonusNumber;
    }

    private boolean validateNumber(String input) {
        boolean isNumber = true;
        try {
            if(!input.matches("\\d+"))
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        } catch (IllegalArgumentException e) {
            isNumber = false;
            System.out.println(e.getMessage());
        }
        return isNumber;
    }

    private boolean validateMultipleOf1000(String input) {
        boolean isMultipleOf1000 = true;
        int number = Integer.parseInt(input);
        try {
            if (!((number % 1000) == 0))
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위로 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            isMultipleOf1000 = false;
            System.out.println(e.getMessage());
        }
        return isMultipleOf1000;
    }

    private boolean validatePayment(String input) {
        boolean isValidatePayment = true;
        if(validateNumber(input)) {
            isValidatePayment = validateMultipleOf1000(input);
        }
        return isValidatePayment;
    }

    private void validateBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int number = Integer.parseInt(input);
        if (number > 45 || number < 1)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateWinningTicketNumbers(String[] temp) {
        for (String x : temp) {
            try {
                Integer.parseInt(x);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
    }
}
