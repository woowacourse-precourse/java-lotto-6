package lotto;

import static lotto.message.Message.BONUS_NUMBER_REQUEST;
import static lotto.message.Message.DIVIDING_LINE;
import static lotto.message.Message.LINE_BREAK;
import static lotto.message.Message.PAYMENT_COMPLETE;
import static lotto.message.Message.PAYMENT_REQUEST;
import static lotto.message.Message.WINNING_NUMBER_REQUEST;
import static lotto.message.Message.WINNING_STATISTICS_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {

        int payment = receiveMoney();

        OutputView.print(LINE_BREAK.getMessage());
        int countOfLotto = payment / 1000;
        OutputView.print(String.valueOf(countOfLotto));
        OutputView.print(PAYMENT_COMPLETE.getMessage());
        OutputView.print(LINE_BREAK.getMessage());

        List<Lotto> lottoTicket = new ArrayList<>();
        for (int count = 0; count < countOfLotto; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto attempt = new Lotto(numbers);
            lottoTicket.add(attempt);
        }

        for (Lotto lotto : lottoTicket) {
            lotto.sort();
            OutputView.print(lotto.toString());
            OutputView.print(LINE_BREAK.getMessage());
        }

        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(WINNING_NUMBER_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String input = InputView.read();
        InputValidator.validateInputRequirement(input);

        List<Integer> winingNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateRange(winingNumbers);
        validateSize(winingNumbers);
        validateDuplicate(winingNumbers);

        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(BONUS_NUMBER_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        input = InputView.read();
        InputValidator.validateNumber(input);
        validateRangeOne(Integer.parseInt(input));
        validateBonusDuplication(Integer.parseInt(input), winingNumbers);
        int bonus = Integer.parseInt(input);

        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(WINNING_STATISTICS_RESULT.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        for (int i = 0; i < 3; i++) {
            OutputView.print(DIVIDING_LINE.getMessage());
        }
        OutputView.print(LINE_BREAK.getMessage());


    }

    private int receiveMoney() {
        OutputView.print(PAYMENT_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String money = InputView.read();
        InputValidator.validateNumber(money);
        validateMultiple(money);
        return Integer.parseInt(money);
    }


    public void validateMultiple(String input) {
        if (Stream.of(input)
                .map(Integer::parseInt)
                .anyMatch(number -> number % 1000 != 0)) {
            throw new IllegalArgumentException("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
        }
    }


    public void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력하세요");
            }
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 6개를 입력하지 않았습나다.");
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void validateRangeOne(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력하세요");
        }
    }

    public void validateBonusDuplication(int num, List<Integer> numbers) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다.");
        }
    }
}


class Message {

}
