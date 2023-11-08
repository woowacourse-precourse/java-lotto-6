package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.User;
import lotto.domain.WinningBonusNumber;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.InputBonus;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.PurchasedLottoDTO;

public class LottoService {
    public static PurchasedLotto inputMoneyAndIssueLotto(InputMoney inputMoney) {
        User user = new User(inputMoney.getMoney());
        return lottoGenerator(user.getAmount());
    }

    public static PurchasedLotto lottoGenerator(int purchaseAmount) {
        int pickCount = purchaseAmount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < pickCount; i++) {
            Lotto lotto = new Lotto(generatePurchasedOneLotto());
            purchasedLotto.add(lotto);
        }
        return new PurchasedLotto(purchasedLotto);
    }

    private static List<Integer> generatePurchasedOneLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortPurchasedLotto = new ArrayList<>(lottoNumbers);
        Collections.sort(sortPurchasedLotto);
        return sortPurchasedLotto;
    }

    public static LottoResult compareLotto(WinningNumbers winningNumbers,
                                           WinningBonusNumber winningBonusNumber,
                                           PurchasedLotto purchasedLotto) {
        ResultService resultService = new ResultService(winningNumbers, winningBonusNumber);
        Map<LottoRank, Integer> lottoResult = resultService.lottoGuess(purchasedLotto);
        return new LottoResult(lottoResult);
    }

    public static WinningNumbers inputWinningLotto(InputWinningNumbers inputWinningNumbers) {
        return new WinningNumbers(inputWinningNumbers.getInputWinningNumbers());
    }

    public static WinningBonusNumber inputBonusLotto(WinningNumbers winningNumbers,
                                                     InputBonus inputBonus) {
        return new WinningBonusNumber(inputBonus.getInputBonusNumber(),
                winningNumbers.getWinningNumbers());
    }


    public static PurchasedLottoDTO purchasedLottoToDTO(PurchasedLotto purchasedLottoNumbers) {
        return new PurchasedLottoDTO(purchasedLottoNumbers.getPurchasedLotto());
    }
}
