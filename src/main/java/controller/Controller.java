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

    private List<List<Integer>> lottosList = new ArrayList<>();
    private List<Integer> userlottoList;
    private List<Integer> lottoList = new ArrayList<>();

    private static int bonus = 0;

    public void run() {
        saveMoney(parser.parseNumber(getMoneyNumberbyInput()));
    }

    private void saveMoney(int input) {
        moneyRepository.save(input);
        OutputView.printMoneyResult(moneyRepository.getMoney());
        playLotto();
    }

    private void playLotto() {
        lottosList.clear();

        for (int i = 0; i < moneyRepository.getTrial(); i++) {
            lottosList.add(saveLotto());
        }

        lottoService.lottoSave(lottosList);
        saveLottoNumbers(parser.parseLottoNumberToInt(getUserLottoNumberbyInput()));
        saveBonusNumber(parser.parseNumber(getUserBonusNumberbyInput()));

        OutputView.printLottoResult();
        play();
    }

    private void play() {

        int[] correct = new int[8];
        int check_each = 0;

        for (int i = 0; i < moneyRepository.getTrial(); i++) {
            check_each = lottoService.compareLottoList(i, userlottoList, lottosList, check_each);
            correct = compareCorrectLotto(check_each);

            check_each = 0;
        }
        OutputView.printRevenue(correct, moneyRepository.getMoney());
    }

    public int[] compareCorrectLotto(int check) {
        int[] correct = new int[8];

        if(check == 3) correct[3]++;
        if(check == 4) correct[4]++;
        if(check == 5) correct[5]++;
        if(check == 6) correct[6]++;
        if(check == 7) correct[7]++; // 보너스

        return correct;
    }


    private void saveLottoNumbers(List<Integer> lottoNumbers) {

        for (Integer lottoNumber : lottoNumbers) {
            lottoService.save(new Lottos(lottoNumber));
        }
        userlottoList = lottoNumbers;
    }

    private void saveBonusNumber(Integer bonus_number) {
        lottoService.save(new Lottos(bonus_number));
        bonus = bonus_number;
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
            validator.checkNotNumber(input);
            new Lotto(parser.parseLottoNumberToInt(input)); //parser
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

    private List<Integer> saveLotto() {
        lottoList = lottoService.getProgramRandomNumber();

        OutputView.printRandomLotto(lottoList);
        return lottoList;
    }

    private List<Lottos> getUserInputLottoList() {
        return lottoRepository.findAll();
    }
}
