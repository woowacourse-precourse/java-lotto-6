package lotto.model;

import static lotto.utils.ExceptionMessage.NEGATIVE_NUMBER;
import static lotto.utils.ExceptionMessage.UNIT_IS_INCORRECT;
import static lotto.utils.GameNumber.LOTTO_SIZE;
import static lotto.utils.GameNumber.MAX_RANGE;
import static lotto.utils.GameNumber.MIN_RANGE;
import static lotto.utils.GameNumber.UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.Match;

public class LottoGame {

    private final User user;

    private HashMap<String, Integer> matchs;

    private Double rateOfReturn;

    public LottoGame(Integer amount) {
        this.user = new User(issuanceLotto(amount));
        validate(amount);
        generateMatchs();
    }

    private void generateMatchs() {
        matchs = new HashMap<>();
        for (Match match : Match.values()) {
            matchs.put(match.getMessage(), 0);
        }
    }

    public List<Lotto> issuanceLotto(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount / UNIT.getNumber(); i++) {
            lottos.add(new Lotto(getNumbers()));
        }
        return lottos;
    }

    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE.getNumber(), MAX_RANGE.getNumber(), LOTTO_SIZE.getNumber());
    }

    public User getUser() {
        return this.user;
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }

    public Map<String, Integer> getMatchs() {
        return this.matchs;
    }

    public void calculationResult(DrawResult drawResult) {
        for (Lotto lotto : user.issuanceLotto()) {
            int i = countMatch(lotto, drawResult);
            if (i == 3) {
                updateMatch(Match.THREE_MATCH.getMessage());
            } else if (i == 4) {
                updateMatch(Match.FOUR_MATCH.getMessage());
            } else if (i == 5) {
                updateMatch(Match.FIVE_MATCH.getMessage());
            } else if (i == 6) {
                updateMatch(Match.SIX_MATCH.getMessage());
            } else if (countMatch(lotto, drawResult) == 5 && lotto.getNumbers().contains(drawResult.bonusNumber())) {
                updateMatch(Match.BONUS_MATCH.getMessage());
            }
        }
        rateOfReturn = calculationRateOfReturn();
    }

    public Double calculationRateOfReturn() {
        double result = 0;
        for (Match match : Match.values()) {
            result += matchs.get(match.getMessage()) * match.getPrize();
        }
        result = Math.round(result / user.issuanceLotto().size() * 10.0);
        return result / 100.0;
    }

    public void updateMatch(String message) {
        matchs.put(message, matchs.get(message) + 1);
    }

    public int countMatch(Lotto lotto, DrawResult drawResult) {
        int count = 0;
        for (Integer number : drawResult.lotto().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void validate(int amount) {
        if (amount % UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(UNIT_IS_INCORRECT.getMessage());
        }
        if (amount < 0) {
            throw new IllegalStateException(NEGATIVE_NUMBER.getMessage());
        }
    }
}
