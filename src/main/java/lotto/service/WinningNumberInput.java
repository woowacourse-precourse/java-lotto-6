package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;

public class WinningNumberInput {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private Lotto lotto;

    public WinningNumberInput(Lotto lotto){
        this.lotto = lotto;
    }

    public WinningNumberInput(){
        super();
    }

    public Map<Lotto, Integer> inputWinningNumbers() {
        lotto = inputNumbers();
        int bonusNumber = inputBonusNumbers();
        return Map.of(lotto, bonusNumber);
    }

    private Lotto inputNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                return validateNumber(userInput.split(","));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int inputBonusNumbers() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                int bonusNumber = transString(userInput);
                isBetween1And45(bonusNumber);
                containCheck(bonusNumber);
                return bonusNumber;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Lotto validateNumber(String[] numbers) {
        return new Lotto(isNumber(numbers));
    }

    private List<Integer> isNumber(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : numbers) {
            winningNumbers.add(transString(s));
        }
        for (int n : winningNumbers) {
            isBetween1And45(n);
        }

        return winningNumbers;
    }

    private void containCheck(int number) {
        if (lotto.getNumbers().contains(number)) {
            throw new CustomException(ErrorCode.DUPLICATE_WINNING_NUMBER);
        }
    }

    private int transString(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new CustomException(ErrorCode.PARS_EERROR_TYPE);
        }
    }

    private void isBetween1And45(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new CustomException(ErrorCode.OUT_OF_RANGE);
        }
    }
}
