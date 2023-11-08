package lotto.Domain;

import java.util.*;

public class Referee {
    private final List<Integer> answerNumbers;
    private final int bonusNumber;
    private boolean bonusNumberMatch = false;

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    public int getBonusNumbers() {
        return bonusNumber;
    }

    public Referee(List<Integer> answerNumbers, int bonusNumber) {
        Lotto.dupulicationCheck(answerNumbers);
        Lotto.validate(answerNumbers);
        this.bonusNumber = bonusNumber;
        this.answerNumbers = answerNumbers;
    }

    public int compare(List<Integer> lottoPlayer) {
        int matchingNumbers = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (lottoPlayer.contains(answerNumbers.get(i))) {
                matchingNumbers++;
            }
        }
        if (matchingNumbers == 5 && lottoPlayer.contains(bonusNumber)) {
            bonusNumberMatch = true;
        }
        return matchingNumbers;
    }

    public boolean getBonusNumber() {
        return bonusNumberMatch;
    }
}
