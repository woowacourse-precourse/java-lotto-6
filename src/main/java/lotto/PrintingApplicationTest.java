package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.RunnerLotto.*;

public class PrintingApplicationTest {
    static List<Lotto> allOfTestLottoPapers = new ArrayList<>();
    static Lotto fixedLotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
    static Lotto fixedLotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
    static Lotto fixedLotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));
    static Lotto fixedLotto4 = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42));
    static Lotto fixedLotto5 = new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45));
    static Lotto fixedLotto6 = new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43));
    static Lotto fixedLotto7 = new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45));
    static Lotto fixedLotto8 = new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45));
    public static void printApplicationTest(){
        LottoInit testLottoInit=new LottoInit(8000,8);
        addFixedLottoToAllTestLottoPaper();
        printAllTestLottoPaper(allOfTestLottoPapers);
        WinningNumberSet winningNumberSets = makeWinningNumber();
        PrinterResultSet resultSets = calculateResult(winningNumberSets, allOfTestLottoPapers);
        printResult(resultSets, testLottoInit);
    }
    public static void printAllTestLottoPaper(List<Lotto>allOfTestLottoPapers) {
        for (Lotto lotto: allOfTestLottoPapers){
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static List<Lotto> addFixedLottoToAllTestLottoPaper(){
        allOfTestLottoPapers.add(fixedLotto1);
        allOfTestLottoPapers.add(fixedLotto2);
        allOfTestLottoPapers.add(fixedLotto3);
        allOfTestLottoPapers.add(fixedLotto4);
        allOfTestLottoPapers.add(fixedLotto5);
        allOfTestLottoPapers.add(fixedLotto6);
        allOfTestLottoPapers.add(fixedLotto7);
        allOfTestLottoPapers.add(fixedLotto8);
        return allOfTestLottoPapers;
    }
}


