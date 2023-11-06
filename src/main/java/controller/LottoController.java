package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoSystem;
import domain.Lottos;
import java.util.ArrayList;
import service.LottoService;
import util.Parser;
import util.Validate;
import view.LottoView;

import java.util.List;

public class LottoController {
    private final Parser parser = new Parser();
    private final Validate validate = new Validate();
    private final LottoService lottoService = new LottoService();
    private final int LOTTO_PRICE = 1000;
    public void run(){
        play(makeLottos(), makeLottoSystem());
    }
    private void play(Lottos lottos, LottoSystem lottoSystem){
        LottoView.printWinningResult();
        int[] lottoResult = lottoService.revealLottery(lottos, lottoSystem);
        LottoView.printLottoResults(lottoResult);
        LottoView.printTotalReturn(lottoService.getEarningRate(lottoResult, lottos));
    }
    private Lottos makeLottos(){
        Lottos lottos = new Lottos(NumberOfLotto(getTotalMoneyByUserInput()));
        LottoView.printLottoList(lottos);
        return lottos;
    }
    private LottoSystem makeLottoSystem(){
        List<Integer> winningNumber = parser.parseWinningNumber(getWinningNumberByUserInput());
        int bonusNumber = parser.parseInteger(getBonusNumberByUserInput(winningNumber));
        return new LottoSystem(winningNumber, bonusNumber);
    }
    private String getTotalMoneyByUserInput(){
        LottoView.printAskInputMoney();
        String input = Console.readLine();
        return CheckValidateMoneyInput(input);
    }
    private String getWinningNumberByUserInput(){
        LottoView.printAskInputWinningNumber();
        String input = Console.readLine();
        return CheckValidateWinningNumberInput(input);
    }
    private String getBonusNumberByUserInput(List<Integer> winningNumber){
        LottoView.printAskInputBonusNumber();
        String input = Console.readLine();
        return CheckValidateBonusNumberInput(input, winningNumber);
    }
    private String CheckValidateMoneyInput(String input){
        try {
            validate.CheckMoneyInput(input);
            return input;
        } catch (IllegalArgumentException e){
            LottoView.printException(e.getMessage());
            return  getTotalMoneyByUserInput();
        }
    }
    private String CheckValidateWinningNumberInput(String input){
        try{
            validate.CheckWinningNumber(input);
            return input;
        } catch (IllegalArgumentException e){
            LottoView.printException(e.getMessage());
            return getWinningNumberByUserInput();
        }
    }
    private String CheckValidateBonusNumberInput(String input, List<Integer> winningNumber){
        try{
            validate.CheckBonusNumber(input, winningNumber);
            return input;
        } catch (IllegalArgumentException e){
            LottoView.printException(e.getMessage());
            return getBonusNumberByUserInput(winningNumber);
        }
    }

    private int NumberOfLotto(String input){
        int lottoNum = parser.parseInteger(input)/LOTTO_PRICE;
        LottoView.printBuyResult(lottoNum);
        return lottoNum;
    }
}

