package lotto.view;

import lotto.domain.CompareLottoValue;
import lotto.domain.Lotto;
import lotto.domain.WinningAmounts;
import lotto.util.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class OutputView {

    public static void purchaseLottoNumber(int lottoCount){
        System.out.println( lottoCount+"개를 구매했습니다.");
    }
    public static void lottoPrinter(List<Integer> numbers){
        System.out.println(numbers);
    }

    public static void winningStatistics(Integer amount){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ WinningAmounts.FIFTH_AMOUNT.getCount() +"개");
        System.out.println("4개 일치 (50,000원) - "+ WinningAmounts.FORTH_AMOUNT.getCount() +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ WinningAmounts.THIRD_AMOUNT.getCount() +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ WinningAmounts.SECOND_AMOUNT.getCount() +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ WinningAmounts.FIRST_AMOUNT.getCount() +"개");
    }
    public static void winningRate(double rate){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rate));
    }
}