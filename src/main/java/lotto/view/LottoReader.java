package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Payment;

import java.util.Arrays;
import java.util.List;

public class LottoReader {
    public  <T> T read(ReadLogic<T> readLogic) {
        while (true) {
            try {
                return readLogic.execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer readBonusNumber(List<Integer> winningNumbers) {
        return read(() -> {
            String inputBonusNumber = Console.readLine();
            LottoReaderValidator.validateBonusNumber(inputBonusNumber);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoReaderValidator.validateDuplicationWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

            return bonusNumber;
        });
    }

    public Payment readPayment() {
        return read(() -> {
            String inputMoney = Console.readLine();
            LottoReaderValidator.validateMoney(inputMoney);
            return new Payment(Integer.parseInt(inputMoney));
        });
    }

    public List<Integer> readWinningNumbers() {
        return read(() -> {
            String inputWinningNumbers = Console.readLine();
            LottoReaderValidator.validateWinningNumbers(inputWinningNumbers);
            return Arrays.stream(inputWinningNumbers.split(",")).map(Integer::parseInt).toList();
        });
    }
}
