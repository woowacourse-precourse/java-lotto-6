package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Validator;
import lotto.domain.WinnerLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static Money inputMoney() {
        System.out.println("구입금액을 입력 해주세요.");
        return Money.from(Console.readLine());
    }

    public static WinnerLotto inputWinnerLotto() {
        Lotto inputLotto = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();
        return WinnerLotto.of(inputLotto, bonusNumber);
    }

    private static Lotto inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumbers = Validator.validationNull(Console.readLine());
        List<Integer> numbers = Arrays.stream(inputLottoNumbers.split(","))
                .map(Validator::validationNumber)
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Validator.validationNull(Console.readLine());
        return Validator.validationNumber(inputBonusNumber);
    }
}
