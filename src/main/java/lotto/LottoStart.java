package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class LottoStart {

    private static final String HOW_MUCH_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String MAKE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MAKE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOARDER_LINE = "---";

    private static Buyer buyer;
    private static LottoWinningNumber lottoWinningNumber;

    public static void run() {

        firstGameProgress();
        secondGameProgress();
        GameResult();

    }


    public static void firstGameProgress() {
        System.out.println(LottoStart.HOW_MUCH_BUY_MESSAGE);
        int num = firstInputProgress() / 1000;
        System.out.println();
        System.out.println(num+LottoStart.HOW_MANY_BUY_MESSAGE);

        buyer = new Buyer(num);

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
        System.out.println(LottoStart.MAKE_WINNING_NUMBER);
        System.out.println(LottoStart.MAKE_BONUS_NUMBER);
        lottoWinningNumber = new LottoWinningNumber(secondInputProgress(), secondInputProgress2());
    }

    public static List<Integer> secondInputProgress() {
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.substring(1, inputWinningNumbers.length()-1).split(","))
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    public static int secondInputProgress2() {
        String inputBounsNumbers = Console.readLine();
        return Integer.parseInt(inputBounsNumbers);
    }

    private static void GameResult() {
        System.out.print(LottoStart.WINNING_STATISTICS);
        System.out.print(LottoStart.BOARDER_LINE);

        ComparisonMachine comparisonMachine = new ComparisonMachine(buyer.getAllLottoCollection(), lottoWinningNumber.getWinningNumbers(), lottoWinningNumber.getBounsNumber());

    }


}
