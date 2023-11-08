package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoReceipt;
import lotto.domain.WinningLotto;
import lotto.service.Input;
import lotto.service.Output;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = validateAmount(Input.getPurchaseAmount());
        validateDivisible(amount);
        List<Lotto> lottoTickets = generateLottoTicket(amount);
        LottoReceipt lottoReceipt = new LottoReceipt(lottoTickets);
        Output.printLottoReceipt(lottoReceipt);

        Lotto lotto = new Lotto(Input.getWinningNumber());
        WinningLotto winningLotto = new WinningLotto(lotto, Input.getBonusNumber());
    }

    public static int validateAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException();
        }
    }

    public static void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Lotto> generateLottoTicket(int amount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int value = amount / LOTTO_PRICE;
        for (int i = 0; i < value; i++) {
             Lotto lotto = new Lotto(generateRandomNumber());
             lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
