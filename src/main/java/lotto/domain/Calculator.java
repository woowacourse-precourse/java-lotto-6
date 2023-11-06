package lotto.domain;

import java.util.List;

public class Calculator {
    private static final int LOTTO_LENGTH = 6;
    private Result result;

    public void calculateResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        for(int i=0; i<lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getLottoNumbers();
            int correctCount = 0;
            boolean correctBonus = false;
            for(int j=0; j<LOTTO_LENGTH; j++) {
                if (lottoNumbers.contains(winningNumber.get(j))){
                    correctCount++;
                }
                if(lottoNumbers.contains(bonusNumber)){
                    correctBonus = true;
                }
            }
        }
    }

}
