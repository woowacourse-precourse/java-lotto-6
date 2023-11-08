package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.NumbersFromUser;
import lotto.model.LottoPurchasingAmount;
import lotto.utils.ErrorMessage;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputController {
    public LottoPurchasingAmount getLottoPurchasingAmountFromUser() {
        OutputView.askLottoPurchasingAmount();
        try {
            return new LottoPurchasingAmount(Console.readLine());
        } catch (IllegalArgumentException e) {
            return getLottoPurchasingAmountFromUser();
        }
    }

    public NumbersFromUser getNumbersFromUser() {
        Lotto lotto = getWinningNumberFromUser();
        int bonusNumber = getBonusNumberFromUser(lotto);

        return new NumbersFromUser(lotto, bonusNumber);
    }

    public Lotto getWinningNumberFromUser() {
        OutputView.askLottoNumbers();
        try {
            List<String> splitNumbers = validateLength(Console.readLine());
            return new Lotto(convertToIntList(splitNumbers));
        } catch (IllegalArgumentException e) {
            return getWinningNumberFromUser();
        }
    }

    public List<String> validateLength(String lottoNumbersFromUser) {
        List<String> splitNumbersFromUser = Arrays.asList(lottoNumbersFromUser.split(","));

        if (splitNumbersFromUser.size() != 6) {
            ErrorMessage.lottoNumberLengthException();
            throw new IllegalArgumentException();
        }

        return splitNumbersFromUser;
    }

    public List<Integer> convertToIntList(List<String> splitNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            int number = validateNumber(splitNumber);
            validateNumberRange(number);
            validateNumberDuplication(number, numbers);
            numbers.add(number);
        }

        return numbers;
    }

    public int validateNumber(String splitNumber) {
        try {
            return parseInt(splitNumber);
        } catch (NumberFormatException e) {
            ErrorMessage.numberException();
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            ErrorMessage.lottoNumberRangeException();
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberDuplication(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            ErrorMessage.lottoNUmberDuplicationException();
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumberFromUser(Lotto lotto) {
        OutputView.askBonusNumber();

        try {
            int bonusNumber = validateNumber(Console.readLine());
            validateNumberRange(bonusNumber);
            validateNumberDuplication(bonusNumber, lotto.getLottoNumbers());

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            return getBonusNumberFromUser(lotto);
        }
    }
}
