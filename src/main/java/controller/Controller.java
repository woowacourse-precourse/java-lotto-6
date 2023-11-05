package controller;

import repository.MoneyRepository;
import util.Parser;
import util.Validator;
import view.InputView;
import view.OutputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private MoneyRepository moneyRepository = new MoneyRepository();

    public void run() {
        saveMoney(parser.parseMoneyNumber(getMoneyNumberbyInput()));
    }

    private void saveMoney(int input) {
        moneyRepository.save(input);
    }

    private String getMoneyNumberbyInput() {
        InputView.requestMoney();
        String input = readLine();

        return checkMoneyValidation(input);
    }

    private String checkMoneyValidation(String input) {
        try {
            validator.checkMoneyInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getMoneyNumberbyInput();
        }
    }


}
