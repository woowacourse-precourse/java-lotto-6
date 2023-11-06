package lotto.template;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.enums.LottoEnum;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static lotto.LottoConst.LOTTO_PRICE;
import static lotto.enums.LottoEnum.W2;

public class Print {

    public static void printMyLottoList(List<Lotto> myLottoList) {
        System.out.println(myLottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : myLottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printEnums();
        System.out.println("총 수익률은 " + getRewardPercent(amount) + "입니다.");
    }

    private static void printEnums() {
        LottoEnum[] values = LottoEnum.values();
        Arrays.sort(values, Comparator.reverseOrder());
        for (LottoEnum value : values) {
            System.out.println(getResultString(value));
        }
    }

    private static String getResultString(LottoEnum value) {
        DecimalFormat df = new DecimalFormat("###,###");
        int winCount = value.getWinCount();
        String reward = df.format(value.getReward());
        int count = Result.getCount(value);
        if (value.equals(W2)){
            return winCount + "개 일치, 보너스 볼 일치 (" + reward + "원) - " + count + "개";
        }
        return winCount + "개 일치 (" + reward + "원) - " + count + "개";
    }



    private static String getRewardPercent(int amount) {
        int total = Result.getTotal();
        double totalDouble = 100.0 * total / (amount * LOTTO_PRICE);
        System.out.println(totalDouble);
        String temp = String.format("%.1f%%", totalDouble);
        return temp.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }
}
