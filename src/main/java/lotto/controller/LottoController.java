package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPercentageCalculation;
import lotto.model.LottoPrize;
import lotto.model.RandomIntGenerator;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static lotto.model.LottoInformation.BUY_PRICE;
import static lotto.model.LottoPrize.*;

public class LottoController {
    private static LottoView lottoView = new LottoView();
    private static LottoPercentageCalculation lottoPercentageCalculation = new LottoPercentageCalculation();
    private static final RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
    static List<LottoPrize> LottoPrizelist= asList(FIFTH_PRIZE,FOURTH_PRIZE,THIRD_PRIZE,SECOND_PRIZE,FIRST_PRIZE);
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


        lottoView.seeWinningStatstic(LottoPrizelist);
    }

    public static void PerformanceCalculation() {
        lottoView.seePercentage(lottoPercentageCalculation.percentageCalculation(LottoPrizelist,BUY_PRICE));

    }

//    public static Integer setBonusNumberInput() {
//        return lottoView.bonusNumberInput();
//    }

    public void setRandomNumber(Integer Price) {

    }
}
