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
    final int REQUIRED_NUMBER_COUNT = 6;
    LottoBuyer lottoBuyer;
    List<Integer> winningNumbers;


    public LottoManager(LottoBuyer buyer) {
        lottoBuyer = buyer;
    }

    public void lottoSellingStart() {
        lottoBuyer.inputPurchaseAmount();
        publishLotto();
        inputWinningNumbers();
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
