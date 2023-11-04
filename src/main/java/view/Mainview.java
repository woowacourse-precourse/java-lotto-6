package view;

import java.util.Arrays;
import java.util.List;

public class Mainview implements LotoInputRequester,LottoResultPrinter{

    private final static String[] MONEY_OF_WINNING = {"5,000원", "50,000원", "1,500,000원",
            "30,000,000원", "2,000,000,000원"};
    private static final String ASK_FOR_HOW_MANY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_RESULT = "당첨통계\n---";
    private static final String PRINT_RATE_OF_PROFIT_PREFIX = "총 수익률은 ";
    private static final String PRINT_RATE_OF_PROFIT_SUFFIX = "%입니다.";
    private static final String PRINT_HOW_MANY_AND_LOTTOS_PREFIX = "개를 구매했습니다.";

    public void requestHowMany() {
        System.out.println(ASK_FOR_HOW_MANY);
    }

    public void requestNumbers() {
        System.out.println(REQUEST_NUMBERS);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public void printresult(int[] result) {
        System.out.println(PRINT_RESULT);
        for (int i = 0; i < result.length; i++) {
            if(i <= 2) {
                System.out.println(3 + i + "개 일치 (" + MONEY_OF_WINNING[i] + ") - " + result[i] + "개");
            }
            else if(i == 3)
            {
                System.out.println(5+ "개 일치, 보너스 볼 일치 (" + MONEY_OF_WINNING[i] + ") - " + result[i] + "개");
            }
            else if(i == result.length-1)
            {
                System.out.println(6+ "개 일치 (" + MONEY_OF_WINNING[i] + ") - " + result[i] + "개");
            }
        }
    }

    public void printRateOfProfit(String rate)
    {
        System.out.println(PRINT_RATE_OF_PROFIT_PREFIX+rate+PRINT_RATE_OF_PROFIT_SUFFIX);
    }

    public void printHowManyAndLottos(List<Integer[]> computerLottos)
    {
        System.out.println(computerLottos.size()+PRINT_HOW_MANY_AND_LOTTOS_PREFIX);
        for (Integer[] lotto : computerLottos)
        {
            System.out.println(Arrays.toString(lotto));
        }
    }
}
