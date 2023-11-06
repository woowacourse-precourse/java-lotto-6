package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants.ErrorMessage;
import lotto.Constants.IntConstants;

public class Cpu {
    private final List<Lotto> sixLottoNumbers;
    private final int tickets;

    public Cpu(int money) {
        validTickets(money);
        this.tickets = money / IntConstants.UNIT_BILL.getValue();
        this.sixLottoNumbers = setSixLottoNumbers(tickets);
    }

    public List<Lotto> getSixLottoNumbers() {
        return sixLottoNumbers;
    }

    public int getTickets() {
        return tickets;
    }

    private List<Lotto> setSixLottoNumbers(int tickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            lottos.add(new Lotto(LottoGenerator.sixNumber()));
        }
        return lottos;
    }

    private void validTickets(int money) {
        if (money % IntConstants.UNIT_BILL.getValue() != 0) { // 나머지가 0이 아닐 때 오류 반환
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT_MESSAGE.getMessage());
        }
    }
}
