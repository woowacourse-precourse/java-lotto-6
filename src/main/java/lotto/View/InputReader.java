package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;
import lotto.Domain.Money;

public class InputReader {

    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    public Money inputMoney() {
        System.out.println(INPUT_PRICE_MESSAGE);
        while (true) {
            try {
                return new Money(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS_MESSAGE);

        while (true) {
            try {
                List<Integer> numbers = getNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String inputNumbers = Console.readLine();

        for (String number : inputNumbers.split(LOTTO_NUMBER_DELIMITER)) {
            LottoNumber lottoNumber = new LottoNumber(number);
            numbers.add(lottoNumber.getLottoNumber());
        }

        return numbers;
    }

    public LottoNumber inputBonusNumber(Lotto lotto) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        while (true) {
            try {
                LottoNumber bonusNumber = new LottoNumber(Console.readLine());
                lotto.validateDuplicateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
