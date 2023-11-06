package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    private Lotto lotto;
    private Bonus bonus;
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

    public List<List<Integer>> getUserLottoNumbers() {
        int ticketCount = payment.getTicket();
        User user = new User(ticketCount);
        userLottoNumbers = new ArrayList<>(user.getLottoCount());
        return userLottoNumbers;
    }

    public void createBonusNumber(String inputBonus) {
        bonus = new Bonus(lotto, inputBonus);
    }

    public void calculatePrize() {
        List<Integer> winningLottoNumber = lotto.getNumbers();
        Result result = new Result(winningLottoNumber, userLottoNumbers, bonus.getBonusNumber());
    }
}
