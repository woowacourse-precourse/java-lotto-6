package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.*;

public class LottoService {

    public static int getAmountOfLottoTickets() {
        int money = InputView.inputMoney();
        int amountOfLottoTickets = money / 1000;

        // [예외처리] 1000원으로 나누어 떨어지지 않는 경우

        return amountOfLottoTickets;
    }
    public static List<Lotto> makeLottoTickets() {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getAmountOfLottoTickets(); i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            // [예외처리] 랜덤으로 생성한 수에 중복된 번호가 있는 경우
            Lotto ticketNumbers = new Lotto(numbers);
            lottoTickets.add(ticketNumbers);
        }

        return lottoTickets;
    }
    public static int compareWithWinningNumbers(Lotto lottoTicket, List<Integer> winningNumbers) {
        List<Integer> lottoNumbers = lottoTicket.getNumbers();
        Set<Integer> findCorrectNumbers = new HashSet<>(lottoNumbers);
        int countingCorrectNumbers = 0;

        for (Integer num : winningNumbers) {
            if(findCorrectNumbers.contains(num)) {
                countingCorrectNumbers++;
            }
        }

        return countingCorrectNumbers;
    }
    public static void countCorrectNumbers(List<Lotto> lottoTickets, List<Integer> winningNumbers) {
        List<Integer> amountOfCorrectNumbers = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            amountOfCorrectNumbers.add(compareWithWinningNumbers(lottoTicket, winningNumbers));
        }
    }
    public void makeStatistics() {
    }
    public void getEarningRate() {

    }
}
