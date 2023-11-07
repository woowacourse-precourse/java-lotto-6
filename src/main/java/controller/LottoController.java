package controller;

import constant.ConfigMessage;
import domain.LottoMoney;
import domain.Lottos;
import domain.WinningNumber;
import domain.Lotto;
import util.Parser;
import validator.LottoValidator;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.List;
public class LottoController {
    private LottoMoney lottoMoney;
    private Input input;
    private Lottos lottos;
    private WinningNumber winningNumber;

    public LottoController(){
        input = new Input();

    }
    public void start(){
        //lottoCostRequst = new LottoCostRequst(Input.getInputForLottoMoney());
        // 로또 살 금액 입력
        lottoMoney = getLottoMeney();

        lottos = issueLottos(lottoMoney.getAvaliablePurcahaseCount());
        printPublishedLottos();

        getWinningNumber();
    }

    private LottoMoney getLottoMeney(){
        LottoMoney tempLottoMoney;
        while(true){
            try{
                tempLottoMoney = new LottoMoney(input.getInputForLottoMoney());
                return tempLottoMoney;
            } catch (NumberFormatException error){
                Output.errorMessage(error);
            }catch (IllegalArgumentException error){
                Output.errorMessage(error);
            }
        }
    }

    private Lottos issueLottos(int issueCount){
        return new Lottos(issueCount);
    }

    private void printPublishedLottos(){
        System.out.println();
        Output.printLottoPurchaseMessage(lottos.getLottos().size());
        for(Lotto lotto : lottos.getLottos()){
            Output.printLotto(lotto);
        }
    }

    private WinningNumber getWinningNumber(){
        List<Integer> winningNums;
        WinningNumber tempWinningNumber;
        while(true){
            try {
                String userInputData = input.getInputForWinningNumber();
                tempWinningNumber = new WinningNumber(LottoValidator.validNumberic(userInputData));
                return tempWinningNumber;

            }catch (NumberFormatException error){
                Output.errorMessage(error);
            }catch (IllegalArgumentException error){
                Output.errorMessage(error);
            }

        }

    }
}
