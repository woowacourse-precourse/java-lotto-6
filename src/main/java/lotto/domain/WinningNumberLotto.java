package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberLotto {

    private static final int WINNING_NUMBER_SIZE = 7;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumberLotto(List<Integer> inputWinningNumbers, int inputBonusNumber){
        this.winningNumbers = new Lotto(inputWinningNumbers);
        this.bonusNumber = inputBonusNumber;
    }

    private void validateDuplicate(List<Integer> inputWinningNumbers, int bonusNumber){
        Set<Integer> compareNumbers = new HashSet<>(inputWinningNumbers);
        compareNumbers.add(bonusNumber);
        if(compareNumbers.size() != WINNING_NUMBER_SIZE){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateNumberRange(int number){
        if(!(number <= LOTTO_MAX && number >= LOTTO_MIN)){
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45까지 입니다.");
        }
    }
}
