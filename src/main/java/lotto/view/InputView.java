package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static Money inputMoney() {
        System.out.println("구입금액을 입력 해주세요.");
        return Money.from(Console.readLine());
    }

    public static Lotto inputWinnerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumbers = Validator.validationNull(Console.readLine());
        List<Integer> numbers = Arrays.stream(inputLottoNumbers.split(","))
                .map(Validator::validationNumber)
                .collect(Collectors.toList());
        Lotto winnerLotto = new Lotto(numbers);
        Validator.validationDuplicationLottoNumber(winnerLotto);
        return winnerLotto;
    }

    public static int inputBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Validator.validationNumber(Validator.validationNull(Console.readLine()));
        Validator.validationDuplicationLottoNumber(lotto, bonusNumber);
        return bonusNumber;
    }
}
