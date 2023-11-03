package lotto;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
    private List<Lotto> sixLottoNumbers;
    int bonusNumber;

    public Cpu(int money) {
        validTickets(money);
        int tickets = money / IntConstants.UNIT_BILL.getValue();
        sixLottoNumbers = setSixLottoNumbers(tickets);
        bonusNumber = setBonusNumber();
    }

    public List<Lotto> getSixLottoNumbers() {
        return sixLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Lotto> setSixLottoNumbers(int tickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            lottos.add(new Lotto(LottoGenerator.sixNumber()));
        }
        return lottos;
    }

    private int setBonusNumber() {
        return LottoGenerator.bonusNumber();
    }

    private void validTickets(int money) {
        if (money % IntConstants.UNIT_BILL.getValue() != 0) { // 나머지가 0이 아닐 때 오류 반환
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT_MESSAGE.getMessage());
        }
    }
}
