package lotto;

import camp.nextstep.edu.missionutils.Console;


public class IOController {
    private int price;

    public IOController() {
        inputPrice();

    }

    private void inputPrice() {
        System.out.println(InstructionMessage.INSTRUCTION_INPUT_PRICE.getMessageText());
        String inputStringPrice = Console.readLine();
        isAvailablePrice(inputStringPrice);
    }

    private void isAvailablePrice(String inputStringPrice) {
        int intPrice;

        try {
            intPrice = Integer.parseInt(inputStringPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessageText());
        }

        if (intPrice % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT.getMessageText());
        }
    }


}
