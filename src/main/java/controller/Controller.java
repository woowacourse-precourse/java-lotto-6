package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import service.Service;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final Service service;

    public void run(){
        int money = getMoneyByUserInput();
        List<Lotto> lottos = purchaseLotto(money);
    }
    public Controller(Service service) {
        this.service = service;
    }
    public int getMoneyByUserInput(){
        while(true){
            try {
                InputView.printAskForInputAmount();
                String input = Console.readLine();
                return service.getMoneyByUserInput(input);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> purchaseLotto(int money){
        int lottoAmount = service.calculateLottoAmount(money);
        OutputView.printPurchaseAmount(lottoAmount);
        List<Lotto> lottos =  service.generateLotto(lottoAmount);
        for(Lotto lotto : lottos){
            OutputView.printLotto(lotto);
        }
        return lottos;
    }
}
