package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.util.InputDataException;

public class LottoView {
    public LottoView() {
    }

    public String paymentInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = Console.readLine().trim();
        InputDataException.validatePaymentInput(payment);
        return payment;
    }

    public void printMyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public String winningLottoInput() {
        System.out.println("당첨번호를 입력해 주세요.");
        String numbers = Console.readLine().trim();
        InputDataException.validateWinningLottoNumbersInput(numbers);
        return numbers;
    }

    public String bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine().trim();
        InputDataException.validateBonusNumberInput(bonusNumber);
        return bonusNumber;
    }

    public void winningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoResult);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
