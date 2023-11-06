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
            updateMatch(countMatch(lotto, drawResult), lotto, drawResult);
        }
        calculationRateOfReturn();
    }

    public void calculationRateOfReturn() {
        double result = 0;
        for (Match match : Match.values()) {
            result += matchs.get(match.getMessage()) * match.getPrize();
        }
        result = Math.round(result / user.issuanceLotto().size() * 10.0);
        this.rateOfReturn = result / 100.0;
    }

    public void updateMatch(int matchNumber, Lotto lotto, DrawResult drawResult) {
        if (matchNumber == 3) {
            updateMatchCount(Match.THREE_MATCH.getMessage());
        }
        if (matchNumber == 4) {
            updateMatchCount(Match.FOUR_MATCH.getMessage());
        }
        if (matchNumber == 5) {
            updateMatchCount(Match.FIVE_MATCH.getMessage());
        }
        if (matchNumber == 6) {
            updateMatchCount(Match.SIX_MATCH.getMessage());
        }
        updateBonusCount(matchNumber, lotto, drawResult);
    }

    public void updateBonusCount(int matchNumber, Lotto lotto, DrawResult drawResult) {
        if (matchNumber == 5 && lotto.getNumbers().contains(drawResult.bonusNumber())) {
            updateMatchCount(Match.BONUS_MATCH.getMessage());
        }
    }

    public void updateMatchCount(String message) {
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
