package lotto.service.dto;

import java.util.List;

public record LotteryReceiptDto(
        long quantity,
        List<LotteryDto> lotteries
) {
}
