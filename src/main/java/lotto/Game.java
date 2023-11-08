package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import ui.Input;
import ui.Output;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private final Input input = new Input();
    private final Output output = new Output();

    private int price;
    private int bonusNumber;
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Lotto> lottos = new ArrayList<>();
    private Map<MatchState, Integer> totalMatchCounts = new LinkedHashMap<>();
    private Error errorState = Error.INIT_STATE;

    public void run() {
        setPrice();
        output.printNumberOfLotto(price);
        generateLottos();
        setWinningNumbers();
        setBonusNumber();
        setTotalMatchCounts();
        output.printResult(totalMatchCounts);
        output.printRateOfReturn(getRateOfReturn());
    }

    private void setPrice() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                price = input.getPrice();
                validatePrice();
            } catch (IllegalArgumentException e) {
                errorState = Error.printError(errorState);
            }
        }
        errorState = Error.INIT_STATE;
    }

    private void validatePrice() {
        if (price % 1000 != 0) {
            errorState = Error.PRICE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }

    private void generateLottos() {
        int numberOfLotto = price / 1000;
        int index = 0;
        while (lottos.size() < numberOfLotto) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            lottos.get(index).printLottoNumbers();
            index++;
        }
    }

    private void setWinningNumbers() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                winningNumbers = input.getWinningNumbers();
                validateWinningNumbers();
            } catch (IllegalArgumentException e) {
                errorState = Error.printError(errorState);
            }
        }
        errorState = Error.INIT_STATE;
    }

    private void validateWinningNumbers() {
        if (isWinningNumberSizeValid() && isWinningNumberDuplicate() && isWinningNumberInRange()) {
            errorState = Error.NO_PROBLEM;
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isWinningNumberSizeValid() {
        if (winningNumbers.size() != 6) {
            errorState = Error.WINNING_NUMBER_OUT_OF_COUNT_ERROR;
            return false;
        }
        return true;
    }

    private boolean isWinningNumberDuplicate() {
        if (winningNumbers.size() > winningNumbers.stream().distinct().count()) {
            errorState = Error.WINNING_NUMBER_DUPLICATE_ERROR;
            return false;
        }
        return true;
    }

    private boolean isWinningNumberInRange() {
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            errorState = Error.WINNING_NUMBER_OUT_OF_RANGE_ERROR;
            return false;
        }
        return true;
    }

    private void setBonusNumber() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                bonusNumber = input.getBonusNumber();
                validateBonusNumber();
            } catch (IllegalArgumentException e) {
                errorState = Error.printError(errorState);
            }
        }
        errorState = Error.INIT_STATE;
    }

    private void validateBonusNumber() {
        if (isBonusNumberDuplicate() && isBonusNumberInRange()) {
            errorState = Error.NO_PROBLEM;
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isBonusNumberDuplicate() {
        if (winningNumbers.contains(bonusNumber)) {
            errorState = Error.BONUS_NUMBER_DUPLICATE_ERROR;
            return false;
        }
        return true;
    }

    private boolean isBonusNumberInRange() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            errorState = Error.BONUS_NUMBER_OUT_OF_RANGE_ERROR;
            return false;
        }
        return true;
    }

    private void setTotalMatchCounts() {
        lottos.forEach(lotto -> {
            MatchState matchState = MatchState.getMatchState(
                    lotto.getMatchCount(winningNumbers),
                    lotto.checkBonusNumber(bonusNumber)
            );
            if (matchState != null) {
                totalMatchCounts.merge(matchState, 1, Integer::sum);
            }
        });
        sortTotalMatchCounts();
    }

    private void sortTotalMatchCounts() {
        totalMatchCounts = totalMatchCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(
                        Comparator.comparingInt(MatchState::getMatchCount)
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private float getRateOfReturn() {
        float totalWinningPrize = totalMatchCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return Math.round(totalWinningPrize * 10000.0f / price) / 100.0f;
    }
}