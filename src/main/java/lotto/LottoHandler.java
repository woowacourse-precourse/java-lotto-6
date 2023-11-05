package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoHandler {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoTicketCount(String receivedPurchasePrice) {
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(receivedPurchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + "원 단위로만 입력해 주세요.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Lotto> issueLottoNumbers(int lottoTicket) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicket; i++) {
            lottos.add(pickNumbersOrderByAsc());
        }

        OutputHandler.printLottos(lottos);
        return lottos;
    }

    private Lotto pickNumbersOrderByAsc() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER,
                LOTTO_LAST_NUMBER,
                LOTTO_NUMBER_COUNT
        );
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    public int lottoCountForPurchasePrice() {
        int lottoTicket = 0;
        boolean validPrice = false;

        while (!validPrice) {
            try {
                OutputHandler.printMessage("구입금액을 입력해 주세요.");
                lottoTicket = calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        OutputHandler.printLineBreakMessage(lottoTicket + "개를 구매했습니다.");
        return lottoTicket;
    }
}
