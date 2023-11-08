package lotto.util;

import static lotto.config.LottoConfig.INPUT_SEPARATE;
import static lotto.config.LottoConfig.LOTTO_COUNT;
import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.LottoConfig.MAX_CHAR;
import static lotto.config.LottoConfig.MIN_CHAR;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.string.ErrorMessage.AMOUNT_CHARACTER_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.AMOUNT_NULL_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.AMOUNT_UNIT_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.BONUSNUMBER_CHARACTER_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.BONUSNUMBER_DOUBLECHECK_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.BONUSNUMBER_RANGE_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.WININGNUMBER_CHARACTER_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.WININGNUMBER_DOUBLECHECK_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.WININGNUMBER_NUMBERSIZE_ERROR_MESSAGE;
import static lotto.string.ErrorMessage.WININGNUMBER_RANGE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WrongChecker {
    public boolean checkWrongAmount(String amountInput) {
        try {
            checkAmountNull(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(AMOUNT_NULL_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkAmountCharacter(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(AMOUNT_CHARACTER_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkAmountUnit(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public void checkAmountNull(String amountInput) {
        if (amountInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkAmountCharacter(String amountInput) {
        for (int i = 0; i < amountInput.length(); i++) {
            checkCharacter(amountInput.charAt(i));
        }
    }

    public void checkAmountUnit(String amountInput) {
        int amount = Integer.parseInt(amountInput);
        if (!(amount % LOTTO_PRICE.getNum() == 0)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkWrongWiningNumberInput(String winingNumberInput) {
        try {
            checkWiningNumberCharacter(winingNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(WININGNUMBER_CHARACTER_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkWiningNumberRange(winingNumberInput);
            checkWiningNumberMinus(winingNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(WININGNUMBER_RANGE_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkWiningNumberSize(winingNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(WININGNUMBER_NUMBERSIZE_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkDoubleWiningNumber(winingNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(WININGNUMBER_DOUBLECHECK_ERROR_MESSAGE.getMessage());
            return true;
        }

        return false;
    }

    public void checkWiningNumberRange(String winingNumberInput) {
        ArrayList<String> split;
        split = new ArrayList<>(Arrays.asList(winingNumberInput.split(INPUT_SEPARATE.getSeparate())));
        for (String s : split) {
            int i = Integer.parseInt(s);
            if (!(i >= MIN_LOTTO_NUMBER.getNum() && i <= MAX_LOTTO_NUMBER.getNum())) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkWiningNumberCharacter(String winingNumberInput) {
        ArrayList<String> split;
        split = new ArrayList<>(Arrays.asList(winingNumberInput.split(INPUT_SEPARATE.getSeparate())));
        for (String s : split) {
            for (int j = 0; j < s.length(); j++) {
                checkCharacter(s.charAt(j));
            }
        }
    }

    public void checkWiningNumberMinus(String winingNumberInput) {
        if (winingNumberInput.contains("-")) {
            throw new IllegalArgumentException();
        }
    }

    public void checkWiningNumberSize(String winingNumberInput) {
        ArrayList<String> split;
        split = new ArrayList<>(Arrays.asList(winingNumberInput.split(INPUT_SEPARATE.getSeparate())));
        if (!(split.size() == LOTTO_COUNT.getNum())) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDoubleWiningNumber(String winingNumberInput) {
        ArrayList<String> split;
        split = new ArrayList<>(Arrays.asList(winingNumberInput.split(INPUT_SEPARATE.getSeparate())));
        ArrayList<Integer> temp = new ArrayList<>();
        for (String s : split) {
            temp.add(Integer.parseInt(s));
        }
        if (temp.size() != temp.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkWrongBonusNumber(List<Integer> winingNumbers, String bonusNumberInput) {
        try {
            checkBonusNumberCharacter(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(BONUSNUMBER_CHARACTER_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkBonusNumberRange(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(BONUSNUMBER_RANGE_ERROR_MESSAGE.getMessage());
            return true;
        }
        try {
            checkDoubleBonusNumber(winingNumbers, bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(BONUSNUMBER_DOUBLECHECK_ERROR_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public void checkBonusNumberCharacter(String bonusNumberInput) {
        for (int i = 0; i < bonusNumberInput.length(); i++) {
            checkCharacter(bonusNumberInput.charAt(i));
        }
    }

    public void checkBonusNumberRange(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (!(bonusNumber >= MIN_LOTTO_NUMBER.getNum() && bonusNumber <= MAX_LOTTO_NUMBER.getNum())) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDoubleBonusNumber(List<Integer> winingNumbers, String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        for (int i : winingNumbers) {
            if (bonusNumber == i) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkCharacter(char target) {
        if (!(target >= MIN_CHAR.getValue() && target <= MAX_CHAR.getValue())) {
            throw new IllegalArgumentException();
        }
    }
}