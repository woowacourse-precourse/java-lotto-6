package lotto;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int amount = InputHandler.getUserInputAmount();

        LottoTicket lottoTicket = new LottoTicket(amount);

        List<Integer> lottoNumbers = InputHandler.getUserInputlotto();

        Lotto lotto = new Lotto(lottoNumbers);

        int bonusNumber = InputHandler.getUserInputBonus();

        Bonus bonus = new Bonus(bonusNumber, lotto);
    }
}
