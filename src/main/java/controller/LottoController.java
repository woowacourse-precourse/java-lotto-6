package controller;

import constant.LottoConfig;
import domain.LottoMoney;
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
    private List<Lotto> lottos;

    public LottoController(){
        input = new Input();

    }
    public void start(){
        //lottoCostRequst = new LottoCostRequst(Input.getInputForLottoMoney());
        // 로또 살 금액 입력
        getLottoMeney();

       // this.lottos = issueLottos(getLottoCountFromCost(lottoCostRequst));
       // printPublishedLottos();
    }

    private void getLottoMeney(){
        while(true){
            try{
                lottoMoney = new LottoMoney(input.getInputForLottoMoney());
                return;
            } catch (NumberFormatException error){
                Output.errorMessage(error);
            }catch (IllegalArgumentException error){
                Output.errorMessage(error);
            }
        }
    }

    private List<Lotto> issueLottos(int issueCount){
//        List<Lotto> lottos = new ArrayList<>();
//
//        for(int i=0; i<issueCount; i++){
//            List<Integer> numbers = RandomNumberGenerator.create(
//                    LottoConfig.NUM_COUNT.getValue(),
//                    LottoConfig.START_INCLUSIVE.getValue(),
//                    LottoConfig.END_INCLUSIVE.getValue()
//            );
//            lottos.add(new Lotto(numbers));
//        }
//        return lottos;
    }

    private void printPublishedLottos(){
        System.out.println();
        Output.printLottoPurchaseMessage(this.lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

    private int getLottoCountFromCost(LottoCostRequst lottoCostRequst){
        return lottoCostRequst.getCost() / LottoConfig.COST.getValue();
    }
}
