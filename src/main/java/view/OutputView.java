package view;

import java.util.List;
import java.util.stream.Collectors;
import message.InformationMessages;
import message.OutputSign;
import model.EarningRate;
import model.Lotto;
import model.LottoPrize;
import model.Prize;

public class OutputView {

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(InformationMessages.PURCHASE_MESSAGE, lottos.size());
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(OutputSign.START_SYMBOL + LottoWithDelimiter(lotto) + OutputSign.END_SYMBOL);
        }
        System.out.println();
    }

    public void printAllWinningStatistics(LottoPrize lottoPrize) {
        System.out.println(InformationMessages.WINNING_STATISTICS);
        System.out.println(InformationMessages.SENTENCE_DELIMITER);
        for (Prize prize : Prize.values()) {
            branchPrintWinningStatistics(lottoPrize, prize);
        }
    }

    public void printEarningRate(EarningRate earningRate) {
        System.out.printf(InformationMessages.EARNING_RATE_MESSAGE, earningRate.getEarningRate());
    }

    public void branchPrintWinningStatistics(LottoPrize lottoPrize, Prize prize) {
        if (prize == Prize.NO) {
            return;
        }
        if (prize.getBonus()) {
            branchBonus(lottoPrize, prize);
        }
        if (lottoPrize.isWinning(prize)) {
            printWinning(prize, lottoPrize.getWinningCount(prize));
            return;
        }
        printNotWinning(prize);
    }

    public String addThousandSeparator(int priceNumber) {
        String price = String.valueOf(priceNumber);
        return price.replaceAll("\\B(?=(\\d{3})+(?!\\d))", OutputSign.THOUSAND_SEPARATOR); //3자릿 수 마다 "," 문자 추가
    }

    public void printNotWinning(Prize prize) {
        System.out.printf(InformationMessages.WINNING_RESULT, prize.getWinNumberCount(),
                addThousandSeparator(prize.getPrice()), 0);
    }

    public void printWinning(Prize prize, int count) {
        System.out.printf(InformationMessages.WINNING_RESULT, prize.getWinNumberCount(),
                addThousandSeparator(prize.getPrice()), count);
    }

    public void branchBonus(LottoPrize lottoPrize, Prize prize) {
        if (lottoPrize.isWinning(prize)) {
            printWinningWithBonus(prize, lottoPrize.getWinningCount(prize));
            return;
        }
        printWinningWithBonus(prize, 0);
    }

    public void printWinningWithBonus(Prize prize, int count) {
        System.out.printf(InformationMessages.WINNING_RESULT_BONUS, prize.getWinNumberCount(),
                addThousandSeparator(prize.getPrice()), count);
    }

    public String LottoWithDelimiter(Lotto lotto) {
        return lotto.getNumbers().stream().map(number -> String.valueOf(number))
                .collect(Collectors.joining(OutputSign.DELIMITER));
    }
}

