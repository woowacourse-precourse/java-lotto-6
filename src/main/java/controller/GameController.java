package controller;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.LottoMoney;
import view.InputView;
import view.OutputView;

public class GameController {
    LottoMoney lottoMoney;
    Lotto lotto;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomUtility randomUtility = new RandomUtility();

    List<List<Integer>> lottoNumbers = new ArrayList<>();
    boolean restart = true;

    public void startGame() {
        saveLottoMoney();
        outputView.printLottoTicketMessage(lottoMoney);
        randomUtility.generateRandomLottoNumbers();
        saveRandomLottoNumbers(lottoMoney);
        saveLuckeyNumbers();
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
                System.out.println(luckeyNumbers);
                lotto = new Lotto(luckeyNumbers);
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
