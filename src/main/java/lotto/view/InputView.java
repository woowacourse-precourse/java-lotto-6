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
        while(true) {
            try {
                return Money.from(Console.readLine());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinnerLotto inputWinnerLotto() {
        Lotto lotto = inputLottoNumbers();
        int bonusNumber = inputBonusNumber(lotto);
        return WinnerLotto.of(lotto, bonusNumber);
    }

    private static Lotto inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true) {
            try {
                String inputLottoNumbers = Validator.validationNull(Console.readLine());
                List<Integer> numbers = Arrays.stream(inputLottoNumbers.split(","))
                        .map(Validator::validationNumber)
                        .sorted()
                        .collect(Collectors.toList());
                return new Lotto(numbers);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true) {
            try {
                int bonusNumber = Validator.validationNumber(Validator.validationNull(Console.readLine()));
                Validator.validationBonusNumber(bonusNumber, lotto);
                return bonusNumber;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
