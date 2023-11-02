package Model;

import Config.ErrorMessage;
import Config.GameConfig;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winning {

    private final List<Integer> winnings;

    public Winning(String inputWinning){
        List<Integer> winnings = validateNumeric(inputWinning);
        validateSize(winnings);
        validateRange(winnings);
        winnings.sort(Comparator.naturalOrder());
        this.winnings = winnings;
    }

    public List<Integer> getWinnings(){
        return winnings;
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

}
