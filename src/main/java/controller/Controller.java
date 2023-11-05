package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import service.Service;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final Service service;

    public void run() {
        int money = getMoneyByUserInput();
        List<Lotto> lottos = purchaseLotto(money);
        List<Integer> winNumbers = getWinNumbersByUserInput();
        int bonusNumber = getBonusNumberByUserInput(winNumbers);

    }

    public Controller(Service service) {
        this.service = service;
    }

    public int getMoneyByUserInput() {
        while (true) {
            try {
                InputView.printAskForInputAmount();
                String input = Console.readLine();
                return service.getMoneyByUserInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> purchaseLotto(int money) {
        int lottoAmount = service.calculateLottoAmount(money);
        OutputView.printPurchaseAmount(lottoAmount);
        List<Lotto> lottos = service.generateLotto(lottoAmount);
        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto);
        }
        return lottos;
    }

    public List<Integer> getWinNumbersByUserInput() {
        while (true) {
            try {
                InputView.printAskForInputWinNumber();
                String input = Console.readLine();
                return service.getWinNumbersByUserInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumberByUserInput(List<Integer> winNumbers) {
        while (true) {
            try {
                InputView.printAskForInputBonusNumber();
                String input = Console.readLine();
                return service.getBonusNumberByUserInput(input,winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
