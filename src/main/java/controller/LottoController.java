package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.User;
import model.WinningNumber;
import service.LottoService;
import validate.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();
    OutputView outputView = new OutputView();

    public void startLotto(){
        int price = AskPrice();
        User user = new User(price, lottoService.makeLottoList(price));
        outputView.printLottoCount(user);

        WinningNumber winning_numbers = new WinningNumber(AskWinningNumbers(),AskBonus());
        for(Lotto lotto: user.getLottoList()){
            lottoService.awardLotto(lottoService.calculateRanking(lotto, winning_numbers),user);
        }
        user.giveMoney();
        outputView.printResult(user,lottoService.rateReturn(user));

    }

    public int AskPrice(){
        inputView.printAskPrice();
        return inputPrice();
    }

    public int inputPrice(){
        String my_price = Console.readLine();
        try{
            validator.checkInteger(my_price);
            validator.checkNull(my_price);
            validator.checkPrice1000(Integer.parseInt(my_price));
        }catch (NullPointerException e){
            return AskPrice();
        }catch (IllegalArgumentException e){
            return AskPrice();
        }
        return Integer.parseInt(my_price);
    }

    public List<Integer> AskWinningNumbers(){
        inputView.printWinningNumbers();
        return inputWinningNumber();
    }

    public List<Integer> inputWinningNumber(){
        List<Integer> winningNumberList = new ArrayList<>();
        try {
            winningNumberList = lottoService.makeWinningNumber(Console.readLine());
            validator.checkLottoRange(winningNumberList);
        }catch (NumberFormatException e){
            return inputWinningNumber();
        }catch (IllegalArgumentException e){
            return inputWinningNumber();
        }
        return winningNumberList;
    }

    public int AskBonus(){
        inputView.printAskBonusNumber();
        return inputBonus();
    }

    public int inputBonus(){
        String bonus = Console.readLine();
        try {
            validator.checkNull(bonus);
            validator.checkInteger(bonus);
        }catch (NullPointerException e){
            return AskBonus();
        }catch (IllegalArgumentException e){
            return AskBonus();
        }
        return Integer.parseInt(bonus);
    }
}
