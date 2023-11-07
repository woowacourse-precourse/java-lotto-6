package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.ErrorCheck.*;
import static lotto.ErrorCheck.validateBonusNum;

public class RunnerLotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    public static void run(LottoInit lottoInit) {
        List<Lotto> allOfLottoPapers = makeAllLottoPaper(lottoInit.numberOfLotto);
        WinningNumberSet winningNumberSets = makeWinningNumber();
        PrinterResultSet resultSets = calculateResult(winningNumberSets, allOfLottoPapers);
        printResult(resultSets, lottoInit);
    }

    public static List<Lotto> makeAllLottoPaper(int numberOfLotto) {
        List<Lotto> allOfLottoPapers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lottoPaper = new Lotto(makeRandomNumbers());
            Collections.sort(lottoPaper.getLottoNumbers());
            lottoPaper.printLottoPaper(lottoPaper);
            allOfLottoPapers.add(lottoPaper);
        }
        return allOfLottoPapers;
    }

    private static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE);
    }



    public static WinningNumberSet makeWinningNumber() {
        String[] winningNumbers;
        int bonusNumber;
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningLotteryNumber = Console.readLine();
            winningNumbers = winningLotteryNumber.split(",");
            validateAllOfWinningNumberError(winningLotteryNumber,winningNumbers);
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNum(bonusNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return makeWinningNumber();
        }
        return new WinningNumberSet(winningNumbers, bonusNumber);
    }

    public static void validateAllOfWinningNumberError(String winningLotteryNumber,String[] winningNumbers){
        validateInputDataType(winningLotteryNumber);
        validateWinningNumbersDataType(winningNumbers);
        validateWinningNumbersSize(winningNumbers);
    }

    public static PrinterResultSet calculateResult(WinningNumberSet winningNumberSets, List<Lotto> allOfLottoPapers) {
        PrinterResultSet printerResultSet = new PrinterResultSet();

        for (int checkLottoNum = 0; checkLottoNum < allOfLottoPapers.size(); checkLottoNum++) {
            Lotto lotto = allOfLottoPapers.get(checkLottoNum);
            Score score = lotto.compareWinningNumbers(winningNumberSets);
            printerResultSet.checkMatchThree(score.getCountMatch());
            printerResultSet.checkMatchFour(score.getCountMatch());
            printerResultSet.checkMatchFive(score);
            printerResultSet.checkMatchFivePlus(score);
            printerResultSet.checkMatchSix(score.getCountMatch());
        }
        return printerResultSet;
    }

    public static void printResult(PrinterResultSet printerResultSet, LottoInit lottoInit) {
        double earningRate = (double) printerResultSet.getProfitSum() * 100 / lottoInit.purchaseAmount;
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + printerResultSet.getPrintThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + printerResultSet.getPrintFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + printerResultSet.getPrintFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + printerResultSet.getPrintFivePlusBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + printerResultSet.getPrintSix() + "개");
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", earningRate));
        System.out.print("%입니다.");
    }
}
