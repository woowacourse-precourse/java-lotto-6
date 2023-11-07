package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.ErrorCheck.*;

public class Application {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    public static void main(String[] args) {
        LottoInit lottoInit = ReceiveInitial();
        List<Lotto> allOfLottoPapers = makeAllLottoPaper(lottoInit.numberOfLotto);
        WinningNumberSet winningNumberSets = makeWinningNumber();
        PrintResultSet resultSets = calculateResult(winningNumberSets, allOfLottoPapers);
        printResult(resultSets, lottoInit);
    }

    public static LottoInit ReceiveInitial() {
        LottoInit lottoInit = null;
        try {
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            int numberOfLotto = purchaseAmount / 1000;

            lottoInit = new LottoInit(purchaseAmount, numberOfLotto);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return ReceiveInitial();
        }

        System.out.println("\n" + lottoInit.numberOfLotto + "개를 구매했습니다.");
        return lottoInit;
    }

    private static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE);
    }

    private static List<Lotto> makeAllLottoPaper(int numberOfLotto) {
        List<Lotto> allOfLottoPapers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lottoPaper = new Lotto(makeRandomNumbers());
            lottoPaper.printLottoPaper(lottoPaper);
            allOfLottoPapers.add(lottoPaper);
        }
        return allOfLottoPapers;
    }

    public static WinningNumberSet makeWinningNumber() {
        String[] winningNumbers;
        int bonusNumber;
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningLotteryNumber = Console.readLine();
            validateInputDataType(winningLotteryNumber);
            winningNumbers = winningLotteryNumber.split(",");
            validateWinningNumbersDataType(winningNumbers);
            validateWinningNumbersSize(winningNumbers);
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNum(bonusNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return makeWinningNumber();
        }
        return new WinningNumberSet(winningNumbers, bonusNumber);
    }





    public static PrintResultSet calculateResult(WinningNumberSet winningNumberSets, List<Lotto> allOfLottoPapers) {
        PrintResultSet printResultSet = new PrintResultSet();

        for (int checkLottoNum = 0; checkLottoNum < allOfLottoPapers.size(); checkLottoNum++) {
            Lotto lotto = allOfLottoPapers.get(checkLottoNum);
            Score score = lotto.compareWinningNumbers(winningNumberSets);
            printResultSet.checkMatchThree(score.getCountMatch());
            printResultSet.checkMatchFour(score.getCountMatch());
            printResultSet.checkMatchFive(score);
            printResultSet.checkMatchFivePlus(score);
            printResultSet.checkMatchSix(score.getCountMatch());
        }

        return printResultSet;
    }

    public static void printResult(PrintResultSet printResultSet, LottoInit lottoInit) {
        double earningRate = (double) printResultSet.getProfitSum() * 100 / lottoInit.purchaseAmount;
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + printResultSet.getPrintThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + printResultSet.getPrintFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + printResultSet.getPrintFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + printResultSet.getPrintFivePlusBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + printResultSet.getPrintSix() + "개");
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", earningRate));
        System.out.print("%입니다.");
    }
}