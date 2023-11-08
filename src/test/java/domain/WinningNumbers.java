package domain;

import camp.nextstep.edu.missionutils.Console;
import enums.LottoError;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {
        this.winningNumbers = new ArrayList<>();
    }

    public void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            String winningNumbersInput = Console.readLine();

            try {
                this.winningNumbers = parseWinningNumbersInput(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            String bonusNumberInput = Console.readLine();

            try {
                this.bonusNumber = parseBonusNumberInput(bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> parseWinningNumbersInput(String winningNumbersInput) {
        StringTokenizer token = new StringTokenizer(winningNumbersInput, ",");
        List<Integer> winNumber = new ArrayList<>();
        if (token.countTokens() != 6)
            throw new IllegalArgumentException(LottoError.NUMBER_COUNT_ERROR.getMessage());
        for (int i = 0; i < 6; i++) {
            inputLottoNumbersCheck(token, winNumber);
        }
        return winNumber;
    }

    private static void inputLottoNumbersCheck(StringTokenizer token, List<Integer> winNumber) {
        try {
            String inputToken = token.nextToken();
            if (inputToken.equals(" "))
                throw new IllegalArgumentException(LottoError.LOTTO_BLANK_ERROR.getMessage());
            int num = Integer.parseInt(inputToken);
            if (num < 1 || num > 45)
                throw new IllegalArgumentException(LottoError.NUMBER_RANGE_ERROR.getMessage());
            if(winNumber.contains(num))
                throw new IllegalArgumentException(LottoError.NUMBER_DUPLICATE_ERROR.getMessage());
            winNumber.add(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public int parseBonusNumberInput(String bonusNumberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.NUMBER_FORMAT_ERROR.getMessage());
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(LottoError.NUMBER_RANGE_ERROR.getMessage());
        }
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoError.NUMBER_DUPLICATE_ERROR.getMessage());
        }
        return bonusNumber;
    }
}
