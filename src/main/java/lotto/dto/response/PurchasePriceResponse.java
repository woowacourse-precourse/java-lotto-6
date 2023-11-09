package lotto.dto.response;

import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;

import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;

public class PurchasePriceResponse {
    private final List<Integer> numbers;

    public PurchasePriceResponse(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<PurchasePriceResponse> createResponsesFromUser(final User user) {
        final List<PurchasePriceResponse> purchasePriceResponses = new ArrayList<>();
        final int purchaseCount = user.getPurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            purchasePriceResponses.add(new PurchasePriceResponse(createNumbers(user, i)));
        }

        return purchasePriceResponses;
    }

    private static List<Integer> createNumbers(final User user, int index) {
        final List<Integer> numbers = new ArrayList<>();
        for (int j = 0; j < LOTTO_NUMBER_SIZE; j++) {
            final int number = user.getLottoFromIndex(index).getNumberFromIndex(j);
            numbers.add(number);
        }

        return numbers;
    }
}
