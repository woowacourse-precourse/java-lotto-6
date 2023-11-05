package controller;

import domain.Lottos;
import lotto.Lotto;
import repository.LottoRepository;
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
    private LottoRepository lottoRepository = new LottoRepository();


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

        saveLottoNumbers(parser.parseLottoNumber(getUserLottoNumberbyInput()));
        saveBonusNumber(getUserBonusNumberbyInput());

        play();
    }

    private void play() {

    }


    private void saveLottoNumbers(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            lottoRepository.save(new Lottos(lottoNumber));
        }
    }

    private void saveBonusNumber(String bonus_number) {
        lottoRepository.save(new Lottos(bonus_number));
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

    private String getUserLottoNumberbyInput() {
        InputView.requestLotto();
        String input = readLine();

        return checkLottoValidation(input);
    }

    private String checkLottoValidation(String input) {
        try {
            validator.checkLottoInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getUserLottoNumberbyInput();
        }
    }

    private String getUserBonusNumberbyInput() {
        InputView.requestPlusLotto();
        String input = readLine();

        return checkBonusLottoValidation(input);
    }
    private String checkBonusLottoValidation(String input) {
        try {
            validator.checkBonusLottoInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getUserBonusNumberbyInput();
        }
    }

}
