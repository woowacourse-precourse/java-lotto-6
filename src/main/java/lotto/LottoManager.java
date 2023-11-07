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
    private Hashtable<Integer, Integer> winningCountHash;
    private float totalRateOfRevenue;
    private int totalRevenue;
    private LottoManagerConsts constType;
    Hashtable<Integer, Integer> moneyHash;
    LottoBuyer lottoBuyer;
    List<Integer> winningNumbers;
    ErrorMessages errorType;


    public LottoManager(LottoBuyer buyer) {
        totalRateOfRevenue = 0;
        totalRevenue = 0;
        lottoBuyer = buyer;
        winningNumbers = new ArrayList<Integer>();
        winningCountHash = new Hashtable<Integer, Integer>();

        for (int i = 3; i <= 7; i++) {
            winningCountHash.put(i, 0);
        }

        initMoneyHashMap();
    }

    public void lottoSellingStart() {
        lottoBuyer.inputPurchaseAmount();
        publishLotto();
        inputWinningNumbers();
        inputBonusNumber();
        setWinningResult();
        announceResult();
    }

    public void initMoneyHashMap() {
        moneyHash = new Hashtable<Integer, Integer>();

        moneyHash.put(3, LottoManagerConsts.FIFTH_GRADE_MONEY.getConst());
        moneyHash.put(4, LottoManagerConsts.FORTH_GRADE_MONEY.getConst());
        moneyHash.put(5, LottoManagerConsts.THIRD_GRADE_MONEY.getConst());
        moneyHash.put(6, LottoManagerConsts.SECOND_GRADE_MONEY.getConst());
        moneyHash.put(7, LottoManagerConsts.FIRST_GRADE_MONEY.getConst());
    }

    public void announceResult() {
        System.out.print(LottoManagerMsg.WINNING_STATISTICS_MESSAGE.getDescription());
        winningCountHash.forEach((key, value) -> {
            printWinningDetails(key, value);
            totalRevenue += (moneyHash.get(key) * value);
        });
        totalRateOfRevenue = ((float) totalRevenue /lottoBuyer.getPurchaseAmount()) * 100f;
        System.out.printf(LottoManagerMsg.TOTAL_RATE_REVENUE_MESSAGE.getDescription(), totalRateOfRevenue);
    }

    public float getTotalRateOfRevenue() {
        return totalRateOfRevenue;
    }

    public void printWinningDetails(Integer key, Integer value) {
        NumberFormat moneyFormat = NumberFormat.getInstance();

        if (key == LottoManagerConsts.SECOND_GRADE_KEY.getConst()) {
            System.out.printf(LottoManagerMsg.SECOND_MESSAGE.getDescription(),
                LottoManagerConsts.THIRD_MATCH_COUNT.getConst(), moneyFormat.format(moneyHash.get(key)), value);
            return;
        } else if (key == LottoManagerConsts.FIRST_GRADE_KEY.getConst()) {
            System.out.printf(LottoManagerMsg.NORMAL_MESSAGE.getDescription(),
                LottoManagerConsts.FIRST_MATCH_COUNT.getConst(), moneyFormat.format(moneyHash.get(key)), value);
            return;
        }

        System.out.printf(LottoManagerMsg.NORMAL_MESSAGE.getDescription(), key, moneyFormat.format(moneyHash.get(key)), value);
    }

    public void inputBonusNumber() {
        System.out.print(LottoManagerMsg.INPUT_BONUS_NUMBERS.getDescription());
        try {
            String inputNumber = Console.readLine();
            List<String> numberToStream = Arrays.stream(inputNumber.split(",")).toList();
            setBonusNumber(numberToStream);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            inputBonusNumber();
        }
    }

    public List<Integer> createLottoNumber() {
        List<Integer> sortedLottoNumber = new ArrayList<Integer>();
        sortedLottoNumber.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

    public void inputWinningNumbers() {
        System.out.print(LottoManagerMsg.INPUT_WINNING_NUMBERS.getDescription());
        try {
            String stringWinningNumbers = Console.readLine();
            List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();
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

    public void setBonusNumber(List<String> number) {
        validateBonusNumber(number);

        bonusNumber = number.stream().mapToInt(Integer::parseInt).toArray()[0];
    }

    public void setWinningResult() {
        for (Lotto lotto : lottoBuyer.getMyLottos()) {
            int matchedCount = lotto.getWinningCount(winningNumbers);
            if(matchedCount < LottoManagerConsts.MIN_CORRECT_COUNT.getConst()) {
                continue;
            }

            if (lotto.getNumbers().contains(getBonusNumber()) && (matchedCount == LottoManagerConsts.THIRD_MATCH_COUNT.getConst())) {
                matchedCount = LottoManagerConsts.SECOND_GRADE_KEY.getConst();
            } else if (matchedCount == LottoManagerConsts.FIRST_MATCH_COUNT.getConst()) {
                matchedCount = LottoManagerConsts.FIRST_GRADE_KEY.getConst();
            }

            winningCountHash.put(matchedCount, winningCountHash.get(matchedCount) + 1);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Hashtable<Integer, Integer> getWinningCountHash () {
        return winningCountHash;
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
            if ((num < 1) || (num > 45)) {
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
