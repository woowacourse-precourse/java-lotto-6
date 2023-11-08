package lotto.Domain;

import java.util.List;

public record GameInfo(List<Integer> winnerNumbers, int bonusNumber, int purchaseCost) {
}
