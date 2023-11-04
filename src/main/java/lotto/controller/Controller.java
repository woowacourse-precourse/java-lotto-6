package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.utils.ParseUtils;

import java.util.List;


public class Controller {

    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();

    ParseUtils parseUtils = new ParseUtils();

    public void run() {
        createUserLottos();
        showUserLottos();
    }

    private void showUserLottos() {
        int userLottoCount = lottoService.getUserLottoCount();
        System.out.println("\n" + userLottoCount + Message.USER_LOTTOS_COUNT_MESSAGE);
        List<Lotto> userLottos = lottoService.getUserLottos();

        for (Lotto lotto : userLottos) {
            System.out.println(lotto.toString());
        }
    }

    public void createUserLottos() {
        int lottoAmount = getAmount();
        lottoService.createUserLottos(lottoAmount);
    }


    public int getAmount() {
        System.out.println(Message.AMOUNT_REQUEST_MESSAGE);

        while (true) {
            String inputAmount = Console.readLine();
            Integer amount = amountValidationProcess(inputAmount);

            if (amount != null) {
                return amount;
            }
        }

    }

    public Integer amountValidationProcess(String inputAmount) {
        try {
            int amount = parseUtils.parseStringToInt(inputAmount);
            validationService.amountValidation(amount);

            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
