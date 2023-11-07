package lotto.service;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningBonusNumber;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.InputBonusNumber;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.LottoResultDTO;
import lotto.domain.dto.PurchasedLottoDTO;

public class LottoService {
    public static PurchasedLottoNumbers inputMoneyAndIssueLotto(InputMoney inputMoney) {
        User user = new User(inputMoney.getMoney());
        return lottoGenerator(user.getAmount());
    }

    public static PurchasedLottoNumbers lottoGenerator(int purchaseAmount) {
        int pickCount = purchaseAmount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < pickCount; i++) {
            List<Integer> purchasedOneLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sort(purchasedOneLotto);
            Lotto lotto = new Lotto(purchasedOneLotto);
            purchasedLotto.add(lotto);
        }
        PurchasedLottoNumbers purchasedLottoNumbers = new PurchasedLottoNumbers(purchasedLotto);
        return purchasedLottoNumbers;
    }

    public static LottoResult compareLotto(LottoWinningNumbers lottoWinningNumbers, LottoWinningBonusNumber lottoWinningBonusNumber, PurchasedLottoNumbers purchasedLottoNumbers) {
        ResultService resultService = new ResultService(lottoWinningNumbers, lottoWinningBonusNumber);
        Map<LottoRank, Integer> lottoResult = resultService.lottoGuess(purchasedLottoNumbers);
        return new LottoResult(lottoResult);
    }

    public static LottoWinningNumbers inputWinningLotto(InputWinningNumbers inputWinningNumbers) {
        return new LottoWinningNumbers(inputWinningNumbers.getInputWinningNumbers());
    }

    public static LottoWinningBonusNumber inputBonusLotto(LottoWinningNumbers lottoWinningNumbers, InputBonusNumber inputBonusNumber) {
        return new LottoWinningBonusNumber(inputBonusNumber.getInputBonusNumber(),
                lottoWinningNumbers.getWinningNumbers());
    }


    public static PurchasedLottoDTO purchasedLottoToDTO(PurchasedLottoNumbers purchasedLottoNumbers) {
        int purchasedLottoCount = purchasedLottoNumbers.getPurchasedLotto().size();
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            purchasedLotto.add(purchasedLottoNumbers.getPurchasedLotto().get(i));
        }
        return new PurchasedLottoDTO(purchasedLotto);
    }
}
