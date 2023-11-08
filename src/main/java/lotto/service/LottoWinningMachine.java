package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningMachine {
    // 로또 당첨 번호를 처리하는 클래스입니다.
    private static final String winningNumberMessage = "\n당첨 번호를 입력해 주세요.";
    private static final String inputTypeErrorMessage = "[ERROR] 로또 번호는 숫자여야 합니다.";

    public Lotto lottoWinningNumber() {
        while (true) {
            try {
                Lotto lotto = new Lotto(winningNumber());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> winningNumber() {
        System.out.println(winningNumberMessage);
        String input = Console.readLine();

        return splitPlayer(input);
    }

    private List<Integer> splitPlayer(String input) {
        String[] splitInput = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < splitInput.length; i++) {
            validateType(splitInput[i]);
            winningNumbers.add(Integer.parseInt(splitInput[i]));
        }
        return winningNumbers;
    }

    private void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(inputTypeErrorMessage);
        }
    }
}
