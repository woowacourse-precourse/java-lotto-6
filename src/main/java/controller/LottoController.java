package controller;

import constant.LottoConfig;
import dto.LottoCostRequst;
import lotto.Lotto;
import util.RandomNumberGenerator;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;
public class LottoController {
    LottoCostRequst lottoCostRequst;
    List<Lotto> lottos;
    public void start(){
        lottoCostRequst = new LottoCostRequst(Input.getInputForLottoCost());

        lottos = issueLottos(getLottoCountFromCost(lottoCostRequst));
        printPublishedLottos();
    }
    private int getLottoCountFromCost(LottoCostRequst lottoCostRequst){
        return lottoCostRequst.getCost() / LottoCostRequst.LOTTOT_COST;
    }

    private List<Lotto> issueLottos(int issueCount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<issueCount; i++){
            List<Integer> numbers = RandomNumberGenerator.create(
                    LottoConfig.NUM_COUNT.getValue(),
                    LottoConfig.START_INCLUSIVE.getValue(),
                    LottoConfig.END_INCLUSIVE.getValue()
            );
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printPublishedLottos(){
        System.out.println();
        Output.printLottoPurchaseMessage(this.lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
