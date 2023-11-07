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

    // Lotto를 LottoTicket의 리스트에 하나씩 추가하는 기능
    public void addLottoGame(Lotto lotto) {
        lottoGames.add(lotto);
    }

    public List<Lotto> getLottoGames() {
        return new ArrayList<>(lottoGames);
    }

    public static List<Lotto> generateRandomLotto(int lottoTicketCount) {
        List<Lotto> lottoRandomNumbers = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoRandomNumbers.add(randomLottoNumberList());
        }
        return lottoRandomNumbers;
    }

    public static Lotto randomLottoNumberList() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    //
    public Map<Prize, Integer> compilePrizeStatistics(Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> matchNumberCount = new EnumMap<>(Prize.class);
        // Prize를 돌면서 prize값을 0으로 초기화시킨다
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                matchNumberCount.put(prize, 0);
            }
        }
        // 상금의 수를 맵에 넣어주기
        for (Lotto lottoGame : lottoGames) {
            LottoResult lottoResult = new LottoResult(lottoGame, winningLotto, bonusNumber);
            LottoResult.updateMatchNumberCount(matchNumberCount, lottoResult);
        }

        return matchNumberCount;
    }
}