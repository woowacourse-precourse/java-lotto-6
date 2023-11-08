package lotto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumberDTO;
import lotto.validator.InputValidator;
import lotto.view.IOVIew;
import lotto.view.OutputMessage;
import lotto.view.PrizeMessage;

public class LottoIOController {
    private IOVIew iovIew;
    private InputValidator inputValidator;
    private PrizeMessage prizeMessage = new PrizeMessage();


    public LottoIOController() {
        this.iovIew = new IOVIew();
        this.inputValidator = new InputValidator();
    }

    public void introOutput(){
        iovIew.showSingleMessage(OutputMessage.PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public Integer setPurchasePrice(){
        String Price = iovIew.userInput();
        Price.trim();
        while(!inputValidator.checkPriceInputInteger(Price)){
            Price=iovIew.userInput();
        }
        return  Integer.parseInt(Price);
    }


    public List<String> splitInput(String input){
        input.trim();
        return Arrays.asList(input.split(","));
    }

    public List<Integer> setWinningNumber(){
        String input= iovIew.userInput();
        List<String> winnigNumber = splitInput(input);

        while(!inputValidator.checkWinningNumberInputInteger(winnigNumber)){
            input = iovIew.userInput();
            winnigNumber = splitInput(input);
        }
        List<Integer> intWinningNumber = StringListToIntegerList(winnigNumber);

        return intWinningNumber;
    }

    public List<Integer> StringListToIntegerList(List<String> winningNumber){
        List<Integer> intWinningNumber = new ArrayList<>();

        for (String str : winningNumber) {
            int number = Integer.parseInt(str);
            intWinningNumber.add(number);
        }
        return intWinningNumber;
    }

    public Integer setBonusNumber(List<Integer> winningNumbers){
        String input= iovIew.userInput();
        input.trim();
        while(!inputValidator.checkBonusInputInteger(input,winningNumbers)){
            input=iovIew.userInput();
        }
        return Integer.parseInt(input);
    }

    public void getIntroducePurchaseNum(int lottoCount){
        iovIew.showSingleMessage("");
        System.out.println(OutputMessage.PURCHASE_INTRODUCE_MESSAGE.getIntroduceMessage(lottoCount));
    }

    public void notifyLottoNums(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            lotto.printNum();
        }
    }

    public void notifySetWinningNumber(){
        System.out.println(OutputMessage.GET_NEXT_LINE.toString() + OutputMessage.GET_LOTTO_NUMBER_MESSAGE);
    }

    public void notifySetBonusNumber(){
        System.out.println(OutputMessage.GET_NEXT_LINE.toString()+OutputMessage.GET_BONUS_NUMBER_MESSAGE);
    }

    public void printPrizeNum(HashMap<String,Integer> prizeNum){
        List<String> result=prizeMessage.makePrizeMessage(prizeNum);
        iovIew.showMessages(result);
    }

    public void printWinningRate(BigDecimal winningRate){
        iovIew.showSingleMessage(OutputMessage.RESULT_MESSAGE.getWinningRateMessage(winningRate));
    }
    public void notifyResult(){
        System.out.println(OutputMessage.GET_NEXT_LINE.toString()+OutputMessage.RESULT_MESSAGE);
    }


}
