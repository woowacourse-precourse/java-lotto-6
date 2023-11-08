package controller;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.LottoMoney;
import lotto.LuckeyLotto;
import view.InputView;
import view.OutputView;

public class GameController {
    LottoMoney lottoMoney;
    Lotto lotto;
    LuckeyLotto luckeyLotto;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomUtility randomUtility = new RandomUtility();
    LottoController lottoController;

    List<List<Integer>> lottoNumbers = new ArrayList<>();
    boolean restart = true;

    public void startGame() {
        saveLottoMoney();
        outputView.printLottoTicketMessage(lottoMoney);
        saveRandomLottoNumbers(lottoMoney);
        saveLuckeyNumbers();
        saveBonusLottoNumber();
        lottoController = new LottoController(lotto, lottoMoney, luckeyLotto);
        lottoController.playGame(lottoNumbers);
    }

    private void saveLottoMoney() {
        while (restart) {
            try {
                String inputMoney = inputView.enterLottoMoney();
                lottoMoney = new LottoMoney(inputMoney);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveRandomLottoNumbers(LottoMoney lottoMoney) {
        for (int i = 0; i < lottoMoney.getLottoTicket(); i++) {
            List<Integer> numbers = randomUtility.generateRandomLottoNumbers();
            outputView.printLottoNumber(numbers);
            lottoNumbers.add(numbers);
        }
    }

    private void saveLuckeyNumbers() {
        restart = true;
        while (restart) {
            try {
                String luckeyNumber = inputView.enterLottoNumber();
                luckeyNumber = deleteWhiteSpace(luckeyNumber);
                List<Integer> luckeyNumbers = convertStringToStringList(luckeyNumber);
                lotto = new Lotto(luckeyNumbers);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveBonusLottoNumber() {
        restart = true;
        while (restart) {
            try {
                String luckeyBonusNumber = inputView.enterBonusLottoNumber();
                luckeyLotto = new LuckeyLotto(lotto.getNumbers(), luckeyBonusNumber);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String deleteWhiteSpace(String luckeyNumber) {
        return luckeyNumber.replaceAll(" ", "");
    }

    private List<Integer> convertStringToStringList(String luckeyNumber) {
        List<Integer> luckeyNumbers = new ArrayList<>();
        String[] convertStringArray = luckeyNumber.split(",");

        for (String numbers : convertStringArray) {
            luckeyNumbers.add(Integer.parseInt(numbers));
        }
        return luckeyNumbers;
    }

}
