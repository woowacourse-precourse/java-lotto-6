package lotto.view;

import lotto.domain.Quantity;

public class OutputView {
    
    public void printQuantityOfLotteries(Quantity quantity) {
        System.out.printf("%d개를 구매했습니다.", quantity.getQuantity());
    }
}
