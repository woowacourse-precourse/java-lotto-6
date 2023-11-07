package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStart {

    private static Buyer buyer;
    private static LottoWinningNumber lottoWinningNumber;
    private static CalculateMachine calculateMachine;
    private static PrintWinningResult printWinningResult;

    //게임 실행 메서드
    public static void run() {

        first_GameProgress();

        second_GameProgress();

        last_GameProgress();

    }


    public static void first_GameProgress() {

        System.out.println(Messages.lottoStartMessages.HOW_MUCH_BUY_MESSAGE.getMessage());

        int money = first_InputProgress();
        int numberOfLotto = first_CalculateMoneyToNum(money);

        System.out.println();
        System.out.println(numberOfLotto + Messages.lottoStartMessages.HOW_MANY_BUY_MESSAGE.getMessage());

        buyer = first_CreateBuyer(money);
        first_MakeLotto(buyer, numberOfLotto);
        first_PrintMadeLotto(buyer);
        System.out.println();
    }

    private static void second_GameProgress() {
        System.out.println(Messages.lottoStartMessages.MAKE_WINNING_NUMBER.getMessage());
        List<Integer> inputWinningNumbers = second_InputWinningNumber();

        System.out.println(Messages.lottoStartMessages.MAKE_BONUS_NUMBER.getMessage());
        int inputBonusNumbers = second_InputBonusNumber();

        second_CreateLottoWinningNumber(inputWinningNumbers, inputBonusNumbers);
    }

    private static void last_GameProgress() {

        System.out.println(Messages.lottoStartMessages.WINNING_STATISTICS.getMessage());
        System.out.println(Messages.lottoStartMessages.BOARDER_LINE.getMessage());
        System.out.println();

        calculateMachine = last_CreateCalculateMachine();

        int[] lottoCalculateResult = calculateMachine.lottoResult();
        printWinningResult = new PrintWinningResult(lottoCalculateResult);
        printWinningResult.printLottoResult();

        double lottoProfitResult = calculateMachine.profitResult(buyer.getMoney(), lottoCalculateResult);
        printWinningResult.printProfitResult(lottoProfitResult);

    }

    //로또 구입 결과 출력 까지
    public static int first_InputProgress() {
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

    private static int first_CalculateMoneyToNum(int money) {
        return money / 1000;
    }

    private static Buyer first_CreateBuyer(int money) {
        return new Buyer(money);
    }

    private static void first_MakeLotto(Buyer buyer, int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            buyer.setLottoCollection(lotto.getLottoSixNum());
        }
    }

    private static void first_PrintMadeLotto(Buyer buyer) {
        int numberOfTickets = first_CalculateMoneyToNum(buyer.getMoney());
        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(buyer.getLottoCollection(i));
        }
    }

    //당첨 번호와 보너스 번호 입력 까지
    public static List<Integer> second_InputWinningNumber() {
        String inputWinningNumbers = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int second_InputBonusNumber() {
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    private static void second_CreateLottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    //로또 당첨 결과 출력 까지
    private static CalculateMachine last_CreateCalculateMachine() {
        return new CalculateMachine(buyer.getAllLottoCollection(), lottoWinningNumber.getWinningNumbers(), lottoWinningNumber.getBonusNumber());
    }

}
