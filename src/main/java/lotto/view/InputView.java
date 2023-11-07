package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Parser;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int getPurchaseAmount() {
        String amount = "";
        try {
            System.out.println("구입금액을 입력해 주세요.");
            amount = readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
        System.out.println();
        return Integer.parseInt(amount);
    }

    public Lotto getWinningNumbers() {
        List<Integer> winningNumbers;
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = readLine();
        winningNumbers = Parser.parseNumbers(winningNumbersInput);
        try {
            System.out.println();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }
}