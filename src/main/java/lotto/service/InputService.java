package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.model.Lotto;
import lotto.view.ExceptionOutputView;
import lotto.view.InputView;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public int getMoney() {
        try {
            int money = validateNumber(inputView.getMoney());
            validateMoney(money);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionOutputView.MONEY_RANGE_ERROR);
        }
    }

    private void validateMoney(int money) {
        if (money % Lotto.PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ExceptionOutputView.MONEY_RANGE_ERROR);
        }
    }

    public Lotto getWinningNumbers() {
        try {
            String winningNumbers = inputView.getWinningNumbers();
            Lotto winningLotto = convertLottoNumbers(winningNumbers);
            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private Lotto convertLottoNumbers(String winningNumbers) {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumbers, ",");
        try {
            return convertToLotto(stringTokenizer);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionOutputView.LOTTO_STRING_FORMAT_ERROR);
        }
    }

    private Lotto convertToLotto(StringTokenizer stringTokenizer) {
        List<Integer> numbers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return new Lotto(numbers);
    }

    public int getBonusNumber() {
        try {
            int bonusNumber = validateNumber(inputView.getBonusNumber());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionOutputView.BONUS_RANGE_ERROR);
        }
    }
}
