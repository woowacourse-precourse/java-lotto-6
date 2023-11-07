package lotto;

import dto.LottoMoney;

public class LotteryMachine {
    private LotteryMachine() {
    }

    public static LottoTickets buy(LottoMoney money) {
        // 추후 구현 사항에 따라 메서드 전체가 LottoTickets의 생성자로 대체될 수도 있다.
        return new LottoTickets(money);
    }

}
