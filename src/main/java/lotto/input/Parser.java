package lotto.input;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.message.ErrorMessage;
import lotto.util.message.Message;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Constant.LOTTO_PRICE;
import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;
import static lotto.util.Constant.SEPARATE_LETTER;

public class Parser {

    public int parsePurchaseAmount() {
        int purchasePrice;

        while (true) {
            purchasePrice = attemptParseInt();
            if (purchasePrice < DEFAULT_VALUE) {
                ErrorMessage.invalidFormat();
                continue;
            }
            if (validatePurchasePrice(purchasePrice)) {
                Message.newLine();
                break;
            }
            ErrorMessage.invalidPurchasePriceUnit();
        }
        return purchasePrice;
    }

    public List<Integer> parseWinningNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] input = inputNumbers.split(SEPARATE_LETTER);

        for (String numberString : input) {
            int number = attemptParseInt(numberString);
            if (number < DEFAULT_VALUE || !validateLottoNumber(number, numbers)) {
                return new ArrayList<>();
            }
        }
        return numbers;
    }

    public int parseBonusNumber(String inputBonus, Lotto winningLotto) {
        int bonusNumber = attemptParseInt(inputBonus);

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            ErrorMessage.invalidLottoRange();
            return -1;
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            ErrorMessage.duplicatedLottoNumber();
            return -1;
        }
        return bonusNumber;
    }

    private boolean validatePurchasePrice(int purchasePrice) {
        return purchasePrice % LOTTO_PRICE == DEFAULT_VALUE;
    }

    private int attemptParseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int attemptParseInt() {
        return attemptParseInt(Console.readLine());
    }

    private boolean validateLottoNumber(int number, List<Integer> numbers) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER || numbers.contains(number)) {
            ErrorMessage.invalidLottoRange();
            return false;
        }
        numbers.add(number);

        if (numbers.size() > LOTTO_LENGTH) {
            ErrorMessage.invalidLottoLength();
            return false;
        }
        return true;
    }
}
