package controller;

import domain.LottoMoney;
import domain.Lottos;
import domain.Lotto;
import validator.LottoValidator;
import view.Input;
import view.Output;

public class LottoController {
    private LottoMoney lottoMoney;
    private Input input;
    private Lottos lottos;
    private Lotto winningNumber;

    public LottoController(){
        input = new Input();

    }
    public void start(){
        //lottoCostRequst = new LottoCostRequst(Input.getInputForLottoMoney());
        // 로또 살 금액 입력
        lottoMoney = getLottoMeney();

        lottos = issueLottos(lottoMoney.getAvaliablePurcahaseCount());
        printPublishedLottos();

        // 당첨 번호 입력
        winningNumber = getWinningNumber();
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
        Output.print();
        Output.printLottoPurchaseMessage(lottos.getLottos().size());
        for(Lotto lotto : lottos.getLottos()){
            Output.printLotto(lotto);
        }
    }

    private Lotto getWinningNumber(){
        Lotto tempWinningNumber;
        while(true){
            try {
                String userInputData = input.getInputForWinningNumber();
                tempWinningNumber = new Lotto(LottoValidator.validNumberic(userInputData));
                return tempWinningNumber;

            }catch (NumberFormatException error){
                Output.errorMessage(error);
            }catch (IllegalArgumentException error){
                Output.errorMessage(error);
            }

        }

    }
}
