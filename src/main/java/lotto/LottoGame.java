package lotto;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lib.constant.LottoConstants;
import lib.enumeration.LottoWinnerRule;

public class LottoGame {
    PrintStream printStream = System.out;
    private List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<Lotto>();
    }
    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private Lotto createLotto() {
        while(true) {
            try {
                List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_RANGE, LottoConstants.LOTTO_END_RANGE, LottoConstants.LOTTO_SIZE);
    
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public void createLottos() {
        int count = this.price / LottoConstants.LOTTO_PRICE;

        for (int i = 0; i < count; ++i) {
            this.lottos.add(this.createLotto());
        }
    }

    private void resultPut(Map<Integer, List<List<Integer>>> map, int key, List<Integer> value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
            return;
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        results.add(value);
        map.put(key, results);
    }

    public Map<Integer, List<List<Integer>>> getMatchedLottosResult() {
        Map<Integer, List<List<Integer>>> matchedLottosResult = new HashMap<Integer, List<List<Integer>>>();

        this.lottos.forEach(lotto -> {
            List<Integer> matchedLotto = lotto.getMatchedLotto(this.winnerNumbers.getNumbers(), this.bonusWinnerNumber);

            if (matchedLotto.size() == 6 && matchedLotto.contains(this.bonusWinnerNumber)) { this.resultPut(matchedLottosResult, LottoWinnerRule.SECOND.index(), matchedLotto); return; }
            if (matchedLotto.size() == 6) { this.resultPut(matchedLottosResult, LottoWinnerRule.FIRST.index(), matchedLotto); return; }
            if (matchedLotto.size() == 5) { this.resultPut(matchedLottosResult, LottoWinnerRule.THIRD.index(), matchedLotto); return; }
            if (matchedLotto.size() == 4) { this.resultPut(matchedLottosResult, LottoWinnerRule.FOURTH.index(), matchedLotto); return; }
            if (matchedLotto.size() == 3) { this.resultPut(matchedLottosResult, LottoWinnerRule.FIFTH.index(), matchedLotto); return; }
        });

        return matchedLottosResult;
    }
}
