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
import static lotto.constant.ResultConstant.SECOND_PLACE_MESSAGE;
import static lotto.constant.ResultConstant.THIRD_PLACE_MESSAGE;
import static lotto.constant.MessageConstant.PRIZE_STATS_MESSAGE;

import java.util.List;
import lotto.constant.NumberConstant;
import lotto.constant.ResultConstant;
import lotto.model.Lotto;

public class OutputView {
    public void printBuyMessage(List<Lotto> lottos){
        System.out.println(ResultConstant.BUY_MESSAGE.getMessage(lottos.size()));
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResultMessage(List<Integer> rank){
        printPrizeMessage();
        System.out.println(FIFTH_PLACE_MESSAGE.getMessage(rank.get(FIFTH_PLACE.getIndex())));
        System.out.println(FOURTH_PLACE_MESSAGE.getMessage(rank.get(FOURTH_PLACE.getIndex())));
        System.out.println(THIRD_PLACE_MESSAGE.getMessage(rank.get(THIRD_PLACE.getIndex())));
        System.out.println(SECOND_PLACE_MESSAGE.getMessage(rank.get(SECOND_PLACE.getIndex())));
        System.out.println(FIRST_PLACE_MESSAGE.getMessage(rank.get(FIRST_PLACE.getIndex())));
    }

    private void printPrizeMessage(){
        System.out.println(PRIZE_STATS_MESSAGE);
        System.out.println(DASH.getValue().repeat(NumberConstant.DASH_COUNT));
    }
}
