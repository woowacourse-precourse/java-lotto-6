package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoStart {

    private static final String HOW_MUCH_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String MAKE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MAKE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void run() {

        firstGameProgress();
        secondGameProgress();
        thirdGameProgress();

    }


    public static void firstGameProgress() {
        System.out.println(LottoStart.HOW_MUCH_BUY_MESSAGE);
        int num = firstInputProgress() / 1000;
        System.out.println();
        System.out.println(num+LottoStart.HOW_MANY_BUY_MESSAGE);

        Buyer buyer = new Buyer(num);

        for (int i = 0; i < num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            buyer.setLottoCollection(lotto.getLottoSixNum());
        }

        for(int i=0; i < num; i++){
            System.out.println(buyer.getLottoCollection(i));
        }
    }

    public static int firstInputProgress() {
        String inputHowMuchBuy = Console.readLine();
        return Integer.parseInt(inputHowMuchBuy);
    }

    private static void secondGameProgress() {
        System.out.print(LottoStart.MAKE_WINNING_NUMBER);
    }

    private static void thirdGameProgress() {
        System.out.print(LottoStart.MAKE_BONUS_NUMBER);
    }


}
