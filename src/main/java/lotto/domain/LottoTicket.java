package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;



public class LottoTicket {
    public static List<Lotto> lottoGames;

    public LottoTicket() {
        lottoGames = new ArrayList<>();
    }

    public void addLottoGame(Lotto lotto) {
        lottoGames.add(lotto);
    }

    public List<Lotto> getLottoGames() {
        return new ArrayList<>(lottoGames);
    }

    public static List<Lotto> randomLottoNumbers(int lottoTicketCount) {
        List<Lotto> lottoRandomNumbers = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoRandomNumbers.add(generateRandomLotto());
        }
        return lottoRandomNumbers;
    }

    public static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }
}