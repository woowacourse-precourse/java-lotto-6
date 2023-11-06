package lotto;

import java.util.List;

public record PurchasedLottoState(int quantity, List<List<Integer>> value) {
}
