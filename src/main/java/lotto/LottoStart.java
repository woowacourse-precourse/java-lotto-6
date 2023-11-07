package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import userViews.InputViews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStart {

    private static final String HOW_MUCH_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String MAKE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MAKE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOARDER_LINE = "---";

    private static Buyer buyer;
    private static LottoWinningNumber lottoWinningNumber;
    private static CalculateMachine calculateMachine;
    private static PrintWinningResult printWinningResult;

    public static void run() {

        firstGameProgress();
        secondGameProgress();
        GameResult();

    }


    public static void firstGameProgress() {
        System.out.println(LottoStart.HOW_MUCH_BUY_MESSAGE);
        int money = firstInputProgress();
        int num = money / 1000;
        System.out.println();
        System.out.println(num+LottoStart.HOW_MANY_BUY_MESSAGE);

        buyer = new Buyer(money);

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

        while (true) {
            try {
                String inputHowMuchBuy = Console.readLine();
                int num = Integer.parseInt(inputHowMuchBuy);
                if (num < 1000) {
                    throw new IllegalArgumentException();
                }
                return num;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액을 입력해 주세요. (정수만 입력하거나 1000원 이상의 금액을 입력하셔야합니다.)");
            }
        }
    }

    private static void secondGameProgress() {
        System.out.println(LottoStart.MAKE_WINNING_NUMBER);
        List<Integer> inputWinningNumbers = secondInputProgress();

        System.out.println(LottoStart.MAKE_BONUS_NUMBER);
        int inputBonusNumbers = secondInputProgress2();

        lottoWinningNumber = new LottoWinningNumber(inputWinningNumbers, inputBonusNumbers);
    }

    public static List<Integer> secondInputProgress() {
        String inputWinningNumbers = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int secondInputProgress2() {
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    private static void GameResult() {

        System.out.println(LottoStart.WINNING_STATISTICS);
        System.out.println(LottoStart.BOARDER_LINE);

        calculateMachine = new CalculateMachine(buyer.getAllLottoCollection(), lottoWinningNumber.getWinningNumbers(), lottoWinningNumber.getBonusNumber());

        int[] lottoCalculateResult = calculateMachine.lottoResult();
        printWinningResult = new PrintWinningResult(lottoCalculateResult);
        printWinningResult.printLottoResult();

        double lottoProfitResult = calculateMachine.profitResult(buyer.getMoney(), lottoCalculateResult);
        printWinningResult.printProfitResult(lottoProfitResult);

    }


}
