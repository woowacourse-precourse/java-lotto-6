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
    private List<Integer> winningNumbers;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<MatchState, Integer> totalMatchCounts = new LinkedHashMap<>();
    private Error errorState = Error.NO_PROBLEM;

//MatchState 활용해서 구현하기
    private void printMatch() {
        sortTotalMatchCounts();
        totalMatchCounts.forEach(output::printResult);
    }
    private void generateLotto() {
        int numberOfLotto = price/1000;
        int index = 0;
        while (lottos.size() < numberOfLotto){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            lottos.get(index).printLottoNumbers();
            setTotalMatchCounts(lottos.get(index).getMatchCount(winningNumbers), lottos.get(index).checkBonusNumber(bonusNumber));
            index++;
        }
    }

    private void setTotalMatchCounts(int numberOfMatch, boolean isMatchBonus) {
        MatchState matchState = MatchState.getMatchState(numberOfMatch, isMatchBonus);
        if (totalMatchCounts.containsKey(matchState)) {
            totalMatchCounts.put(matchState, matchState.getPrize());
        }
        totalMatchCounts.put(matchState, 1);
    }

    private void sortTotalMatchCounts() {
        totalMatchCounts = totalMatchCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(MatchState::getMatchCount)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private void setPrice() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                price = input.getPrice();
                validatePrice();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void setWinningNumbers() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                winningNumbers = input.getWinningNumbers();
                validateWinningNumbers();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void setBonusNumber() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                bonusNumber = input.getBonusNumber();
                validateBonusNumber();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void validatePrice() {
        if (price % 1000 != 0) {
            errorState = Error.PRICE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }

    private void validateWinningNumbers() {
        if (winningNumbers.size() != 6) {
            errorState = Error.WINNING_NUMBER_OUT_OF_COUNT_ERROR;
            throw new IllegalArgumentException();
        } else if (winningNumbers.size() > winningNumbers.stream().distinct().count()) {
            errorState = Error.WINNING_NUMBER_DUPLICATE_ERROR;
            throw new IllegalArgumentException();
        } else if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            errorState = Error.WINNING_NUMBER_OUT_OF_RANGE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }

    private void validateBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            errorState = Error.BONUS_NUMBER_DUPLICATE_ERROR;
            throw new IllegalArgumentException();
        } else if (bonusNumber < 1 || bonusNumber > 45) {
            errorState = Error.BONUS_NUMBER_OUT_OF_RANGE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }
}
