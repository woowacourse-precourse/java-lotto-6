package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.Rank;
import domain.WinningNumber;
import service.Service;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private final Service service;

    public void run() {
        int money = getMoneyByUserInput();
        List<Lotto> lottos = purchaseLotto(money);
        List<Integer> sixWinNumbers = getWinNumbersByUserInput();
        int bonusNumber = getBonusNumberByUserInput(sixWinNumbers);
        WinningNumber winningNumber = new WinningNumber(sixWinNumbers,bonusNumber);
        getLottoResult(lottos,winningNumber);

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

    public int getBonusNumberByUserInput(List<Integer> winningNumber) {
        while (true) {
            try {
                InputView.printAskForInputBonusNumber();
                String input = Console.readLine();
                return service.getBonusNumberByUserInput(input,winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map getLottoResult(List<Lotto> lottos, WinningNumber winningNumber){
        HashMap<Rank,Integer> result = new HashMap<Rank,Integer>();
        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }
        for(Lotto lotto : lottos){
            Rank rank = getTicketRank(lotto, winningNumber);
            result.put(rank,result.get(rank)+1);
        }
        return result;
    }

    public Rank getTicketRank(Lotto lotto , WinningNumber winningNumber){
        int countMatch = winningNumber.countMatch(lotto);
        boolean isMatchBonusNumber = winningNumber.isMatchBonusNumber(lotto);
        return Rank.checkTicketRank(countMatch,isMatchBonusNumber);
    }

}
