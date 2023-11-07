package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class IOController {
    public IOController() {

    }

    int inputPrice() {
        System.out.println(InstructionMessage.INPUT_PRICE.getMessageText());
        String inputStringPrice = Console.readLine();
        return isAvailablePrice(inputStringPrice);
    }

    public List<Integer> inputWinNumber() {
        System.out.println(InstructionMessage.INPUT_NUMBER.getMessageText());
        String stringInputWinNumber = Console.readLine();

        return isAvailableWinNumber(stringInputWinNumber);
    }

    int isAvailablePrice(String inputStringPrice) {
        int intPrice;

        try {
            intPrice = Integer.parseInt(inputStringPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessageText());
        }

        if (intPrice % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT.getMessageText());
        }
        return intPrice;
    }

    private List<Integer> isAvailableWinNumber(String stringInputWinNumber) {
        inputIsNull(stringInputWinNumber);
        makeWinNumberList(stringInputWinNumber);

        List<Integer> winNumberList = makeWinNumberList(stringInputWinNumber);

        isNotSix(winNumberList);
        isDuplicatedNumber(winNumberList);

        return winNumberList;
    }

    private void isNotSix(List<Integer> winNumberList) {
        if (winNumberList.size() != 6)
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_SIX.getMessageText());
    }

    private void isDuplicatedNumber(List<Integer> winNumberList) {
        Set<Integer> checkNumer = new HashSet<>();
        for (Integer number : winNumberList) {
            if (!checkNumer.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_DUPLICATED_NUMBER.getMessageText());
            }
        }
    }

    private List<Integer> makeWinNumberList(String stringInputWinNumber) {
        List<Integer> winNumberList = new LinkedList<>();

        String[] numbers = stringInputWinNumber.split(",");
        for (String number : numbers) {
            try {
                winNumberList.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessageText());
            }
        }

        return winNumberList;
    }

    private void inputIsNull(String stringInputWinNumber) {
        if (stringInputWinNumber == null || stringInputWinNumber.trim().isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL.getMessageText());

    }

}
