package lotto.model;

import lotto.util.LottoNumberGenerator;
import lotto.util.NumberGenrator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoNumbers;

    public Lottos(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public List<Integer> calcurateLottoResult(WinningNumber winningNumber) {
        List<Integer> lottoPrizes = new ArrayList<>();
        lottoNumbers.stream().forEach(lotto -> {
            lottoPrizes.add(matchingWinningNumbers(lotto.getNumbers(), winningNumber.getWinningNumbers()));
        });
        return lottoPrizes;
    }
    
    private static int matchingWinningNumbers(List<Integer> purchaseLottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for(int number : purchaseLottoNumbers) {
            if(winningNumbers.contains(number)) count += 1;
        }
        return count;
    }
}
