package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;

public class LottoController {

    private static int price;
    private static List<Integer> winNumber;
    private static IOController ioController;
    private static LottoGenerator lottoGenerator;
    private static List<Lotto> lottoList;
    private static int[] winLottoCount;
    private static int bonusNumber;
    private static final long[] prize = {2000000000, 30000000, 1500000, 50000, 5000};
    private static double profitPercentage;


    public LottoController() {
        init();
        input();
        compareTotalLottoList();
        calcuratePrizeMoney();
        printResult();

    }

    private void printResult() {
        System.out.println("당첨 통계\n---");

        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5,000원) - " + winLottoCount[5] + "개\n");
        sb.append("4개 일치 (50,000원) - " + winLottoCount[4] + "개\n");
        sb.append("5개 일치 (1,500,000원) - " + winLottoCount[3] + "개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winLottoCount[2] + "개\n");
        sb.append(" 6개 일치 (2,000,000,000원) - " + winLottoCount[1] + "개\n");
        sb.append("총 수익률은 " + formatToTwoDecimalPlaces() + "%입니다.");

        System.out.println(sb.toString());
    }

    private String formatToTwoDecimalPlaces() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(profitPercentage);
    }
    private void calcuratePrizeMoney() {

        int totalPrizeMoney = 0;

        System.out.println(Arrays.toString(winLottoCount));
        for (int i = 0; i < 5; i++) {
            totalPrizeMoney += prize[i] * winLottoCount[i + 1];
        }

        calculateProfitPercentage(totalPrizeMoney);

    }

    private void calculateProfitPercentage(int totalPrizeMoney) {
        profitPercentage = ((double) (totalPrizeMoney - price) / price) * 100;

    }

    private void putCountOfPrize(int matchedNumbers, Lotto lotto) {

        if (matchedNumbers == 5) {
            if (!hasBonusNumber(lotto)) {
                winLottoCount[3]++;
                return;
            }
        }
        if (matchedNumbers == 6) {
            winLottoCount[1]++;
            return;
        }
        if (matchedNumbers <= 4 && matchedNumbers >= 3) {
            winLottoCount[8 - matchedNumbers]++;
        }
    }

    private boolean hasBonusNumber(Lotto lotto) {
        for (int a : lotto.getNumbers()) {
            if (a == bonusNumber) {
                winLottoCount[2]++;
                return true;
            }
        }
        return false;
    }

    private void input() {
        price = ioController.inputPrice();
        generateLottoNumber();
        winNumber = ioController.inputWinNumber();
        bonusNumber = ioController.inputBonusNumber();
    }

    private void compareTotalLottoList() {
        for (Lotto lotto : lottoList) {
            compareLotto(lotto);
        }

        System.out.println("winLottoCount:" + winLottoCount);
    }

    private void compareLotto(Lotto lotto) {
        int matchedNumbers = 0;
        for (int userNumber : lotto.getNumbers()) {
            if (winNumber.contains(userNumber)) {
                matchedNumbers++;
            }
        }
        putCountOfPrize(matchedNumbers, lotto);

    }

    private void generateLottoNumber() {
        int CountOfLotto = price / 1000;

        System.out.println("\n" + CountOfLotto + InstructionMessage.PRINT_LOTTO_COUNT.getMessageText());

        for (int makeLotto = 1; makeLotto <= CountOfLotto; makeLotto++) {
            lottoList.add(new Lotto(makeRandomNumber()));
        }

        ioController.printUserLottoNumbers(lottoList);

    }

    public List<Integer> makeRandomNumber() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public static void init() {
        lottoList = new LinkedList<>();
        lottoGenerator = new LottoGenerator();
        ioController = new IOController();
        winLottoCount = new int[6];

    }
}
