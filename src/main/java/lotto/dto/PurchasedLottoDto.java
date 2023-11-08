package lotto.dto;

import java.util.List;
import lotto.service.LottoRank;

public record PurchasedLottoDto(List<Integer> numbers, LottoRank rank) {
}
