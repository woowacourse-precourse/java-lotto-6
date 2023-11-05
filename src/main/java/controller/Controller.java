package controller;

import repository.MoneyRepository;
import service.LottoService;
import util.Parser;
import util.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final LottoService lottoService = new LottoService();


    private MoneyRepository moneyRepository = new MoneyRepository();

    public void run() {
        saveMoney(parser.parseMoneyNumber(getMoneyNumberbyInput()));
    }

    private void saveMoney(int input) {
        moneyRepository.save(input);
        playLotto();
    }

    private void playLotto() {
        OutputView.printMoneyResult(moneyRepository.getMoney());

        List<List<Integer>> lottosList = new ArrayList<>();
        List<Integer> lottoList = null;

        for (int i = 0; i < moneyRepository.getTrial(); i++) {
            lottoList = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                lottoList = lottoService.getProgramRandomNumber();
            }
        }
        lottosList.add(lottoList);
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
