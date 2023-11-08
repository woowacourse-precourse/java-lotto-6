package lotto.view;

import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class Output {
    private final LottoRepository lottoRepository;

    public Output(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void printGameResult(int[] rank) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(EnumOutput.PRINT_RANK_5.getMessage() + rank[4] + "개");
        System.out.println(EnumOutput.PRINT_RANK_4.getMessage() + rank[3] + "개");
        System.out.println(EnumOutput.PRINT_RANK_3.getMessage() + rank[2] + "개");
        System.out.println(EnumOutput.PRINT_RANK_2.getMessage() + rank[1] + "개");
        System.out.println(EnumOutput.PRINT_RANK_1.getMessage() + rank[0] + "개");
    }

    public void printGameResult(double earningsRate) {
        System.out.println(EnumOutput.PRINT_EARNINGS_RATE.getMessage() + earningsRate + "%입니다.");
    }

    public void printBuyNumberOfLotto() {
        System.out.println("\n" +
                lottoRepository.getNumberOfLotto() +
                EnumOutput.PRINT_NUMBER_OF_LOTTO.getMessage());
    }

    public void printGetLottoNumbers() {
        for(Lotto lotto : lottoRepository.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
