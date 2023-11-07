package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.ExceptionService;
import lotto.service.UserService;

import java.util.ArrayList;

public class UserController {
    private User user;
    private InputManager inputManager;
    private MessageManager messageManager;
    private ExceptionService exceptionService;
    private UserService userService;


    public UserController(User user) {
        this.user = user;
        this.inputManager = new InputManager();
        this.messageManager = new MessageManager();
        this.exceptionService = new ExceptionService();
        this.userService = new UserService();
    }

    public void savePayMoney(){
        do{
            try{
                String payMoney = inputManager.inputMoney();
                exceptionService.checkCount(payMoney);
                user.setPayMoney(Integer.parseInt(payMoney));
                user.setCount(userService.calculateCount((Integer.parseInt(payMoney))));
                break;
            }catch (IllegalArgumentException e){

            }
        }while(true);
    }

    public void showMyCount(){
        System.out.println(user.getCount() + MessageManager.BUY_LOTTOS);
    }

    public void buyLottos(){
        ArrayList<Lotto> lottos = userService.createLotto(user.getCount());
        user.setLottos(lottos);
        messageManager.showLottos(lottos);
    }

    public void predictWinningNumber(){
        do{
            try{
                String winningNumber = inputManager.inputWinningNumber();
                exceptionService.checkWinning(winningNumber);
                ArrayList<Integer> lotto = userService.changeWinningNumberType(winningNumber);
                user.setWinningNumber(new Lotto(lotto));
                break;
            }catch (IllegalArgumentException e){

            }
        }while(true);
    }

    public void predictBonusNumber(){
        do{
            try{
                String bonusNumber = inputManager.inputBonusNumber();
                exceptionService.checkBonus(bonusNumber, user.getWinningNumber().getNumbers());
                user.setBonusNumber(Integer.parseInt(bonusNumber));
                break;
            }catch (IllegalArgumentException e){

            }
        }while(true);
    }

    public void showWinningResult(){
        System.out.println(MessageManager.SHOW_RESULT);
        ArrayList<Integer> winningCount = userService.calculateWinningCount(user.getLottos(), user.getWinningNumber(),user.getBonusNumber());
        user.setWinnersResult(winningCount);
        messageManager.showWinningResult(user.getWinnersResult());
    }

    public void showRateMoney(){
        int winnerMoney = userService.calculateWinnerMoney(user.getWinnersResult());
        user.setWinnerMoney(winnerMoney);
        String rate = userService.calculateRateMoney(user.getPayMoney(), user.getWinnerMoney());
        messageManager.showRateMoney(rate);
    }

}
