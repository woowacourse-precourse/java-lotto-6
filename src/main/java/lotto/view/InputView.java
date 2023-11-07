package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.constant.Message;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    public int inputPrice() {
        Integer validPrice = null;

        while (!isValidPrice(validPrice)) {
            printNewLine();
            System.out.println(Message.INPUT_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            validPrice = parseValidPrice(inputPrice);
        }
        return validPrice;
    }

    public WinningNumbers inputWinningNumbers() {
        WinningNumbers winningNumbers = null;

        while (!isValidWinningNumbers(winningNumbers)) {
            printNewLine();
            System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
            String inputWinningNumbers = Console.readLine();
            winningNumbers = createWinningNumbers(inputWinningNumbers);
        }

        return winningNumbers;
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber = null;

        while (!isValidBonusNumber(bonusNumber)) {
            printNewLine();
            System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
            String inputBonusNumber = Console.readLine().trim();

            Integer validBonusNumber = parseValidBonusNumber(inputBonusNumber);

            bonusNumber = createBonusNumber(validBonusNumber, winningNumbers);
        }
        return bonusNumber;
    }

    private boolean isValidPrice(Integer validPrice) {
        return !Objects.isNull(validPrice);
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (isNumber(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean isNumber(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_NUMBER.getMessage());
        }
    }

    private boolean isValidWinningNumbers(WinningNumbers validWinningNumbers) {
        return !Objects.isNull(validWinningNumbers);
    }


    private WinningNumbers createWinningNumbers(String inputWinningNumbers) {
        try {
            List<Integer> parseWinningNumbers = parseWinningNumbers(inputWinningNumbers);
            return WinningNumbers.from(parseWinningNumbers);

        } catch (IllegalArgumentException e) {
            return null;

        }
    }

    private List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            System.out.println(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_NUMBERS.getMessage());
        }

    }

    private BonusNumber createBonusNumber(Integer validBonus, WinningNumbers winningNumbers) {
        if (isValidBonus(validBonus)) {
            return BonusNumber.of(validBonus, winningNumbers);
        }
        return null;
    }

    private boolean isValidBonusNumber(BonusNumber validBonusNumber) {
        return !Objects.isNull(validBonusNumber);
    }

    private boolean isValidBonus(Integer validBonus) {
        return !Objects.isNull(validBonus);
    }

    private Integer parseValidBonusNumber(String inputBonusNumber) {
        try {
            if (isBonusNumber(inputBonusNumber)) {
                return Integer.parseInt(inputBonusNumber);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.BONUS_NUMBER_MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean isBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.BONUS_NUMBER_MUST_BE_NUMBER.getMessage());
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}
