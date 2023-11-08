package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.common.Announcement;
import lotto.common.ConstraintNumber;
import lotto.common.ErrorMessage;
import lotto.common.ExceptionHandler;
import lotto.common.LottoNumberValidator;
import lotto.common.LottoRank;

public class LottoManager {

    private final List<Lotto> lottos;
    private final Map<Integer, Integer> matchResults;

    LottoManager() {
        lottos = new ArrayList<>();
        matchResults = new HashMap<>();
    }

    public void purchaseLottos() {
        int amount = getAmount();
        for (int i = 0; i < amount / ConstraintNumber.PURCHASE_AMOUNT_UNIT.getValue(); i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                ConstraintNumber.LOTTO_MIN_NUMBER.getValue(),
                ConstraintNumber.LOTTO_MAX_NUMBER.getValue(),
                ConstraintNumber.LOTTO_MAX_SIZE.getValue()
            );
            this.lottos.add(new Lotto(randomNumbers));
        }
        Announcement.PURCHASE_LOTTOS.speak(lottos.size());
    }

    public void calculateMatchResults(LottoDrawMachine lottoDrawMachine) {
        List<Integer> winningNumbers = lottoDrawMachine.getWinningNumbers();
        int bonusNumber = lottoDrawMachine.getBonusNumber();
        for (Lotto lotto : this.lottos) {
            Announcement.printLottoNumber(lotto);
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> matchNumbers = lottoNumbers
                .stream()
                .filter(winningNumbers::contains)
                .toList();
            int matchCount = matchNumbers.size();
            boolean isSameBonus = lotto.getNumbers()
                .contains(bonusNumber);
            int rank = getRankByMatchResult(matchCount, isSameBonus);
            this.matchResults.put(rank, this.matchResults.getOrDefault(rank, 0) + 1);
        }
    }

    public void printWinningReport() {
        Announcement.WINNING_STATS.speak();
        int totalPrizeMoney = 0;
        for (int rank = LottoRank.FIVE.getRank(); rank >= LottoRank.ONE.getRank(); rank--) {
            LottoRank lottoRank = LottoRank.getLottoRank(rank);
            int count = this.matchResults.getOrDefault(rank, 0);
            lottoRank.printRank(count);
            if (count != 0) {
                totalPrizeMoney += lottoRank.getPrizeMoney();
            }
        }
        Announcement.printTotalPrizeMoneyRate(totalPrizeMoney, this.lottos.size() * ConstraintNumber.PURCHASE_AMOUNT_UNIT.getValue());
    }

    private int getRankByMatchResult(int matchCount, boolean isSameBonus) {
        if (matchCount == 6) {
            return LottoRank.ONE.getRank();
        }
        if (matchCount == 5 && isSameBonus) {
            return LottoRank.TWO.getRank();
        }
        if (matchCount == 5) {
            return LottoRank.THREE.getRank();
        }
        if (matchCount == 4) {
            return LottoRank.FOUR.getRank();
        }
        if (matchCount == 3) {
            return LottoRank.FIVE.getRank();
        }
        return LottoRank.NOTHING.getRank();
    }

    private int getAmount() {
        Announcement.INPUT_AMOUNT.speak();
        while (true) {
            try {
                int amount = parseInputToNumber(Console.readLine());
                validateAmountUnit(amount, ConstraintNumber.PURCHASE_AMOUNT_UNIT.getValue());
                return amount;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private int parseInputToNumber(String input) throws IllegalArgumentException {
        LottoNumberValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateAmountUnit(int amount, int unit) throws IllegalArgumentException {
        if (amount % unit != 0) {
            ExceptionHandler.throwIllegalArgumentException(ErrorMessage.INPUT_AMOUNT_INVALID_UNIT);
        }
    }
}
