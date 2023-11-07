package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoWinInputView {
    public List<Integer> winNumberInput() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumInput = Console.readLine();
        return getWinNumbers(winNumInput);
    }

    public List<Integer> getWinNumbers(String winNumInput) {
        List<Integer> winNumbers;
        String[] seps = winNumInput.split(",");

        winNumbers = getWinNumbers(seps);
        checkWinNumberSize(winNumbers);
        return winNumbers;
    }

    private void checkWinNumberSize(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_INPUT.getMessage());
        }
    }

    private List<Integer> getWinNumbers(String[] seps) {
        List<Integer> intList = new ArrayList<>();
        for (String sep : seps) {
            int num = getValidWinNumbers(sep);

            checkWinNumberContains(intList, num);
            intList.add(num);
        }
        return intList;
    }

    private void checkWinNumberContains(List<Integer> intList, int num) {
        if (intList.contains(num)) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    private int getValidWinNumbers(String sep) {
        int num;
        try {
            num = Integer.parseInt(sep);
            checkWinNumberRange(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_TYPE.getMessage());
        }
        return num;
    }

    private void checkWinNumberRange(int num) {
        if (num > 45 || num < 0) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
