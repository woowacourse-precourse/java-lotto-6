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

    List<List<Integer>> lottosList = new ArrayList<>();
    List<Integer> userlottoList;

    private static int bonus = 0;

    public void run() {
        saveMoney(parser.parseNumber(getMoneyNumberbyInput()));
    }

    private void saveMoney(int input) {
        moneyRepository.save(input);
        playLotto();
    }

    private void playLotto() {
        OutputView.printMoneyResult(moneyRepository.getMoney());
        List<Integer> lottoList = new ArrayList<>();
        for (int i = 0; i < moneyRepository.getTrial(); i++) {
            for (int j = 0; j < 6; j++) {
                lottoList = lottoService.getProgramRandomNumber();
            }
        }
        lottosList.add(lottoList);
        lottoService.lottoSave(lottosList);

        saveLottoNumbers(parser.parseLottoNumberToInt(getUserLottoNumberbyInput()));
        saveBonusNumber(parser.parseNumber(getUserBonusNumberbyInput()));

        play();
    }

    private void play() {
        //lottoService.play(moneyRepository.getTrial());
        OutputView.printLottoResult();
        int[] correct = new int[8];
        int check = 0;

        for(int k = 0; k < 6; k++) {
            int current_lotto = userlottoList.get(k);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if(current_lotto == lottosList.get(i).get(j)) {
                        check++;
                    }
                    if (check == 5) {
                        if (bonus == lottosList.get(i).get(j)) {
                            check = 7;
                        }
                    }
                }
                if(check == 3) correct[3]++;
                if(check == 4) correct[4]++;
                if(check == 5) correct[5]++;
                if(check == 6) correct[6]++;
                if(check == 7) correct[7]++; // 보너스 볼
                check = 0;
            }
        }

        OutputView.printRevenue(correct, moneyRepository.getMoney());
    }


    private void saveLottoNumbers(List<Integer> lottoNumbers) {
        new Lotto(lottoNumbers);
        userlottoList = lottoNumbers;
        OutputView.printRandomLotto(lottoNumbers);
        for (Integer lottoNumber : lottoNumbers) {
            lottoService.save(new Lottos(lottoNumber));
        }
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
