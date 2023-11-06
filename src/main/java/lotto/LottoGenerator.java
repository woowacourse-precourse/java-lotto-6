package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int TICKET_PRICE = 1000;

    public int getPurchaseAmount() {
        System.out.print("구입 금액을 입력해 주세요: ");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input);
            if (!isValidAmount(amount)) {
                System.out.println("[ERROR] 입력한 금액은 1000으로 나누어 떨어져야 합니다.");
                return getPurchaseAmount();
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            return getPurchaseAmount();
        }
    }


    private boolean isValidAmount(int amount) {
        return amount % TICKET_PRICE == 0;
    }

    public List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / TICKET_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}