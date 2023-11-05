package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Converter;
import lotto.constant.ExceptionMessage;
import lotto.constant.Number;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.Rank;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    int paymentPrice;
    int ticketCount;
    List<Integer> winningNumbers;
    int bonusNumber;
    List<Lotto> lottos = new ArrayList<>();

    public void start() throws IllegalArgumentException {
        // 구입금액 받기
        OutputHandler.requirePaymentPrice();
        String paymentPriceInput = InputHandler.getInput();
        paymentPrice = Converter.pay(paymentPriceInput);

        OutputHandler.printEmptyLine();

        // 구입 개수 계산하기
        ticketCount = getTicketCount(paymentPrice);
        OutputHandler.sayTicketCount(ticketCount);

        // 구입 개수만큼 로또 발행하기
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputHandler.printLottoNumbers(lotto.getNumbers());
        }

        OutputHandler.printEmptyLine();

        // 당첨 번호 받기
        OutputHandler.requireWinningNumbers();
        String winningNumbersInput = InputHandler.getInput();
        if (winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        List<Integer> winningNumbers = Converter.winningNumbers(winningNumbersInput);
        if (winningNumbers.size() != Number.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_SIX_NUMBERS);
        }
        this.winningNumbers = winningNumbers;

        OutputHandler.printEmptyLine();

        // 보너스 번호 받기
        OutputHandler.requireBonusNumber();
        String bonusNumberInput = InputHandler.getInput();
        if (bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        int bonusNumber = Converter.bonusNumbers(bonusNumberInput);
        this.bonusNumber = bonusNumber;

        OutputHandler.printEmptyLine();

        // 당첨통계 출력
        Rank rank = new Rank();
        for (Lotto lotto : lottos) {
            LottoMatch lottoMatch = getLottoMatch(lotto, winningNumbers, bonusNumber);
            int matchCount = lottoMatch.getMatchCount();
            if (matchCount < 3) {
                continue;
            }
            if (matchCount == 3) {
                rank.addRank(5);
            }
            if (matchCount == 4) {
                rank.addRank(4);
            }
            if (matchCount == 5 && !lottoMatch.getBonusMatch()) {
                rank.addRank(3);
            }
            if (matchCount == 5 && lottoMatch.getBonusMatch()) {
                rank.addRank(2);
            }
            if (matchCount == 6) {
                rank.addRank(1);
            }
        }
        int rank1 = rank.getRank(1);
        int rank2 = rank.getRank(2);
        int rank3 = rank.getRank(3);
        int rank4 = rank.getRank(4);
        int rank5 = rank.getRank(5);

        OutputHandler.printWinningDetails(rank1, rank2, rank3, rank4, rank5);
        int winningPrice = rank1 * Number.RANK1_PRICE + rank2 * Number.RANK2_PRICE + rank3 * Number.RANK3_PRICE
                + rank4 * Number.RANK4_PRICE + rank5 * Number.RANK5_PRICE;
        double rateOfReturn = (double) winningPrice / paymentPrice;
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    int getTicketCount(int paymentPrice) throws IllegalArgumentException {
        if (paymentPrice < 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_POSITIVE_INTEGER);
        }
        if (paymentPrice % Number.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE);
        }
        return paymentPrice / Number.LOTTO_PRICE;
    }

    LottoMatch getLottoMatch(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = 0;
        boolean bonusMatch = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return new LottoMatch(matchCount, bonusMatch);
    }


}
