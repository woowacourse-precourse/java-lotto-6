package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.model.Lotto;
import lotto.util.Constants;

public class LottoUI {

    public int purchase() {
        boolean isValidInput = false;
        int amount = 0;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                amount = Integer.parseInt(userInput);
                isAmountValid(amount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_VALID_AMOUNT.getMessage());
            }
        }

        return amount;
    }

    private void isAmountValid(int amount) {
        int count = amount / 1_000;
        if (count == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoPurchase(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public int[] winningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                int[] winningNumbers = lottoNumbers(userInput);
                isEnoughLottoNumber(winningNumbers);
                areValidLottoNumber(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_VALID_LOTTO_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int[] lottoNumbers(String input) throws NumberFormatException {
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private void isEnoughLottoNumber(int[] winningNumbers) {
        if (winningNumbers.length != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_LOTTO_LENGTH.getMessage());
        }
    }

    private void areValidLottoNumber(int[] winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : winningNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
            isValidLottoNumber(number);
        }
    }

    private void isValidLottoNumber(int number) {
        if (number < Constants.LOTTO_NUMBER_MIN || number > Constants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }

    public int bonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                int bonusNumber = Integer.parseInt(userInput);
                isValidLottoNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
            }
        }
    }
}
