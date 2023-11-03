package Model;

import Config.ErrorMessage;
import Config.GameConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public String getLotto(){
        return GameConfig.PRINTING_PREFIX +
                numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(GameConfig.SEPARATOR_WITH_BLANK)) +
                GameConfig.PRINTING_SUFFIX;
    }

    public int getResult(Winning winnings, Bonus bonus){
        String match = winnings.countMatch(numbers);
        if (Integer.parseInt(match) < GameConfig.MIN_MATCH){
            return 0;
        }
        int rank = GameConfig.WINNING.valueOfMatch(match).getRank();
        if (rank == GameConfig.WINNING.THIRD.getRank() && bonus.matchBonus(numbers)){
            return GameConfig.WINNING.SECOND.getRank();
        }
        return rank;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameConfig.LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_NUMBER.getErrorMessage(), GameConfig.SEPARATOR, GameConfig.LOTTO_NUMBER));
        }
    }

    private void validateRange(List<Integer> numbers){
        for (int number : numbers){
            if (number < GameConfig.MIN_LOTTO || number > GameConfig.MAX_LOTTO){
                throw new IllegalArgumentException(String.format(ErrorMessage.NOT_IN_RANGE.getErrorMessage(), GameConfig.MIN_LOTTO, GameConfig.MAX_LOTTO));
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> duplicationTester = new HashSet<>(numbers);
        if (duplicationTester.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
        }
    }
}
