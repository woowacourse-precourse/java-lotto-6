package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.*;

public class LottoService {
    public ArrayList<Lotto> getLottos(Integer price) {
        int lottoCount = price / Constants.PRICE_UNIT;
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private Lotto issueLotto() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < Constants.LOTTO_LENGTH) {
            numbers.add(Randoms.pickNumberInRange(Constants.MIN_LOTTO_NUM, Constants.MAX_LOTTO_NUM));
        }

        return new Lotto(List.copyOf(numbers));
    }

    public String getWinningStatic(ArrayList<Lotto> lottos, Lotto winningNumber, Integer bonusNumber) {
        HashMap<Ranking, Integer> winningStatic = new HashMap<>();

        for (Lotto lotto: lottos) {
            Ranking rank = getLottoResult(lotto, winningNumber, bonusNumber);
            winningStatic.put(rank, winningStatic.getOrDefault(rank, 0) + 1);
        }

        return makeWinningStaticResult(winningStatic);
    }

    private Ranking getLottoResult(Lotto lotto, Lotto winningNumber, Integer bonusNumber) {
        int matchCount = 0;
        boolean matchBonus = false;

        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                matchCount += 1;
            }

            if (number.equals(bonusNumber)) {
                matchBonus = true;
            }
        }

        return Ranking.getRanking(matchCount, matchBonus);
    }

    private String makeWinningStaticResult(HashMap<Ranking, Integer> winningStatic) {
        StringBuilder result = new StringBuilder();

        for (Ranking ranking : Ranking.values()) {
            if (ranking.getRank() == 6) continue;;

            result.append(ranking);
            result.append(String.format("- %d개", winningStatic.getOrDefault(ranking, 0)));
            result.append("\n");
        }

        return result.toString();
    }
}
