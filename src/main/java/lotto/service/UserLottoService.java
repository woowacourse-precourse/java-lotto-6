package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.domain.Lotto;
import lotto.domain.User;

public class UserLottoService {
    public static User user;
    public static User lottoSetting(int amount) {
        List<Lotto> userTickets = generateLottoTickets(amount);
        return user = new User(amount, userTickets);
    }
    private static List<Lotto> generateLottoTickets(int amount) {
        List<Lotto> UserTickets = new ArrayList<>();
        for (int i = 0 ; i< amount ; i++) {
            UserTickets.add(generateLottoNumbers());
        }
        return UserTickets;
    }
    private static Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }
}
