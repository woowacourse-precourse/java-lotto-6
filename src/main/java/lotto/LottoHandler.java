package lotto;

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

    public List<List<Integer>> issueLottoNumbers(int lottoTicket) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoTicket; i++) {
            lottoNumbers.add(pickNumbersOrderByAsc());
        }
        return lottoNumbers;
    }

    private List<Integer> pickNumbersOrderByAsc() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_NUMBER_COUNT
        );
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
