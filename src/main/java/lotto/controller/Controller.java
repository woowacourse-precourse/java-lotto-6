package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.utils.ParseUtils;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    ParseUtils parseUtils = new ParseUtils();

    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();

    List<Lotto> userLotto = new ArrayList<>();

    public void run() {
        createUserLottos();
    }


    private void createUserLottos() {
        int lottoAmount = getAmount();
        this.userLotto = lottoService.createUserLottos(lottoAmount);
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
