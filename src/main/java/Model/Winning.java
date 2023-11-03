package Model;

import Config.ErrorMessage;
import Config.GameConfig;

import java.util.*;

public class Winning {

    private final List<Integer> winnings;

    public Winning(String inputWinning){
        List<Integer> winnings = validateNumeric(inputWinning);
        validateSize(winnings);
        validateRange(winnings);
        validateDuplicate(winnings);
        winnings.sort(Comparator.naturalOrder());
        this.winnings = winnings;
    }

    public String countMatch(List<Integer> numbers){
        int count = 0;
        for (int number : numbers){
            if (winnings.contains(number)){
                count += 1;
            }
        }
        return Integer.toString(count);
    }

    public boolean isContain(int bonus){
        return winnings.contains(bonus);
    }

    private List<Integer> validateNumeric(String inputWinning){
        List<String> tempWinnings = List.of(inputWinning.split(GameConfig.SEPARATOR));
        List<Integer> winnings = new ArrayList<>();
        for (String tempWinning : tempWinnings){
            tempWinning = tempWinning.strip();
            try{
                winnings.add(Integer.parseInt(tempWinning));
            } catch (NumberFormatException e){
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getErrorMessage());
            }
        }
        return winnings;
    }

    private void validateSize(List<Integer> winnings) {
        if (winnings.size() != GameConfig.LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_NUMBER.getErrorMessage(), GameConfig.SEPARATOR, GameConfig.LOTTO_NUMBER));
        }
    }

    private void validateRange(List<Integer> winnings){
        for (int winning : winnings){
            if (winning < GameConfig.MIN_LOTTO || winning > GameConfig.MAX_LOTTO){
                throw new IllegalArgumentException(String.format(ErrorMessage.NOT_IN_RANGE.getErrorMessage(), GameConfig.MIN_LOTTO, GameConfig.MAX_LOTTO));
            }
        }
    }

    private void validateDuplicate(List<Integer> winnings){
        Set<Integer> duplicationTester = new HashSet<>(winnings);
        if (duplicationTester.size() != winnings.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
        }
    }

}
