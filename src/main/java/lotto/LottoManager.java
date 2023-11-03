package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManager {
    final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.\n";
    final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.\n";
    final String NORMAL_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    final String SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    final String TOTAL_RATE_REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    final String WINNING_STATISTICS_MESSAGE = "당첨 통계 \n---\n";
    final int REQUIRED_NUMBER_COUNT = 6;
    final int REQUIRED_BONUS_NUMBER_COUNT = 1;
    final int SECOND_GRADE_KEY = 6;
    final int FIRST_MATCH_COUNT = 6;
    final int SECOND_MATCH_COUNT = 5;
    final int FIRST_GRADE_KEY = 7;
    final int MINIMUM_CORRECT_COUNT = 3;
    final int FIRST_GRADE_MONEY = 2000000000;
    final int SECOND_GRADE_MONEY = 30000000;
    final int THIRD_GRADE_MONEY = 1500000;
    final int FORTH_GRADE_MONEY = 50000;
    final int FIFTH_GRADE_MONEY = 5000;
    private Hashtable<Integer, Integer> winningCountHash;
    Hashtable<Integer, Integer> moneyHash;
    private int bonusNumber;
    LottoBuyer lottoBuyer;
    List<Integer> winningNumbers;
    private float totalRateOfRevenue;
    private int totalRevenue;

    public LottoManager(LottoBuyer buyer) {
        totalRateOfRevenue = 0;
        totalRevenue = 0;
        lottoBuyer = buyer;
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

        moneyHash.put(3, FIFTH_GRADE_MONEY);
        moneyHash.put(4, FORTH_GRADE_MONEY);
        moneyHash.put(5, THIRD_GRADE_MONEY);
        moneyHash.put(6, SECOND_GRADE_MONEY);
        moneyHash.put(7, FIRST_GRADE_MONEY);
    }

    public void announceResult() {
        NumberFormat moneyFormat = NumberFormat.getInstance();
        System.out.print(WINNING_STATISTICS_MESSAGE);
        winningCountHash.forEach((key, value) -> {
            if (key == SECOND_GRADE_KEY) {
                System.out.printf(SECOND_MESSAGE, SECOND_MATCH_COUNT, moneyFormat.format(moneyHash.get(key)), value);
            }

            if (key == FIRST_GRADE_KEY) {
                System.out.printf(NORMAL_MESSAGE, FIRST_MATCH_COUNT, moneyFormat.format(moneyHash.get(key)), value);
            }

            if ((key != SECOND_GRADE_KEY) && (key != FIRST_GRADE_KEY)) {
                System.out.printf(NORMAL_MESSAGE, key, moneyFormat.format(moneyHash.get(key)), value);
            }
        });
    }

    public void inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBERS);
        String inputNumber = Console.readLine();
        List<String> numberToStream = Arrays.stream(inputNumber.split(",")).toList();

        setBonusNumber(numberToStream);
    }

    public List<Integer> createLottoNumber() {
        List<Integer> sortedLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
        System.out.print(INPUT_WINNING_NUMBERS);
        String stringWinningNumbers = Console.readLine();
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        setWinningNumbers(listToStream);
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
        for (Lotto lotto : lottoBuyer.getMyLotts()) {
            int matchedCount = lotto.getWinningCount(winningNumbers);
            if(matchedCount >= MINIMUM_CORRECT_COUNT) {
                if (lotto.getNumbers().contains(getBonusNumber()) && (matchedCount == SECOND_MATCH_COUNT)) {
                    winningCountHash.put(SECOND_GRADE_KEY, winningCountHash.get(matchedCount) + 1);
                    continue;
                }

                if (matchedCount == FIRST_MATCH_COUNT) {
                    winningCountHash.put(FIRST_GRADE_KEY, winningCountHash.get(matchedCount) + 1);
                    continue;
                }

                winningCountHash.put(matchedCount, winningCountHash.get(matchedCount) + 1);
            }
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
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberSize(List<String> number) {
        if (number.size() != REQUIRED_BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException();
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
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateIsCorrectRange(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        for (Integer num : convertedNumbers) {
            if ((num < 1) || (num > 45)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberSize(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        if (convertedNumbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<String> stringNumbers) {
        List<Integer> convertedNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        Set<Integer> numberSet = new HashSet<>(convertedNumbers);

        if (numberSet.size() != convertedNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
