package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.lottocompany.Lotto;

public class ConsoleInput implements Input {

    @Override
    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자를 입력해주세요.");
        }
    }

    @Override
    public Lotto inputWinningNumbers() {
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(number -> Integer.parseInt(number.strip()))
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자를 입력해주세요.");
        }
        return new Lotto(winningNumbers);
    }

    @Override
    public int inputBonusNumber() {
        try{
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }
}
