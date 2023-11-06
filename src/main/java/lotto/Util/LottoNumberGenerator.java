package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.PlayerNumber;

public class LottoNumberGenerator {
    public static List<PlayerNumber> createLottoNumberTickets(int buyingPay) {
        List<PlayerNumber> lottoTickets = generateLottoTickets(calculateNumberOfLottoTickets(buyingPay));
        return lottoTickets;
    }

    public static int calculateNumberOfLottoTickets(int buyingPay) {
        return buyingPay / 1000;
    }

    public static List<PlayerNumber> generateLottoTickets(int ticketCount) {
        List<PlayerNumber> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottoTickets.add(new PlayerNumber(sortedList(lottoNumbers)));
        }
        return lottoTickets;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> sortedList(List<Integer> unsortedList) {
        return unsortedList.stream().sorted().collect(Collectors.toList());
    }
}
