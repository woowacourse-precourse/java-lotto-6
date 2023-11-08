package lotto;

import lotto.Lotto;

public class OutputView {
    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(int count, Lotto randomLottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        
        for (int i = 0; i < count; i++)
            System.out.println(randomLottoNumbers);
    }

    
}
