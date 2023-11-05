package lotto.view;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int askPayment() {
        String input = readLine();
        int payment = Integer.parseInt(input);
        return payment;
    }

    public List<Integer> askWinningTicketNumbers() {
        List<Integer> winningTicketNumbers = new ArrayList<Integer>();
        String input = readLine();
        String[] temp = input.split(",");
        //입력 유효성 검사
        for(String x : temp) {
            int tmp = Integer.parseInt(x);
            winningTicketNumbers.add(tmp);
        }

        return winningTicketNumbers;
    }

    public int askBonusNumber() {
        String input = readLine();
        //입력 유효성 검사
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }
}
