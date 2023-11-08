package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.Rank;
import domain.WinningNumber;
import service.Service;
import view.InputView;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;


public class Controller {
    private final Service service;
    public Controller(Service service) {
        this.service = service;
    }

    public void run() {
        int money = getMoneyByUserInput();
        List<Lotto> lottos = purchaseLotto(money);
        Lotto winningLotto = getWinNumbersByUserInput();
        WinningNumber winningNumber = getBonusNumberByUserInput(winningLotto);
        LinkedHashMap<Rank, Integer> lottoResult = getLottoResult(lottos, winningNumber);
        getRateOfReturn(lottoResult, money);
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
        int numberOfLottoTicket = service.calculateNumberOfLottoTicket(money);
        OutputView.printPurchaseAmount(numberOfLottoTicket);
        List<Lotto> lottos = service.generateLottos(numberOfLottoTicket);
        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto);
        }
        return lottos;
    }

    public Lotto getWinNumbersByUserInput() {
        while (true) {
            try {
                InputView.printAskForInputWinNumber();
                String input = Console.readLine();
                return service.generateLottoByUserInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumber getBonusNumberByUserInput(Lotto winningLotto) {
        while (true) {
            try {
                InputView.printAskForInputBonusNumber();
                String input = Console.readLine();
                return service.generateWinningNumberWithBonusNumberByUserInput(input, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LinkedHashMap getLottoResult(List<Lotto> lottos, WinningNumber winningNumber) {
        LinkedHashMap<Rank, Integer> result = service.getLottoResult(lottos, winningNumber);
        OutputView.printStatisticsResult(result);
        return result;
    }

    public void getRateOfReturn(LinkedHashMap lottoResult, int money) {
        float rateOfReturn = service.calculateRateOfReturn(lottoResult, money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
