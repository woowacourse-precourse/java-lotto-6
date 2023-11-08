package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static int buyNumber;
    public static List<Integer> winNumbers;
    public static int bonusNumber;
    public static ArrayList<List<Integer>> lottoNumbers;
    public static Map<String, Integer> equalsCount;

    public static void main(String[] args) {
        buyNumber = 0;
        bonusNumber = 0;
        winNumbers = new ArrayList<>();
        lottoNumbers = new ArrayList<>();
        equalsCount = new HashMap<>();

        BuyLotto buyLotto = new BuyLotto();
        buyNumber = buyLotto.inputBuyLotto();

        CreateNumber createNumber = new CreateNumber();
        lottoNumbers = createNumber.createLottoNumbers(buyNumber);
        System.out.println();

        CreateWinNumber createWinNumber = new CreateWinNumber();
        winNumbers = createWinNumber.winNumber();
        System.out.println();

        bonusNumber = createWinNumber.bonusNumber();
        System.out.println();

        lottoStatistics();
    }

    public static void lottoStatistics() {
        LottoWinMap lottoWinMap = new LottoWinMap();
        LottoStatisticsGenerator lottoStatisticsGenerator = new LottoStatisticsGenerator();
        System.out.println("당첨 통계");
        System.out.println("---");
        equalsCount = lottoWinMap.howManyEquals(lottoNumbers, winNumbers, bonusNumber);
        lottoStatisticsGenerator.statusEqualsCount(equalsCount);
        System.out.println("총 수익률은 " +
                lottoStatisticsGenerator.returnRate(equalsCount, buyNumber) + "%입니다.");
    }
}



