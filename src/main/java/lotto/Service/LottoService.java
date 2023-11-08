package lotto.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.BonusNumber;
import lotto.Domain.Lotto;
import lotto.Domain.LottoResult;
import lotto.Domain.Money;
import lotto.Domain.LottoNumbers;

public class LottoService {

    private static final int STANDARD_UNIT = 1000;

    public List<LottoNumbers> generateLottoNumbers(Money money) {
        int purchaseAmount = money.getPurchaseAmount();
        int numberOfTickets = purchaseAmount / STANDARD_UNIT;
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoTickets.add(lottoNumbers);
        }

        return lottoTickets;
    }

    public List<LottoResult> playLottoGame(Money money, LottoNumbers lottoNumbers, Lotto winningLotto,
                                           int bonusNumber) {
        int numberOfDraws = money.getPurchaseAmount() / STANDARD_UNIT;
        List<LottoResult> results = new ArrayList<>();

        for (int draw = 1; draw <= numberOfDraws; draw++) {
            List<Integer> userNumbers = lottoNumbers.getNumbers();

            int matchedNumbers = countMatchedNumbers(userNumbers, winningLotto.getNumbers());
            boolean matchedBonusNumber = userNumbers.contains(bonusNumber);

            LottoResult result = new LottoResult(matchedNumbers, matchedBonusNumber);
            results.add(result);
        }
        return results;
    }

    private int countMatchedNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int matchedNumber = 0;

        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                matchedNumber++;
            }
        }
        return matchedNumber;
    }
}