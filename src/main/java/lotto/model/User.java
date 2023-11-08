package lotto.model;

import static lotto.view.InputView.lottoBoughtPrice;
import static lotto.view.InputView.userNum;
import static lotto.view.InputView.userBonusStr;
import static lotto.model.Lotto.prize;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static int lottoBoughtNum, userBonusNum;
    public static List<Integer> userNumListInt = new ArrayList<>();

    public static int lottoBoughtNum() {
        lottoBoughtNum = lottoBoughtPrice / 1000;
        return lottoBoughtNum;
    }

    public static void userNumListInt() {
        String[] userNumListStr = userNum.split(",");

        for (String s : userNumListStr) {
            userNumListInt.add(Integer.parseInt(s));
        }
    }

    public static void userBonusNum() {
        userBonusNum = Integer.parseInt(userBonusStr);
    }

    public static String userRateOfReturn() {
        double rateOfReturn = ((double) prize / lottoBoughtPrice) * 100.0;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0%");

        return decimalFormat.format(rateOfReturn / 100.0);
    }
}
