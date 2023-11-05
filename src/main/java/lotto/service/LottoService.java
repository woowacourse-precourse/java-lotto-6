package lotto.service;

import lotto.constant.LottoConstraint;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import lotto.random.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    private WinningLotto winningLotto;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public LottoReceiptDto getLottoReceipt(int amount) {
        int purchaseLottoCount = getPurchaseLottoCount(amount);
        purchaseLottos(purchaseLottoCount);
        return LottoReceiptDto.from(purchaseLottoCount, purchasedLottos);
    }

    private int getPurchaseLottoCount(int amount) {
        Payment payment = new Payment(amount);
        return payment.calculatePurchaseLottoCount();
    }

    private void purchaseLottos(int purchaseLottoCount) {
        for (int count = 0; count < purchaseLottoCount; count++) {
            List<Integer> generatedNumbers = generateLottoNumbers();
            purchasedLottos.add(new Lotto(generatedNumbers));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return randomNumberGenerator.pickUniqueNumbersInRange(
                LottoConstraint.MIN_LOTTO_NUMBER.getValue(), LottoConstraint.MAX_LOTTO_NUMBER.getValue()
        );
    }

    public void generateWinningLottoWithoutBonusNumber(List<Integer> winningLottoNumbers) {
        winningLotto = new WinningLotto(winningLottoNumbers);
    }

    public void generateWinningLotto(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public LottoResultDto getLottoResult() {
        return new LottoResultDto();
    }
}