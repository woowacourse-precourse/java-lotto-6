package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManager {
    final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.\n";
    final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.\n";
    final int REQUIRED_NUMBER_COUNT = 6;
    final int REQUIRED_BONUS_NUMBER_COUNT = 1;
    LottoBuyer lottoBuyer;
    List<Integer> winningNumbers;
    private int bonusNumber;


    public LottoManager(LottoBuyer buyer) {
        lottoBuyer = buyer;
    }

    public void lottoSellingStart() {
        lottoBuyer.inputPurchaseAmount();
        publishLotto();
        inputWinningNumbers();
        inputBonusNumber();
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

    public int getBonusNumber() {
        return bonusNumber;
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
        try {
            Integer.parseInt(String.join("", stringNumbers));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
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
