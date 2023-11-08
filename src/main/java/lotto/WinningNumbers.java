package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int NUMBERS_PER_LOTTO = 6;
    
    private List<Integer> winningNumbers;
    private Lotto winningLotto;
    private int bonusNumber;
    
    public WinningNumbers(String winningLottoText) throws IllegalArgumentException {
        validateWinningLottoText(winningLottoText);
        List<Integer> winningNumbers = winningLottoTextToWinningNumbers(winningLottoText);
        winningLotto = new Lotto(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
    
    private void validateWinningLottoText(String winningLottoText) throws IllegalArgumentException {
        if (winningLottoText.split(",").length != NUMBERS_PER_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력은 쉼표(,)로 구분했을 때 6개여야 합니다.");
        }
        for (String numberText : winningLottoText.split(",")) {
            if (numberText.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 각각이 0자 이상이어야 합니다.");
            }
        }
        for (String numberText : winningLottoText.split(",")) {
            if (!numberText.matches("[-0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 각각이 수여야 합니다.");
            }
        }
    }
    
    private List<Integer> winningLottoTextToWinningNumbers (String winningLottoText){
        List<Integer> winningNumbers = new ArrayList<Integer>();
        for (String numberText : winningLottoText.split(",")) {
            winningNumbers.add(Integer.parseInt(numberText));
        }
        return winningNumbers;
    }

    public void setBonusNumber(String bonusNumberText) throws IllegalArgumentException {
        validateBonusNumberText(bonusNumberText);
        int bonusNumber = Integer.parseInt(bonusNumberText);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    
    private void validateBonusNumberText(String bonusNumberText) throws IllegalArgumentException {
        if (bonusNumberText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1자 이상이어야 합니다.");
        }
        if (!bonusNumberText.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 수를 입력해야 합니다.");
        }
    }
    
    private void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45의 범위에 있어야 합니다.");
        }
        
        Set<Integer> winningNumberSet = new HashSet<Integer>(winningNumbers);
        winningNumberSet.add(bonusNumber);
        if (haveSameSize(winningNumberSet, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }
    
    private boolean isInRange(int number) {
        return (number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }
    private boolean haveSameSize(Set<Integer> set, List<Integer> list) {
        return set.size() == list.size();
    }
    
    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
    
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
