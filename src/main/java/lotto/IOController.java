package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class IOController {
    private static HashSet<Integer> winNumberSet;
    public IOController() {

        winNumberSet = new HashSet<>();

    }

    int inputPrice() {
        System.out.println(InstructionMessage.INPUT_PRICE.getMessageText());
        String inputStringPrice = Console.readLine();
        return isAvailableNumber(inputStringPrice);
    }
    

    public List<Integer> inputWinNumber() {
        System.out.println(InstructionMessage.INPUT_NUMBER.getMessageText());
        String stringInputWinNumber = Console.readLine();

        return isAvailableWinNumber(stringInputWinNumber);
    }

    int isAvailableNumber(String inputStringPrice) {
        int intNumber;

        try {
            intNumber = Integer.parseInt(inputStringPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessageText());
        }
        if(intNumber < 46)
            return intNumber;

        if (intNumber % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT.getMessageText());
        }
        return intNumber;
    }

    private List<Integer> isAvailableWinNumber(String stringInputWinNumber) {
        inputIsNull(stringInputWinNumber);

        makeWinNumberList(stringInputWinNumber);

        List<Integer> winNumberList = makeWinNumberList(stringInputWinNumber);

        isNotSix(winNumberList);
        isDuplicatedNumberOfList(winNumberList);

        return winNumberList;
    }

    private void isNotSix(List<Integer> winNumberList) {
        if (winNumberList.size() != 6)
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_SIX.getMessageText());
    }

    private void isDuplicatedNumberOfList(List<Integer> winNumberList) {

        for (Integer number : winNumberList) {
            isDuplicatedNumber(number);
        }
    }

    private List<Integer> makeWinNumberList(String stringInputWinNumber) {
        List<Integer> winNumberList = new LinkedList<>();

        String[] numbers = stringInputWinNumber.split(",");
        for (String number : numbers) {
            try {
                int intInputNumber=Integer.parseInt(number.trim());
                isOutOfArrange(intInputNumber);
                winNumberList.add(intInputNumber);
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

    public int inputBonusNumber() {
        System.out.println(InstructionMessage.INPUT_BONUS_NUMBER.getMessageText());
        String inputStringBonusNumber = Console.readLine();
        int bonusNumber= isAvailableNumber(inputStringBonusNumber);

        isOutOfArrange(bonusNumber);
        isDuplicatedNumber(bonusNumber);
        return bonusNumber;
    }

    private void isDuplicatedNumber(int number) {
        if (!winNumberSet.add(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_DUPLICATED_NUMBER.getMessageText());
        }
    }

    private void isOutOfArrange(int number) {
        if(number < 1 || number >45)
            throw  new IllegalArgumentException(ExceptionMessage.INPUT_OUT_OF_ARRANGE.getMessageText());
    }
}
