package lotto;


import java.util.List;

public class Prize {
    private int total = 0;
    private List<Integer> winningNumbers;
    private List<Lotto> lottos;
    private int bonusNumber;
    private int totalPrize;

    public Prize(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
        this.totalPrize = getPrize();
    }


    }
}
