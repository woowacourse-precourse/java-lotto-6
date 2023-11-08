package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static final int PURCHASE_AMOUNT_UNIT = 1000;
    public static final int NUM_OF_LOTTO = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int FIRST_RANKING = 6;
    public static final int SECOND_RANKING = 15;
    public static final int THIRD_RANKING = 5;
    public static final int FOURTH_RANKING = 4;
    public static final int FIFTH_RANKING = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playLotto();
    }

    public static void playLotto() {
        printInputPurchaseAmountMessage();
        int purchaseAmount = inputPurchaseAmount();
        printPurchaseNumOfLotto(purchaseAmount);

        List<Lotto> lotties = createLotties(purchaseAmount);
        printCreatedLotties(lotties);

        printInputUserLottoNumbersMessage();
        List<Integer> userLottoNumbers = inputLottoNumbers();

        printInputBonusNumberMessage();
        int bonusNumber = inputBonusNumber(userLottoNumbers);

        List<Integer> lottoMatchCounts = getLottoMatchCounts(lotties, userLottoNumbers, bonusNumber);
        printStatisticsMessage();
        List<Integer> numOfRankings = getNumOfRankings(lottoMatchCounts);
        printLottoWinResult(numOfRankings);
        printYieldRate(purchaseAmount, numOfRankings);
    }

    public static void printStatisticsMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printInputBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printInputUserLottoNumbersMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printCreatedLotties(final List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            lotto.printLottoNumbers();
        }
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseNumOfLotto(final int purchaseAmount) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", (int)(purchaseAmount/PURCHASE_AMOUNT_UNIT)));
    }

    public static void printYieldRate(final int purchaseAmount, final List<Integer> lottoMatchCounts) {
        int totalPrize = getTotalPrize(lottoMatchCounts);

        float yieldRate = ((float) totalPrize / purchaseAmount) * 100;

        System.out.println(String.format("총 수익률은 %.1f", yieldRate) + "%입니다.");
    }

    public static int getTotalPrize(final List<Integer> lottoMatchCounts) {
        int totalPrize = 0;
        for (int i = 0; i < lottoMatchCounts.size(); i++) {
            totalPrize += Ranking.getPrizeMoney(i) * lottoMatchCounts.get(i);
        }

        return totalPrize;
    }

    public static void printLottoWinResult(final List<Integer> numOfRankings) {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", numOfRankings.get(4)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", numOfRankings.get(3)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", numOfRankings.get(2)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", numOfRankings.get(1)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", numOfRankings.get(0)));
    }

    public static List<Integer> getNumOfRankings(final List<Integer> lottoMatchCounts) {
        Integer[] numOfRankings = { 0, 0, 0, 0, 0 }; // 차례대로 1등, 2등, 3등, 4등, 5등 개수

        for (Integer lottoMatchCount : lottoMatchCounts) {
            isFirstRanking(lottoMatchCount, numOfRankings);
            isSecondRanking(lottoMatchCount, numOfRankings);
            isThirdRanking(lottoMatchCount, numOfRankings);
            isFourthRanking(lottoMatchCount, numOfRankings);
            isFifthRanking(lottoMatchCount, numOfRankings);
        }
        return List.of(numOfRankings);
    }

    private static void isFirstRanking(final Integer lottoMatchCount, final Integer[] numOfRankings) {
        if (lottoMatchCount == FIRST_RANKING) {
            numOfRankings[0] += 1;
        }
    }

    private static void isSecondRanking(final Integer lottoMatchCount, final Integer[] numOfRankings) {
        if (lottoMatchCount == SECOND_RANKING) {
            numOfRankings[1] += 1;
        }
    }

    private static void isThirdRanking(final Integer lottoMatchCount, final Integer[] numOfRankings) {
        if (lottoMatchCount == THIRD_RANKING) {
            numOfRankings[2] += 1;
        }
    }

    private static void isFourthRanking(final Integer lottoMatchCount, final Integer[] numOfRankings) {
        if (lottoMatchCount == FOURTH_RANKING) {
            numOfRankings[3] += 1;
        }
    }

    private static void isFifthRanking(final Integer lottoMatchCount, final Integer[] numOfRankings) {
        if (lottoMatchCount == FIFTH_RANKING) {
            numOfRankings[4] += 1;
        }
    }

    public static List<Integer> getLottoMatchCounts(
            final List<Lotto> lotties,
            final List<Integer> userLottoNumbers,
            final int bonusNumber
    ) {
        List<Integer> lottoMatchCounts = new ArrayList<>();

        for (Lotto lotto : lotties) {
            lottoMatchCounts.add(lotto.compareWithUserNumbers(userLottoNumbers, bonusNumber));
        }

        return lottoMatchCounts;
    }

    public static List<Lotto> createLotties(final int purchaseAmount) {
        int numOfLotto = (int)(purchaseAmount / PURCHASE_AMOUNT_UNIT);

        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < numOfLotto; i++) {
            lotties.add(new Lotto(getLottoNumbers()));
        }

        return lotties;
    }

    private static List<Integer> getLottoNumbers() {
        return sortLottoNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private static List<Integer> sortLottoNumbers(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }

    public static int inputPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();

        while (!validateInputPurchaseAmount(inputPurchaseAmount)) {
            inputPurchaseAmount = Console.readLine();
        }

        return Integer.parseInt(inputPurchaseAmount);
    }

    public static boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        if (!validateInputPurchaseAmountIsNumber(inputPurchaseAmount)
                || !validateDivideToThousand(inputPurchaseAmount)) {
            wrongPurchaseAmountInputThrowIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateInputPurchaseAmountIsNumber(final String inputPurchaseAmount) {
        return isNumber(inputPurchaseAmount);
    }

    public static boolean validateDivideToThousand(final String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            return false;
        }

        return true;
    }

    public static List<Integer> inputLottoNumbers() {
        List<String> lottoNumbers = List.of(Console.readLine().split(","));

        while (!validateInputLottoNumbers(lottoNumbers)) {
            lottoNumbers = List.of(Console.readLine().split(","));
        }

        return stringListToIntegerList(lottoNumbers);
    }

    public static boolean validateInputLottoNumbers(final List<String> inputLottoNumbers) {
        if (!validateNumOfLotto(inputLottoNumbers)
                || !validateEachLottoIsNumber(inputLottoNumbers)
                || !validateEachLottoIsInBound(inputLottoNumbers)
                || !validateDuplicateLottoNumbers(inputLottoNumbers)) {
            wrongInputUserNumbersThrowIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateNumOfLotto(final List<String> inputLottoNumbers) {
        if (inputLottoNumbers.size() != NUM_OF_LOTTO) {
            return false;
        }

        return true;
    }

    public static boolean validateEachLottoIsNumber(final List<String> inputLottoNumbers) {
        for (String inputLottoNumber : inputLottoNumbers) {
            if (!isNumber(inputLottoNumber)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateEachLottoIsInBound(final List<String> inputLottoNumbers) {
        for (String inputLottoNumber : inputLottoNumbers) {
            int lottoNumber = Integer.parseInt(inputLottoNumber);
            if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateDuplicateLottoNumbers(final List<String> inputLottoNumbers) {
        int inputLottoNumbersSize = inputLottoNumbers.size();
        int distinctInputLottoNumbersSize = inputLottoNumbers
                .stream()
                .distinct()
                .toList().size();

        return inputLottoNumbersSize == distinctInputLottoNumbersSize;
    }

    public static List<Integer> stringListToIntegerList(final List<String> lottoNumbers) {
        return lottoNumbers
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean isNumber(final String inputPurchaseAmount) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputPurchaseAmount, pos);
        return inputPurchaseAmount.length() == pos.getIndex();
    }

    public static int inputBonusNumber(final List<Integer> lottoNumbers) {
        String inputBonusNumber = Console.readLine();

        while (!validateBonusNumber(lottoNumbers, inputBonusNumber)) {
            inputBonusNumber = Console.readLine();
        }

        return Integer.parseInt(inputBonusNumber);
    }

    public static boolean validateBonusNumber(final List<Integer> lottoNumbers, final String inputBonusNumber) {
        if (!validateInputBonusNumberIsNumber(inputBonusNumber)
                || !validateInputBonusNumberIsInBound(inputBonusNumber)
                || !validateInputBonusNumberDuplicateWithLottoNumbers(lottoNumbers, inputBonusNumber)) {
            wrongInputBonusNumberThrowIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateInputBonusNumberIsNumber(final String inputBonusNumber) {
        return isNumber(inputBonusNumber);
    }

    public static boolean validateInputBonusNumberIsInBound(final String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            return false;
        }

        return true;
    }

    public static boolean validateInputBonusNumberDuplicateWithLottoNumbers(
            final List<Integer> lottoNumbers,
            final String inputBonusNumber
    ) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber) {
                return false;
            }
        }

        return true;
    }

    public static void wrongPurchaseAmountInputThrowIllegalArgumentException() {
        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.");
        }
    }

    public static void wrongInputUserNumbersThrowIllegalArgumentException() {
        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void wrongInputBonusNumberThrowIllegalArgumentException() {
        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호와 겹치지 않는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
