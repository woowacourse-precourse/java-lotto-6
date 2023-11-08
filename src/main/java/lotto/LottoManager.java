package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManager {
    private int bonusNumber;
    private int totalRevenue;
    private int FIRST_PLACE = 7;
    private int LAST_PLACE = 3;
    private int LOTTO_NUM_START = 1;
    private int LOTTO_NUM_END = 45;
    private String stringSeperator = ",";
    private float totalRateOfRevenue;
    private Hashtable<Integer, Integer> winningCountTable;
    Hashtable<Integer, Integer> moneyTable;
    LottoBuyer lottoBuyer;
    List<Integer> winningNumbers;
    ErrorMessages errorType;


    public LottoManager(LottoBuyer buyer) {
        totalRateOfRevenue = 0;
        totalRevenue = 0;
        lottoBuyer = buyer;
        winningNumbers = new ArrayList<Integer>();
        winningCountTable = new Hashtable<Integer, Integer>();

        for (int i = LAST_PLACE; i <= FIRST_PLACE; i++) {
            winningCountTable.put(i, 0);
        }

        initMoneyTableMap();
    }

    public void lottoSellingStart() {
        lottoBuyer.inputPurchaseAmount();
        publishLotto();
        inputWinningNumbers();
        inputBonusNumber();
        setWinningResult();
        announceResult();
    }

    public void initMoneyTableMap() {
        moneyTable = new Hashtable<Integer, Integer>();

        moneyTable.put(LottoManagerConsts.THREE.getConst(), LottoManagerConsts.FIFTH_GRADE_MONEY.getConst());
        moneyTable.put(LottoManagerConsts.FOUR.getConst(), LottoManagerConsts.FORTH_GRADE_MONEY.getConst());
        moneyTable.put(LottoManagerConsts.FIVE.getConst(), LottoManagerConsts.THIRD_GRADE_MONEY.getConst());
        moneyTable.put(LottoManagerConsts.FIVE_AND_BONUS.getConst(), LottoManagerConsts.SECOND_GRADE_MONEY.getConst());
        moneyTable.put(LottoManagerConsts.SIX.getConst(), LottoManagerConsts.FIRST_GRADE_MONEY.getConst());
    }

    public void announceResult() {
        System.out.print(LottoManagerMsg.WINNING_STATISTICS_MESSAGE.getDescription());
        winningCountTable.forEach((key, value) -> {
            printWinningDetails(key, value);
            totalRevenue += (moneyTable.get(key) * value);
        });
        totalRateOfRevenue = ((float) totalRevenue /lottoBuyer.getPurchaseAmount()) * 100f;
        System.out.printf(LottoManagerMsg.TOTAL_RATE_REVENUE_MESSAGE.getDescription(), getTotalRateOfRevenue());
    }

    public float getTotalRateOfRevenue() {
        return totalRateOfRevenue;
    }

    public void printWinningDetails(Integer key, Integer value) {
        NumberFormat moneyFormat = NumberFormat.getInstance();

        if (key == LottoManagerConsts.SECOND_GRADE_KEY.getConst()) {
            System.out.printf(LottoManagerMsg.SECOND_MESSAGE.getDescription(),
                LottoManagerConsts.THIRD_MATCH_COUNT.getConst(), moneyFormat.format(moneyTable.get(key)), value);
            return;
        } else if (key == LottoManagerConsts.FIRST_GRADE_KEY.getConst()) {
            System.out.printf(LottoManagerMsg.NORMAL_MESSAGE.getDescription(),
                LottoManagerConsts.FIRST_MATCH_COUNT.getConst(), moneyFormat.format(moneyTable.get(key)), value);
            return;
        }

        System.out.printf(LottoManagerMsg.NORMAL_MESSAGE.getDescription(), key, moneyFormat.format(moneyTable.get(key)), value);
    }

    public void inputWinningNumbers() {
        System.out.print(LottoManagerMsg.INPUT_WINNING_NUMBERS.getDescription());
        try {
            String stringWinningNumbers = Console.readLine();
            List<String> listToStream = Arrays.stream(stringWinningNumbers.split(stringSeperator)).toList();
            setWinningNumbers(listToStream);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            inputWinningNumbers();
        }
    }

    public void setWinningNumbers(List<String> numbers) {
        validateWinningNumbers(numbers);

        winningNumbers = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        System.out.print(LottoManagerMsg.INPUT_BONUS_NUMBERS.getDescription());
        try {
            String inputNumber = Console.readLine();
            List<String> numberToStream = Arrays.stream(inputNumber.split(stringSeperator)).toList();
            setBonusNumber(numberToStream);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            inputBonusNumber();
        }
    }

    public void setBonusNumber(List<String> number) {
        validateBonusNumber(number);
        bonusNumber = number.stream().mapToInt(Integer::parseInt).toArray()[0];
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> sortedLottoNumber = new ArrayList<Integer>();
        sortedLottoNumber.addAll(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUM_START, LOTTO_NUM_END, LottoManagerConsts.REQUIRED_NUMBER_COUNT.getConst()));
        Collections.sort(sortedLottoNumber);

        return sortedLottoNumber;
    }

    public void publishLotto() {
        int publishCount = lottoBuyer.calculatePublishCount();

        for (int i = 0; i < publishCount; i++) {
            lottoBuyer.addMyLottos(new Lotto(createLottoNumber()));
        }

        lottoBuyer.printMyLottos();
    }

    public void setWinningResult() {
        for (Lotto lotto : lottoBuyer.getMyLottos()) {
            int matchedCount = lotto.getWinningCount(winningNumbers);
            if(matchedCount < LottoManagerConsts.MIN_CORRECT_COUNT.getConst()) {
                continue;
            }

            if (isSecondPriceCondition(lotto, matchedCount)) {
                matchedCount = LottoManagerConsts.SECOND_GRADE_KEY.getConst();
            } else if (matchedCount == LottoManagerConsts.FIRST_MATCH_COUNT.getConst()) {
                matchedCount = LottoManagerConsts.FIRST_GRADE_KEY.getConst();
            }

            winningCountTable.put(matchedCount, winningCountTable.get(matchedCount) + 1);
        }
    }

    public boolean isSecondPriceCondition(Lotto lotto, int matchedCount) {
        if (lotto.getNumbers().contains(getBonusNumber())
                && (matchedCount == LottoManagerConsts.THIRD_MATCH_COUNT.getConst())) {
            return true;
        }

        return false;
    }

    public Hashtable<Integer, Integer> getWinningCountTable () {
        return winningCountTable;
    }

    private void validateBonusNumber(List<String> number) {
        validateIsIntegerType(number);
        validateIsCorrectRange(number);
        validateBonusNumberSize(number);
        validateBonusOverlapWinning(number);
    }

    private void validateBonusOverlapWinning(List<String> number) {
        int comparingBonusNumber = number.stream().mapToInt(Integer::parseInt).toArray()[0];
        if (winningNumbers.contains(comparingBonusNumber)) {
            errorType = ErrorMessages.BONUS_INCLUDED_WINNINGS;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }

    private void validateBonusNumberSize(List<String> number) {
        if (number.size() != LottoManagerConsts.REQUIRED_BONUS_NUMBER_COUNT.getConst()) {
            errorType = ErrorMessages.BONUS_INCORRECT_SIZE;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }

    private void validateWinningNumbers(List<String> stringNumbers) {
        validateIsIntegerType(stringNumbers);
        validateIsCorrectRange(stringNumbers);
        validateNumberSize(stringNumbers);
        validateDuplicateNumber(stringNumbers);
    }

    private void validateIsIntegerType(List<String> stringNumbers) {
        for (String value : stringNumbers) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                errorType = ErrorMessages.INPUT_IS_NOT_NUMBER;
                throw new IllegalArgumentException(errorType.getDescription());
            }
        }
    }

    private void validateIsCorrectRange(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        for (Integer num : convertedNumbers) {
            if ((num < LOTTO_NUM_START) || (num > LOTTO_NUM_END)) {
                errorType = ErrorMessages.NUMBER_IS_INCORRECT_RANGE;
                throw new IllegalArgumentException(errorType.getDescription());
            }
        }
    }

    private void validateNumberSize(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        if (convertedNumbers.size() != LottoManagerConsts.REQUIRED_NUMBER_COUNT.getConst()) {
            errorType = ErrorMessages.NUMBER_INCORRECT_SIZE;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }

    private void validateDuplicateNumber(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        Set<Integer> numberSet = new HashSet<>(convertedNumbers);

        if (numberSet.size() != convertedNumbers.size()) {
            errorType = ErrorMessages.NUMBER_DUPLICATED;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }
}
