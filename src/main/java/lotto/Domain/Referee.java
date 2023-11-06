package lotto.Domain;

import java.util.*;

public class Referee {

    private final List<Integer> answerNumbers;
    private final int bonusNumber;
    private static boolean bonusNumberMatch = false;


    public Referee(List<Integer> answerNumbers, int bonusNumber) {
        Lotto.dupulicationCheck(answerNumbers);
        Lotto.validate(answerNumbers);
        this.bonusNumber = bonusNumber;
        this.answerNumbers = answerNumbers;
    }

    public static int compare(List<Integer> answerNumbers, List<Integer> lottoPlayer, int bonusNumber) {
        int matchingNumbers = 0;

        for (int i = 0; i < answerNumbers.size(); i++) {
            if(lottoPlayer.contains(answerNumbers.get(i))) {
                matchingNumbers++;
            }
        }

        if (matchingNumbers == 5 && lottoPlayer.contains(bonusNumber)) {
            Referee.bonusNumberMatch = true;
        }

        return matchingNumbers;
    }
}
