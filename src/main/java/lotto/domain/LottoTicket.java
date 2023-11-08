package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class LottoTicket {
    private final List<Lotto> lottoGames;

    public LottoTicket() {
        this.lottoGames = new ArrayList<>();
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

    public Map<Prize, Integer> initializePrizeStatistics() {
        Map<Prize, Integer> initialStatistics = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                initialStatistics.put(prize, 0);
            }
        }
        return initialStatistics;
    }

    public Map<Prize, Integer> compilePrizeStatistics(Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> matchNumberCount = initializePrizeStatistics();

        // 상금의 수를 맵에 넣어주기
        for (Lotto lottoGame : lottoGames) {
            LottoResult lottoResult = new LottoResult(lottoGame, winningLotto, bonusNumber);
            LottoResult.updateMatchNumberCount(matchNumberCount, lottoResult);
        }

        return matchNumberCount;
    }



}