package lotto.view;

import lotto.domain.*;

import java.util.List;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTicket(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getTicket()) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            String lottoLetter = makeSentence(convertToStringList(lottoNumbers));
            System.out.println(lottoLetter);
        }
    }

    private static List<String> convertToStringList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .toList();
    }

    private static String makeSentence(List<String> lottoNumbers) {
        String lottoNumbersLetter = String.join(", ", lottoNumbers);
        return String.format("[%s]",lottoNumbersLetter);
    }

    public static void printResultMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void printWinningStatistic(WinningResults winningResults){
        for(Rank rank : Rank.getWithoutLosingTicket() ){
            if (rank != Rank.LOSING_TICKET)
                System.out.println(rank.getMatchCount() + "개 일치"
                        + rank.getStringAmount() + " - "
                        + winningResults.getWinningResult().getOrDefault(rank, 0) + "개");
        }
    }

    public static void printProfit(double profit) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }
}
