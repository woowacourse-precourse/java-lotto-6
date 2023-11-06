package lotto.controller;

import lotto.Application;
import lotto.model.RandomIntGenerator;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static LottoView lottoView = new LottoView();
    private static final RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
//    private static List<List<Integer>> buyLottoList = new ArrayList<>();
    public LottoController() {

    }

    public static void setPrice(){
        //view에서 가격입력받고 모델로 전달
       randomIntGenerator.makeLottoNumber(lottoView.askPrice());
    }

    public static void setBuyLottoNumberPrint() {
        lottoView.buyLottoNumberPrint(randomIntGenerator.getLottoNumber());
    }

    public void setRandomNumber(Integer Price) {

    }
}
