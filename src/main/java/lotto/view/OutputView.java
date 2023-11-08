package lotto.view;

import lotto.domain.CompareLottoValue;
import lotto.domain.Lotto;
import lotto.domain.WinningAmounts;
import lotto.util.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class OutputView {
//    public static final int MIN_NUM = 1;
//    public static final int MAX_NUM = 45;
//    public static final int LOTTO_NUMBER = 6;


    public static void purchaseLottoNumber(int lottoCount){
        System.out.println( lottoCount+"개를 구매했습니다.");
    }
    public static void lottoPrinter(List<Integer> numbers){
        // 랜덤값 이용해 로또 출력(배열 형식)
//        List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER);
//        Lotto lotto = new Lotto(numbers);
        System.out.println(numbers);
        // 당첨 번호와 값 비교 하고, 결과값들을 최종 상금 구하는곳으로 넘기기
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
        System.out.println("총 수익률은 "+rate+"%입니다");
    }
}