package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.List;

public class BonusNumber {
    private final OutputView outputView = new OutputView();

    public int add(WinningNumbers winningNumbers) {
        outputView.inputBonusNumber();
        while (true) {
            try {
                String bonusBall = Console.readLine();
                if (checkValid(bonusBall) && checkDuplicate(winningNumbers, bonusBall)) {
                    return stoi(bonusBall);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다시 입력하세요");
            }
        }
    }

    private boolean checkDuplicate(WinningNumbers winningNumbers, String bonusBall) {
        List<Integer> parts = winningNumbers.getWinningNumbers();

        for (Integer part : parts) {
            if (part == stoi(bonusBall)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private boolean checkValid(String bonusBall) {
        if (Integer.parseInt(bonusBall) > 0 && Integer.parseInt(bonusBall) < 46) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private int stoi(String input) {
        return Integer.parseInt(input);
    }
}
