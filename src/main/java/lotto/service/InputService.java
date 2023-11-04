package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.utils.ParseUtils;

public class InputService {

    ParseUtils parseUtils = new ParseUtils();
    ValidationService validationService = new ValidationService();
    public int inputAmount() {
        System.out.println(Message.AMOUNT_REQUEST_MESSAGE);

        while (true) {
            String inputAmount = Console.readLine();
            Integer amount = amountValidationProcess(inputAmount);

            if (amount != null) {
                return amount;
            }
        }
    }

    private Integer amountValidationProcess(String inputAmount) {
        try {
            int amount = parseUtils.parseStringToInt(inputAmount);
            validationService.amountValidation(amount);

            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.AMOUNT_FORMAT.getMessage());
        }

        return null;
    }


}
