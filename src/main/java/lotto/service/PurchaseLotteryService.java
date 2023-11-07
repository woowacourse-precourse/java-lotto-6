package lotto.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryRetailer;
import lotto.domain.PurchasedLottery;
import lotto.domain.User;
import lotto.service.dto.LotteryDto;
import lotto.service.dto.LotteryReceiptDto;

public class PurchaseLotteryService {
    private final LotteryRetailer retailer;
    private final LotteryOperator operator;

    private final UserService userService;

    public PurchaseLotteryService(LotteryRetailer retailer, LotteryOperator operator, UserService userService) {
        this.retailer = retailer;
        this.operator = operator;
        this.userService = userService;
    }

    public LotteryReceiptDto purchase(String username, long purchasedAmount) {
        User user = userService.getUser(username);
        LotteryReceipt receipt = retailer.purchase(operator, purchasedAmount);
        user.takeReceipt(receipt);
        return new LotteryReceiptDto(receipt.size(), convertLotteryDto(receipt));
    }

    public List<LotteryDto> convertLotteryDto(LotteryReceipt receipt) {
        return receipt.getLotteries()
                .stream()
                .map(PurchasedLottery::getNumbers)
                .map(LotteryDto::new)
                .collect(toList());
    }

}
