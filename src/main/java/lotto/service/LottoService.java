package lotto.service;

import lotto.constant.LottoConstraint;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
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

    private Payment payment;
    private WinningLotto winningLotto;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public LottoReceiptDto getLottoReceipt(long amount) {
        int purchaseLottoCount = getPurchaseLottoCount(amount);
        purchaseLottos(purchaseLottoCount);
        return LottoReceiptDto.from(purchaseLottoCount, purchasedLottos);
    }

    private int getPurchaseLottoCount(long amount) {
        payment = new Payment(amount);
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
                LottoConstraint.MIN_LOTTO_NUMBER.getValue(),
                LottoConstraint.MAX_LOTTO_NUMBER.getValue(),
                LottoConstraint.LOTTO_NUMBER_COUNT.getValue()
        );
    }

    public void drawLottoWithoutBonusNumber(List<Integer> winningLottoNumbers) {
        winningLotto = new WinningLotto(winningLottoNumbers);
    }

    public void drawBonusNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public LottoResultDto getLottoResult() {
        LottoResult lottoResult = initLottoResult();
        double profitRate = lottoResult.calculateProfitRate(payment);

        return new LottoResultDto(profitRate, lottoResult.getResult());
    }

    private LottoResult initLottoResult() {
        LottoResult lottoResult = new LottoResult();

        purchasedLottos.forEach(lotto -> {
                    Rank rank = winningLotto.calculateRank(lotto);
                    lottoResult.increaseLottoRankCount(rank);
                }
        );

        return lottoResult;
    }
}