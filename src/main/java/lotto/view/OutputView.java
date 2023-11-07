package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
//constant의 값들을 가져오기 위해 import
import static lotto.constants.InputMessages.*;
import static lotto.constants.ResponseMessages.*;

public class OutputView {

    public static void printStartBuyMessage() {
        System.out.println(START_BUY_MESSAGE.getMessage());
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + END_BUY_MESSAGE.getMessage());
    }

    public static void printLottoSet(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            printLottoNumbers(lotto);
        }
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printGetWinNumberMessage() {
        System.out.println(GET_WIN_NUMBER_MESSAGE.getMessage());
    }

    public static void printGetBonusNumberMessage() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printWinningStatistics(HashMap<String, Integer> finalScore, double yield) {
        System.out.println();
        System.out.println(WIN_STATS_MESSAGE.getMessage());
        System.out.println(LINE_MESSAGE.getMessage());
        System.out.println(WIN_MESSAGE_5.getMessage() + finalScore.getOrDefault("5등", 0) + "개");
        System.out.println(WIN_MESSAGE_4.getMessage() + finalScore.getOrDefault("4등", 0) + "개");
        System.out.println(WIN_MESSAGE_3.getMessage() + finalScore.getOrDefault("3등", 0) + "개");
        System.out.println(WIN_MESSAGE_2.getMessage() + finalScore.getOrDefault("2등", 0) + "개");
        System.out.println(WIN_MESSAGE_1.getMessage() + finalScore.getOrDefault("1등", 0) + "개");
        System.out.println(PROFIT_MESSAGE.getMessage() + yield + "%입니다.");
    }

}
