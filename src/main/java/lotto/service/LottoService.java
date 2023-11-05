package lotto.service;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    private Lotto lotto;
    private Payment payment;
    private List<List<Integer>> userLottoTickets;

    public void purchaseLottoTickets(String inputAmount) {
        payment = new Payment(inputAmount);
    }

    public void createWinningLottoNumber(String inputLotto) {

        List<Integer> lottoNumbers = stringToList(inputLotto);
        lotto = new Lotto(lottoNumbers);

    }

    public List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public List<List<Integer>> setLottoNumbers() {
        int ticketCount = payment.getTicket();
        User user = new User(ticketCount);
        userLottoTickets = new ArrayList<>(user.getLottoCount());
        return userLottoTickets;
    }

    public void createBonusNumber(String inputBonus) {
        new Bonus(lotto, inputBonus);
    }
}
