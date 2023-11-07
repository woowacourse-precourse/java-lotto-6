package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.RandomIntGenerator;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static lotto.model.LottoPrize.*;

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
        lotto.checkSame(lottoView.bonusNumberInput(),randomIntGenerator.getLottoNumber());

        System.out.println();
    }

    public static void winningStatstic() {
        List<LottoPrize> LottoPrizelist= asList(FIRST_PRIZE,SECOND_PRIZE,THIRD_PRIZE,FOURTH_PRIZE,FIFTH_PRIZE);

        lottoView.seeWinningStatstic(LottoPrizelist);
    }

//    public static Integer setBonusNumberInput() {
//        return lottoView.bonusNumberInput();
//    }

    public void setRandomNumber(Integer Price) {

    }
}
