package lotto.view;

import static lotto.constants.LottoIOMessage.BUYING_QUANTITY_FORMAT;
import static lotto.constants.LottoIOMessage.GET_REWARDED_LOTTO_COUNT;
import static lotto.constants.LottoIOMessage.SAME_BONUS_NUM;
import static lotto.constants.LottoIOMessage.SAME_NUMBER_COUNT_FORMAT;
import static lotto.constants.LottoIOMessage.WINNING_MONEY_FORMAT;
import static lotto.constants.LottoIOMessage.WINNING_RESULT_MSG;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.LottoRanks;

public class OutputView {
    public void printQuantityAndAllNumbers(int quantity, List<List<Integer>> manyLotto) {
        System.out.printf(BUYING_QUANTITY_FORMAT, quantity);
        printAllLottoNumber(manyLotto);
    }
    public void printAllLottoNumber(List<List<Integer>> manyLotto) {
        for (List<Integer> oneLotto : manyLotto) {
            printOneLottoNumber(oneLotto);
        }
    }
    public void printOneLottoNumber(List<Integer> oneLotto) {
        System.out.println(convertLottoNumToString(oneLotto));
    }
    public String convertLottoNumToString(List<Integer> oneLotto) {
        StringBuilder lottoNum = new StringBuilder("[" + oneLotto.get(0));
        for (int i = 1; i < oneLotto.size(); i++) {
            lottoNum.append(", ");
            lottoNum.append(oneLotto.get(i));
        }
        lottoNum.append("]");
        return lottoNum.toString();
    }

    public void printWinningResult(Map<LottoRanks, Integer> enumMap) {
        System.out.println(WINNING_RESULT_MSG);
        for (LottoRanks key : enumMap.keySet()) {
            if (key == LottoRanks.NONE)
                continue;
            System.out.printf(SAME_NUMBER_COUNT_FORMAT, key.getSameNumber());
            if (key.isSameBonus()) {
                System.out.print(SAME_BONUS_NUM);
            }
            System.out.printf(WINNING_MONEY_FORMAT, convertWinningMoneyToString(key.getWinnings()));
            System.out.printf(GET_REWARDED_LOTTO_COUNT, enumMap.get(key));
        }
    }
    public String convertWinningMoneyToString(int winningMoney) {
        DecimalFormat temp = new DecimalFormat("###,###");
        return temp.format(winningMoney);
    }
}
