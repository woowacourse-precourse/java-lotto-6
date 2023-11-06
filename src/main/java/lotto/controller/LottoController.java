package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.NumberGenerator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final int lottoPrice = 1000;

    private NumberGenerator lottoGenerator;

    public LottoController(NumberGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {

        // 구입할 금액 입력받기
        int purchaseAmount = InputView.inputPurchaseAmount();


        // 금액만큼 로또 생성
        Lottos userLottos = purchaseLottos(purchaseAmount);


                // 구매한 로또 정렬해서 출력
        OutputView.printPurchaseLottos(userLottos.toDtos());


        // 당첨번호 입력받기
        Lotto winningNumbers = new Lotto(InputView.inputWinningNumber());


        // 보너스 번호 입력받기
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());


        // 담청 결과 구하기
        List<LottoResult> results = userLottos.getLottoWinningResult(winningNumbers, bonusNumber);


        // 당첨 통계 출력하기
        OutputView.printLottoResult(results);

        // 총 수익률 계산
        double totalEarningsRate = calculateTotalEarningsRate(results, purchaseAmount);

        // 총 수익률 계산
        OutputView.printTotalEarningsRate(totalEarningsRate);
    }

    private Lottos purchaseLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount/lottoPrice; i++) {
            lottos.add(new Lotto(lottoGenerator.generateNumbers()));
        }
        return new Lottos(lottos);
    }

    private double calculateTotalEarningsRate(List<LottoResult> results, int purchaseAmount) {
        Long totalPrize = results.stream()
                .map(LottoResult::parsePrizeAmount)
                .reduce((a, b) -> a + b)
                .orElse(0L);
        return ((double) totalPrize * 100) / (double) purchaseAmount;
    }

}
