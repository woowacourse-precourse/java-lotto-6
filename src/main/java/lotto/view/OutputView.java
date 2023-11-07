package lotto.view;

import static lotto.constant.InputConstant.DASH;
import static lotto.constant.LottoConstant.FIFTH_PLACE;
import static lotto.constant.LottoConstant.FIRST_PLACE;
import static lotto.constant.LottoConstant.FOURTH_PLACE;
import static lotto.constant.LottoConstant.SECOND_PLACE;
import static lotto.constant.LottoConstant.THIRD_PLACE;
import static lotto.constant.ResultConstant.FIFTH_PLACE_MESSAGE;
import static lotto.constant.ResultConstant.FIRST_PLACE_MESSAGE;
import static lotto.constant.ResultConstant.FOURTH_PLACE_MESSAGE;
import static lotto.constant.ResultConstant.PROFIT_RATE_MESSAGE;
import static lotto.constant.ResultConstant.SECOND_PLACE_MESSAGE;
import static lotto.constant.ResultConstant.THIRD_PLACE_MESSAGE;
import static lotto.constant.MessageConstant.PRIZE_STATS_MESSAGE;

import java.util.List;
import lotto.constant.NumberConstant;
import lotto.constant.ResultConstant;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoMessage(List<Lotto> lottos){
        System.out.println(ResultConstant.BUY_MESSAGE.getMessage(lottos.size()));
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printPrizeResult(List<Integer> rank){
        printPrizeMessage();
        printFifthPlaceResult(rank.get(FIFTH_PLACE.getIndex()));
        printFourthPlaceResult(rank.get(FOURTH_PLACE.getIndex()));
        printThirdPlaceResult(rank.get(THIRD_PLACE.getIndex()));
        printSecondPlaceResult(rank.get(SECOND_PLACE.getIndex()));
        printFirstPlaceResult(rank.get(FIRST_PLACE.getIndex()));
    }

    public void printProfitRateResult(double rate){
        System.out.println(PROFIT_RATE_MESSAGE.getMessage(rate));
    }

    private void printPrizeMessage(){
        System.out.println(PRIZE_STATS_MESSAGE.getMessage());
        System.out.println(DASH.getValue().repeat(NumberConstant.DASH_COUNT));
    }

    private void printFifthPlaceResult(int count){
        System.out.println(FIFTH_PLACE_MESSAGE.getMessage(count));
    }

    private void printFourthPlaceResult(int count){
        System.out.println(FOURTH_PLACE_MESSAGE.getMessage(count));
    }

    private void printThirdPlaceResult(int count){
        System.out.println(THIRD_PLACE_MESSAGE.getMessage(count));
    }

    private void printSecondPlaceResult(int count){
        System.out.println(SECOND_PLACE_MESSAGE.getMessage(count));
    }

    private void printFirstPlaceResult(int count){
        System.out.println(FIRST_PLACE_MESSAGE.getMessage(count));
    }
}
