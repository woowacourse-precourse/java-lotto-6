package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String getUserInput() {
        String input = Console.readLine();
        return input;
    }

    public List<Integer> askWinningTicketNumbers() {
        List<Integer> winningTicketNumbers = new ArrayList<Integer>();
        String input = Console.readLine().replaceAll("\\p{Z}", "");
        String[] temp = input.split(",");
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
        bonusNumber = Integer.parseInt(input);
        System.out.println();
        return bonusNumber;
    }
}
