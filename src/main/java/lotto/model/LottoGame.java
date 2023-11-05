package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.utils.GameMessage;

public class LottoGame {

    private final User user;

    private HashMap<String, Integer> matchs;

    private Double rateOfReturn;

    public LottoGame(Integer amount) {
        this.user = new User(issuanceLotto(amount));
        generateMatchs();
    }

    private void generateMatchs() {
        matchs = new HashMap<>();
        matchs.put(GameMessage.THREE_MATCH.getMessage(), 0);
        matchs.put(GameMessage.FOUR_MATCH.getMessage(), 0);
        matchs.put(GameMessage.FIVE_MATCH.getMessage(), 0);
        matchs.put(GameMessage.BONUS_MATCH.getMessage(), 0);
        matchs.put(GameMessage.SIX_MATCH.getMessage(), 0);
    }

    public List<Lotto> issuanceLotto(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount / 1000; i++) {
            List<Integer> numbers = new ArrayList<>();

            lottos.add(new Lotto(generateNumbers(numbers)));
        }

        return lottos;
    }

    public List<Integer> generateNumbers(List<Integer> numbers) {

        do {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        } while (validateDuplication(numbers));

        return numbers;
    }

    public boolean validateDuplication(List<Integer> nums) {

        for (Integer number : nums) {
            if (nums.contains(number)) {
                return false;
            }
        }

        return true;
    }

    public User getUser() {
        return this.user;
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }

    public void calculationResult(WinLotto winLotto) {
        for (Lotto lotto : user.getIssuanceLotto()) {
            switch (countMatch(lotto, winLotto)) {
                case 3 -> updateMatch(GameMessage.THREE_MATCH.getMessage());
                case 4 -> updateMatch(GameMessage.FOUR_MATCH.getMessage());
                case 5 -> updateMatch(GameMessage.FIVE_MATCH.getMessage());
                case 6 -> updateMatch(GameMessage.SIX_MATCH.getMessage());
            }
            if (countMatch(lotto, winLotto) == 5 && lotto.getNumbers().contains(winLotto.bonusNumber())) {
                updateMatch(GameMessage.BONUS_MATCH.getMessage());
            }
        }
        rateOfReturn = calculationRateOfReturn();
    }

    public Double calculationRateOfReturn() {
        double result = 0;
        result += matchs.get(GameMessage.THREE_MATCH.getMessage()) * 5000;
        result += matchs.get(GameMessage.FOUR_MATCH.getMessage()) * 50000;
        result += matchs.get(GameMessage.FIVE_MATCH.getMessage()) * 1500000;
        result += matchs.get(GameMessage.SIX_MATCH.getMessage()) * 2000000000;
        result += matchs.get(GameMessage.BONUS_MATCH.getMessage()) * 30000000;

        return result;
    }

    public void updateMatch(String message) {
        matchs.put(message, matchs.get(message) + 1);
    }

    public int countMatch(Lotto lotto, WinLotto winLotto) {
        int count = 0;
        for (Integer number : winLotto.lotto().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
}
