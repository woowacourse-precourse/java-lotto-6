package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputView {

    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 500000;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String SEPARATOR = ",";
    private static final String IS_INTEGER_NUMBER = "^[0-9]*$";
    private static final String BUY_MONEY_INFO = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUM_INPUT_INFO = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUM_INPUT_INFO = "보너스 번호를 입력해 주세요.";
    private static final String STRING_TO_INTEGER_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String THOUSAND_ERROR = "[ERROR] 1000단위로 입력해주세요.";
    private static final String PURCHASE_RANGE_OVER = "[ERROR] 구입 범위는 1개에서 50개까지 입니다.";
    private static final String LOTTO_NUMBERS_SIZE_ERROR = "[ERROR] 로또번호를 정확히 입력해주세요.";
    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private int convertedLine;
    private List<Integer> DummyLottos = new ArrayList<>();

    public int userMoneyInput() {

        System.out.println(BUY_MONEY_INFO);
        String inputLine = Console.readLine();

        return moneyInputLineValidate(inputLine);

    }

    public List<Integer> winLottoNumberInput() {

        System.out.println(LOTTO_NUM_INPUT_INFO);
        List<String> inputLine = List.of(Console.readLine().split(SEPARATOR));

        List<Integer> convertedNumber = winLottoNumberConvertInteger(inputLine);
        winLottoNumberValidate(convertedNumber);

        return convertedNumber;
    }

    public int bonusNumberInput() {
        return bonusNumberValidate();
    }


    private int bonusNumberValidate() {
        System.out.println(LOTTO_BONUS_NUM_INPUT_INFO);
        String inputLine = Console.readLine();
        try{
            validStringToInteger(inputLine);
            int convertedLine = Integer.parseInt(inputLine);
            eachNumberValidate(convertedLine);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bonusNumberInput();
        }
        return convertedLine;
    }

    private List<Integer> winLottoNumberConvertInteger(List<String> inputLine) {
        List<Integer> pickInputNumbers = new ArrayList<>();

        try {

            inputLine.forEach(this::validStringToInteger);
            pickInputNumbers = inputLine.stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .distinct()
                    .toList();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            winLottoNumberInput();
        }
        return pickInputNumbers;
    }

    private void winLottoNumberValidate(List<Integer> convertedNumbers) {
        try {
            splitSizeEqualLottoSize(convertedNumbers);
            convertedNumbers.forEach(this::eachNumberValidate);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winLottoNumberInput();
        }
    }

    private void splitSizeEqualLottoSize(List<Integer> inputNumbers) throws IllegalArgumentException {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR);
        }
    }

    private void eachNumberValidate(int eachNumber) throws IllegalArgumentException {
        if (eachNumber < LOTTO_MIN_NUMBER || eachNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }


    private int moneyInputLineValidate(String validateLine) {
        try {
            validStringToInteger(validateLine);
            convertedLine = Integer.parseInt(validateLine);
            thousandValidate(convertedLine);
            purchaseMoneyValidate(convertedLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userMoneyInput();
        }

        return convertedLine;
    }

    private void validStringToInteger(String validateNumber) throws IllegalArgumentException {
        if (!validateNumber.matches(IS_INTEGER_NUMBER)) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
    }

    private void thousandValidate(int validateLine) throws IllegalArgumentException {
        if (validateLine % THOUSAND > ZERO) {
            throw new IllegalArgumentException(THOUSAND_ERROR);
        }
    }

    private void purchaseMoneyValidate(int validateLine) throws IllegalArgumentException {
        if (PURCHASE_MIN > validateLine || validateLine > PURCHASE_MAX) {
            throw new IllegalArgumentException(PURCHASE_RANGE_OVER);
        }
    }


}
