package lotto.view;

import static lotto.constants.LottoIOMessage.BUYING_QUANTITY_FORMAT;
import static lotto.constants.LottoIOMessage.GET_REWARDED_LOTTO_COUNT;
import static lotto.constants.LottoIOMessage.SAME_BONUS_NUM;
import static lotto.constants.LottoIOMessage.SAME_NUMBER_COUNT_FORMAT;
import static lotto.constants.LottoIOMessage.TOTAL_RETURN_FORMAT;
import static lotto.constants.LottoIOMessage.WINNING_MONEY_FORMAT;
import static lotto.constants.LottoIOMessage.WINNING_RESULT_MSG;
import static lotto.constants.MarksAndConstants.COMMA;
import static lotto.constants.MarksAndConstants.LEFT_BRACKET;
import static lotto.constants.MarksAndConstants.RIGHT_BRACKET;
import static lotto.constants.MarksAndConstants.SPACE;
import static lotto.constants.MarksAndConstants.START_INDEX;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoRanks;

public class OutputView {
    public void printQuantityAndAllNumbers(int quantity, List<List<Integer>> manyLotto) {
        System.out.printf(BUYING_QUANTITY_FORMAT, quantity);
        printAllLottoNumber(manyLotto);
    }
    private void printAllLottoNumber(List<List<Integer>> manyLotto) {
        for (List<Integer> oneLotto : manyLotto) {
            printOneLottoNumber(oneLotto);
        }
    }
    private void printOneLottoNumber(List<Integer> oneLotto) {
        System.out.println(convertLottoNumToString(oneLotto));
    }
    public String convertLottoNumToString(List<Integer> oneLotto) {
        StringBuilder lottoNum = new StringBuilder(LEFT_BRACKET + oneLotto.get(START_INDEX));
        for (int i = START_INDEX+1; i < oneLotto.size(); i++) {
            lottoNum.append(COMMA+SPACE);
            lottoNum.append(oneLotto.get(i));
        }
        lottoNum.append(RIGHT_BRACKET);
        return lottoNum.toString();
    }

    public void printLottoResult(Map<LottoRanks,Integer> result, double returnRate) {
        System.out.println(WINNING_RESULT_MSG);
        printWinningLottoCounts(result);
        printTotalReturnRate(returnRate);
        Console.close();
    }
    public void printWinningLottoCounts(Map<LottoRanks,Integer> result) {
        for (LottoRanks key : result.keySet()) {
            if (key == LottoRanks.NONE)
                continue;
            System.out.printf(appendFormat(key), key.getSameNumber(), key.getWinnings(), result.get(key));
        }
    }
    public String appendFormat(LottoRanks key) {
        StringBuilder result = new StringBuilder(SAME_NUMBER_COUNT_FORMAT);
        if (key.isSameBonus()) {
            result.append(SAME_BONUS_NUM);
        }
        result.append(WINNING_MONEY_FORMAT);
        result.append(GET_REWARDED_LOTTO_COUNT);
        return result.toString();
    }

    public void printTotalReturnRate(double returnRate) {
        System.out.printf(TOTAL_RETURN_FORMAT, returnRate);
    }
}
