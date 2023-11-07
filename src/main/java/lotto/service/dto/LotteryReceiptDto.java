package lotto.service.dto;

import java.util.List;
import lotto.domain.PurchasedLottery;

public record LotteryReceiptDto(
        long quantity,
        List<LotteryDto> lotteries
) {
}
