package lotto.controller;

import lotto.Application;
import lotto.model.Lotto;
import lotto.model.RandomIntGenerator;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void setPrizeNumberInput() {
        List<Integer> newList = lottoView.prizeNumberInput().stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(newList);
        lotto.checkPrize(lottoView.bonusNumberInput(),randomIntGenerator.getLottoNumber());

        System.out.println();
    }

//    public static void setBonusNumberInput() {
//
//    }

    public void setRandomNumber(Integer Price) {

    }
}
