package lotto;

import java.util.List;

public class Picker {
    private List<Integer> winNumbers;
    private Integer winBonusNumber;

    public List<Integer> generateWinNumbers(){
        Random random = new Random();
        return random.generateLottoNumbers();
    }

    public int generateWinBonusNumber(){
        Random random = new Random();
        int startNumber = 1;
        int endNumber = 45;
        return random.generateLottoNumber(startNumber, endNumber);
    }
}
