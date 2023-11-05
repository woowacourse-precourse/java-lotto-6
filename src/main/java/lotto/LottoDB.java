package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDB {

    // instance
    private final ArrayList<Integer> userLottoNumbers;
    private final ArrayList<String> winningNumbersString;
    private final ArrayList<Integer> winningNumbersInteger;
    private int userLottoCount;

    public LottoDB() {
        userLottoNumbers = new ArrayList<>();
        winningNumbersString = new ArrayList<>();
        winningNumbersInteger = new ArrayList<>();
        userLottoCount = 0;
    }

    public void setUserLottoCount(int userLottoCount) throws IllegalArgumentException {
        this.userLottoCount = userLottoCount / 1000;
    }

    public int getUserLottoCount() {
        return userLottoCount;
    }

    public void storeLottoNumbers(List<Integer> lottoNumbers) {
        userLottoNumbers.addAll(lottoNumbers);
    }

    public void clearWinningNumbers() {
        winningNumbersString.clear();
        winningNumbersInteger.clear();
    }

    public void getWinningNumbers() {
        String input = Console.readLine();
        String[] inputList = input.split(",");
        winningNumbersString.addAll(Arrays.asList(inputList));
    }

    public void convertStringListToIntegerList() throws IllegalArgumentException {
        for (String stringNumbers : winningNumbersString) {
            int integerNumber = convertStringToInteger(stringNumbers);
            checkWinningNumbersInRange(integerNumber);
            winningNumbersInteger.add(integerNumber);
        }
    }

    public Integer convertStringToInteger(String stringInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(stringInput);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 정수가 아닙니다.");
        }
    }

    public void checkWinningNumbersInRange(int checkNumber) throws IllegalArgumentException {
        if (checkNumber < 1 || checkNumber > 45) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1-45사이의 값이 아닙니다.");
        }
    }

    public Lotto getLottoInstance() throws IllegalArgumentException {
        return new Lotto(winningNumbersInteger);

    }

}
