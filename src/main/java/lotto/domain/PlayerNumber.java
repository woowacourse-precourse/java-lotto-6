package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    private List<Integer> playerNumbers = new ArrayList<>();

    private int bonusNumber;

    public PlayerNumber(String rawPlayerNumbers, int bonusNumber) {
        convertIntegerPlayerNumber(rawPlayerNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void convertIntegerPlayerNumber(String rawNumber) {
        String[] splitStringNumber = splitStringNumber(rawNumber);

        for (int i = 0; i < splitStringNumber.length; i++) {
            playerNumbers.add(parseInteger(splitStringNumber[i]));
        }
    }

    private String[] splitStringNumber(String rawNumber) {
        return rawNumber.split(",");
    }

    private int parseInteger(String number) {
        return Integer.parseInt(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
