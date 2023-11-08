package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class LottoTicket {
    public static List<Lotto> lottoGames;

    public LottoTicket() {
        lottoGames = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoGames.add(lotto);
    }

    public static List<Lotto> getLottoGames() {
        return new ArrayList<>(lottoGames);
    }

    public static List<Lotto> randomLottoNumbers(int lottoTicketCount) {
        List<Lotto> lottoRandomNumbers = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoRandomNumbers.add(generateRandomLotto());
        }
        return lottoRandomNumbers;
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}