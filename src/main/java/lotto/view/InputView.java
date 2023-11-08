package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Constant.*;
import static lotto.utils.Constant.ErrorMessage.*;
import static lotto.utils.Constant.InputMessage.*;

public class InputView {
    public int getPurchasePrice() {
        System.out.println(MSG_PURCHASE_PRICE);
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
            validPrice(money);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PURCHASE_PRICE_NUM);
            getPurchasePrice();
        }
        return money;
    }

    private void validPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.println(ERROR_PURCHASE_PRICE);
            getPurchasePrice();
        }
    }

    public WinningLotto getWinningNumbers() {
        System.out.println();
        System.out.println(MSG_WINNING_NUMS);
        String input = Console.readLine();
        String[] numberStrings = input.split(COMMA);
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString);
                validNumber(number);
                numbers.add(number);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_WINNINGNUM_NUM);
            getWinningNumbers();
        }
        validWinningNumber(numbers);
        return new WinningLotto(numbers);
    }

    private void validWinningNumber(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            System.out.println(ERROR_WINNINGNUM_COUNT);
            getWinningNumbers();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != COUNT_OF_LOTTO) {
            System.out.println(ERROR_WINNINGNUM_DUPLICATION);
            getWinningNumbers();
        }
    }

    private void validNumber(int number) {
        if (number < SD_RANDOM_NUMBER_MIN || number > SD_RANDOM_NUMBER_MAX) {
            System.out.println(ERROR_WINNINGNUM_RANGE);
        }
    }

    public void getBonusNumber(WinningLotto winningLotto) {
        System.out.println();
        System.out.println(MSG_BONUS_NUMS);
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            validNumber(bonusNumber);
            validDuplicationNumber(bonusNumber, winningLotto);
            winningLotto.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_BONUSNUM_NUM);
            getPurchasePrice();
        }
    }

    private void validDuplicationNumber(int bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            System.out.println(ERROR_BONUSNUM_DUPLICATION);
            getBonusNumber(winningLotto);
        }
    }
}
