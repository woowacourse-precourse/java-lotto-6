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
    private List<List<Integer>> userLottoNumbers;

    public void buyLottoTickets(String inputAmount) {
        payment = new Payment(inputAmount);
    }

    public void createLottoWinningNumber(String inputLotto) {

        List<Integer> lottoWinningNumber = stringToList(inputLotto);
        lotto = new Lotto(lottoWinningNumber);

    }

    public List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public List<List<Integer>> setLottoNumbers() {
        int ticketCount = payment.getTicket();
        User user = new User(ticketCount);
        userLottoNumbers = new ArrayList<>(user.getLottoCount());
        return userLottoNumbers;
    }

    public void createBonusNumber(String inputBonus) {
        new Bonus(lotto, inputBonus);
    }
}
