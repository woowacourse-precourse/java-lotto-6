package lotto.io.views;

import java.util.List;
import lotto.collaboration.lottos.Lotto;
import lotto.io.Input;
import lotto.io.Output;

public class LottoGameView {

    public static final String ERROR_HEADER_MESSAGE = "[ERROR] ";

    public int askPurchaseAmount() {
        while (true) {
            Output.consoleLine("구입금액을 입력해 주세요.");
            try {
                return Input.consoleNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    public void showPurchaseLottos(List<Lotto> purchaseLottos) {
        Output.consoleLine();
        Output.consoleLine(purchaseLottos.size() + "개를 구매했습니다.");
        for (Lotto purchaseLotto : purchaseLottos) {
            Output.consoleLine(purchaseLotto);
        }
    }

    public List<Integer> askWinningNumbers() {
        Output.consoleLine();
        Output.consoleLine("당첨 번호를 입력해 주세요");
        while (true) {
            try {
                List<Integer> winningNumbers = Input.consoleNumbers(",");
                validate(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    private void validate(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::occurExceptionIfOutOfRange);
        occurExceptionIfNotSix(winningNumbers);
        occurExceptionIfDuplicated(winningNumbers);
    }

    private void occurExceptionIfOutOfRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다.");
        }
    }

    private void occurExceptionIfNotSix(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 여섯자리 숫자입니다.");
        }
    }

    private void occurExceptionIfDuplicated(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int askBonusNumber() {
        Output.consoleLine();
        Output.consoleLine("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonusNumber = Input.consoleNumber();
                occurExceptionIfOutOfRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

}
