package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class OutputView {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUMBER = 6;
    public static void purchaseLottoNumber(){
        System.out.println("{}개를 구매했습니다.");
    }
    public static void lottoPrinter(){
        // 랜덤값 이용해 로또 출력(배열 형식)
        List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER);
        Lotto lotto = new Lotto(numbers);
//        Validator.validateSameNumberCheckStart(numbers);
        System.out.println(lotto);
    }

    public static void winningStatistics(){
        // 당첨 통계 + 총 수익률 출력
    }
}
