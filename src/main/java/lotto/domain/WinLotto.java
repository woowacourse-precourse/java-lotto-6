package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto{

    private final int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoPrize calculatePrize(Lotto lotto, int bonusNumber){
        int duplicatedCount = 0;
        for(int number: lotto.getNumbers()){
            if(this.getNumbers().contains(number)) duplicatedCount++;
        }

        return LottoPrize.findPrize(duplicatedCount, (bonusNumber == this.bonusNumber));
    }

    public void validate(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber))
            throw new IllegalArgumentException();
    }
}
