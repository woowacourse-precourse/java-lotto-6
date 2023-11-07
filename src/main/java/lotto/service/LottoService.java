package lotto.service;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoWinningBonusNumber;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.InputBonusNumber;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.PurchasedLottoDTO;

public class LottoService {
    private static PurchasedLottoNumbers purchasedLottoNumbers;
    private static LottoWinningNumbers lottoWinningNumbers;
    private static LottoWinningBonusNumber lottoWinningBonusNumber;

    public static void inputMoneyAndIssueLotto(InputMoney inputMoney) {
        User user = new User(inputMoney.getMoney());
        lottoGenerator(user.getAmount());
    }

    public static List<Lotto> lottoGenerator(int purchaseAmount) {
        int pickCount = purchaseAmount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < pickCount; i++) {
            List<Integer> purchasedOneLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sort(purchasedOneLotto);
            Lotto lotto = new Lotto(purchasedOneLotto);
            purchasedLotto.add(lotto);
        }
        purchasedLottoNumbers = new PurchasedLottoNumbers(purchasedLotto);
        return purchasedLotto;
    }

    public static void inputWinningLotto(InputWinningNumbers inputWinningNumbers) {
        lottoWinningNumbers = new LottoWinningNumbers(inputWinningNumbers.getInputWinningNumbers());
    }

    public static void inputBonusLotto(InputBonusNumber inputBonusNumber) {
        lottoWinningBonusNumber = new LottoWinningBonusNumber(inputBonusNumber.getInputBonusNumber(), lottoWinningNumbers.getWinningNumbers());
    }



    public static PurchasedLottoDTO purchasedLottoToDTO() {
        int purchasedLottoCount = purchasedLottoNumbers.getPurchasedLotto().size();
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            purchasedLotto.add(purchasedLottoNumbers.getPurchasedLotto().get(i));
        }
        return new PurchasedLottoDTO(purchasedLotto);
    }
}
