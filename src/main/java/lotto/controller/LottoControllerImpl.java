package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoControllerImpl implements LottoController {
    public LottoControllerImpl(Console console, LottoService lottoService) {
        this.console = console;
        this.lottoService = lottoService;
    }

    private final Console console;
    private final LottoService lottoService;

    @Override
    public void play() {
        int payment = 0;
        int lotteryCount;
        List<Lotto> purchasedLotteries = new ArrayList<>();
        Lotto winningNumbers = null;
        int bonusNumber = 0;

        // 구입 금액\n
        while ( payment == 0 ) {
            try {
                payment = lottoService.parsePayment(console.inputPayment());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lotteryCount = payment / 1000;

        // 구입한 복권 생성
        for (int i = 0; i < lotteryCount; i++) {
            purchasedLotteries.add(lottoService.generatePurchasedLottery());
        }

        // n개를 구입했습니다.\n
        console.displayPurchasedLotteryCount(lotteryCount);

        // 로또 번호 출력
        for (Lotto lottery : purchasedLotteries) {
            console.displayPurchasedLottery(lottery.getNumbers());
        }
        System.out.println();

        // 당첨 번호를 입력해주세요.\n
        while (winningNumbers == null) {
            try {
                winningNumbers = lottoService.parseWinningNumbers(console.inputWinningNumbers());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 보너스 번호를 입력해주세요.\n
        // 당첨 번호에 이미 보너스 번호가 있으면 안됨
        while (bonusNumber == 0) {
            try {
                bonusNumber = lottoService.parseBonusNumber(console.inputBonusNumber(), winningNumbers);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 대조 결과
        List<Integer> matchResult = lottoService.lotteryMatch(purchasedLotteries, winningNumbers, bonusNumber);
        double rateOfReturn = lottoService.getRateOfReturn(payment, lottoService.calculateReward(matchResult));

        // 당첨 통계
        console.displayResult(matchResult, rateOfReturn);
    }
}
