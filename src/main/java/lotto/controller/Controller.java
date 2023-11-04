package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Message;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.utils.ParseUtils;


public class Controller {

    ParseUtils parseUtils = new ParseUtils();

    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();


    public void run() {
        createUserLottos();
    }


    private void createUserLottos() {
        int lottoAmount = getAmount();
    }

    public int getAmount() {
        System.out.println(Message.AMOUNT_REQUEST_MESSAGE);

        while (true) {
            String inputAmount = Console.readLine();
            try {
                return amountValidationProcess(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            return amountValidationProcess(inputAmount);
        }
    }

    public int amountValidationProcess(String inputAmount) {
        int amount = parseUtils.parseStringToInt(inputAmount);
        validationService.amountValidation(amount);

        return amount;
    }
}
