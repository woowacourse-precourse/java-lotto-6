package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int askPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        validatePayment(input);
        int payment = Integer.parseInt(input);
        return payment;
    }

    public List<Integer> askWinningTicketNumbers() {
        List<Integer> winningTicketNumbers = new ArrayList<Integer>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine().replaceAll("\\p{Z}", "");
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
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        validateBonusNumber(input);
        bonusNumber = Integer.parseInt(input);
        System.out.println();
        return bonusNumber;
    }

    private void validatePayment(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
        int number = Integer.parseInt(input);
        if (!((number % 1000) == 0))
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위로 입력해야 합니다.");
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
