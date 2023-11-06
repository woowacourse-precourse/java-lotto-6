package controller;

import dto.LottoCostRequst;
import lotto.Lotto;
import view.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    LottoCostRequst lottoCostRequst;
    List<Lotto> lottos;
    public void start(){
        lottoCostRequst = new LottoCostRequst(Input.getInputForLottoCost());

    }

    public void publishLottos(LottoCostRequst lottoCostRequst){
        lottos = new ArrayList<>();
        int count = lottoCostRequst.getCost() / LottoCostRequst.LOTTOT_COST;
        for(int i=0; i<count; i++){

            lottos.add(new Lotto())
        }
    }
}
