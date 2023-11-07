package controller;

import constant.LottoConfig;
import domain.LottoMoney;
import domain.Lottos;
import dto.LottoCostRequst;
import domain.Lotto;
import util.RandomNumberGenerator;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;
public class LottoController {
    private LottoMoney lottoMoney;
    private Input input;
    private Lottos lottos;

    public LottoController(){
        input = new Input();

    }
    public void start(){
        //lottoCostRequst = new LottoCostRequst(Input.getInputForLottoMoney());
        // 로또 살 금액 입력
        lottoMoney = getLottoMeney();

       // lottos = issueLottos(getLottoCountFromCost(lottoMoney));
       // printPublishedLottos();
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

//    private void printPublishedLottos(){
//        System.out.println();
//        Output.printLottoPurchaseMessage(this.lottos.size());
//        for(Lotto lotto : lottos){
//            System.out.println(lotto);
//        }
//    }

    private int getLottoCountFromCost(LottoCostRequst lottoCostRequst){
        return lottoCostRequst.getCost() / LottoConfig.COST.getValue();
    }
}
