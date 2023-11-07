package lotto;

import dto.LottoMoneyDTO;
import dto.WinningNumberDTO;

public class LotteryMachine {
    private LotteryMachine() {
    }

    public static LottoTickets buy(LottoMoneyDTO money) {
        // 추후 구현 사항에 따라 메서드 전체가 LottoTickets의 생성자로 대체될 수도 있다.
        return new LottoTickets(money);
    }

    public static void draw(WinningNumberDTO winningNumbers) {
        //TODO: 번호 확인 구현
    }
}
