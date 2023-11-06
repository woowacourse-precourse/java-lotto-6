package lotto.view;

import lotto.constant.InformationMessage;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printErrorMessage(Exception exception) {
        print(exception.getMessage());
    }

    public void printLottoReceipt(LottoReceiptDto lottoReceipt) {
        print(String.format(
                InformationMessage.PURCHASE_LOTTO_COUNT_FORMAT.getMessage(),
                lottoReceipt.purchaseCount()
        ));
        printLottos(lottoReceipt.lottos());
    }

    private void printLottos(List<LottoDto> lottos) {
        for (LottoDto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(LottoDto lotto) {
        print(lotto.numbers().toString());
    }

    public void printLottoResult(LottoResultDto lottoResult) {
        printResult(lottoResult.result());
        printProfitRate(lottoResult.profitRate());
    }

    private void printResult(Map<LottoRank, Integer> result) {
        for (LottoRank lottoRank : result.keySet()) {
            printRank(lottoRank, result.get(lottoRank));
        }
    }

    private void printRank(LottoRank rank, int count) {
        String format = InformationMessage.GENERAL_RANK_RESULT_FORMAT.getMessage();
        if(rank.equals(LottoRank.FIVE_AND_BONUS_MATCH)) {
            format = InformationMessage.SECOND_RANK_RESULT_FORMAT.getMessage();
        }

        print(String.format(
                format,
                rank.getMatchedNumberCount(),
                rank.getPrizeMoney(),
                count
        ));
    }

    private void printProfitRate(double profitRate) {
        print(String.format(
                InformationMessage.PROFIT_RATE_FORMAT.getMessage(),
                profitRate
        ));
    }

    public void printNewLine() {
        print("");
    }

    public void print(String message) {
        System.out.println(message);
    }
}
