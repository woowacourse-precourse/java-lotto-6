package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.ExceptionMessage;
import lotto.utils.GameNumber;
import lotto.utils.Match;

public class LottoGame {
    private final static int ZREO = 0;

    private final User user;

    private HashMap<String, Integer> matchResults;

    private Double rateOfReturn;

    public LottoGame(Integer amount) {
        this.user = new User(issuanceLotto(amount));
        validate(amount);
        generateMatchResults();
    }

    private void generateMatchResults() {
        matchResults = new HashMap<>();
        for (Match match : Match.values()) {
            matchResults.put(match.getMessage(), ZREO);
        }
    }

    public List<Lotto> issuanceLotto(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZREO; i < amount / GameNumber.UNIT.getNumber(); i++) {
            lottos.add(new Lotto(getNumbers()));
        }
        return lottos;
    }

    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(GameNumber.MIN_RANGE.getNumber(), GameNumber.MAX_RANGE.getNumber(),
                GameNumber.LOTTO_SIZE.getNumber());
    }

    public User getUser() {
        return this.user;
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }

    public Map<String, Integer> getMatchResults() {
        return this.matchResults;
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
            result += matchResults.get(match.getMessage()) * match.getPrize();
        }
        result = Math.round(result / user.issuanceLotto().size() * 10.0);
        this.rateOfReturn = result / 100.0;
    }

    public void updateMatch(int matchNumber, Lotto lotto, DrawResult drawResult) {
        if (matchNumber == GameNumber.THREE_MATCH.getNumber()) {
            updateMatchCount(Match.THREE_MATCH.getMessage());
        }
        if (matchNumber == GameNumber.FOUR_MATCH.getNumber()) {
            updateMatchCount(Match.FOUR_MATCH.getMessage());
        }
        if (matchNumber == GameNumber.FIVE_MATCH.getNumber()) {
            updateMatchCount(Match.FIVE_MATCH.getMessage());
        }
        if (matchNumber == GameNumber.SIX_MATCH.getNumber()) {
            updateMatchCount(Match.SIX_MATCH.getMessage());
        }
        updateBonusCount(matchNumber, lotto, drawResult);
    }

    public void updateBonusCount(int matchNumber, Lotto lotto, DrawResult drawResult) {
        if (matchNumber == GameNumber.FIVE_MATCH.getNumber() && lotto.getNumbers().contains(drawResult.bonusNumber())) {
            updateMatchCount(Match.BONUS_MATCH.getMessage());
        }
    }

    public void updateMatchCount(String message) {
        matchResults.put(message, matchResults.get(message) + 1);
    }

    public int countMatch(Lotto lotto, DrawResult drawResult) {
        int count = ZREO;
        for (Integer number : drawResult.lotto().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void validate(int amount) {
        validateUnit(amount);
        validateNegative(amount);
    }

    public void validateUnit(int amount) {
        if (amount % GameNumber.UNIT.getNumber() != ZREO) {
            throw new IllegalArgumentException(ExceptionMessage.UNIT_IS_INCORRECT.getMessage());
        }
    }

    public void validateNegative(int amount) {
        if (amount < ZREO) {
            throw new IllegalStateException(ExceptionMessage.NEGATIVE_NUMBER.getMessage());
        }
    }
}
