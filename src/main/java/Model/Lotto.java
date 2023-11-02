package Model;

import Config.ErrorMessage;
import Config.GameConfig;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public String getLotto(){
        return GameConfig.PRINTING_PREFIX +
                numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(GameConfig.SEPARATOR_WITH_BLANK)) +
                GameConfig.PRINTING_SUFFIX;
    }

    public int getResult(Winning winnings, Bonus bonus){
        int rank = GameConfig.WINNING.valueOfMatch(countMatch(winnings.getWinnings())).getRank();
        if (rank == GameConfig.WINNING.THIRD.getRank() && countBonus(winnings.getWinnings(), bonus.getBonus())){
            return GameConfig.WINNING.SECOND.getRank();
        }
        return rank;
    }

    private String countMatch(List<Integer> winnings){
        int count = 0;
        for (int number : numbers){
            if (winnings.contains(number)){
                count += 1;
            }
        }
        return Integer.toString(count);
    }

    private boolean countBonus(List<Integer> winnings, int bonus){
        return winnings.contains(bonus);
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
}
