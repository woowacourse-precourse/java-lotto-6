package lotto.view;

import java.util.List;
import lotto.constant.Delimiter;
import lotto.constant.OutputMessage;
import lotto.constant.ResultMessage;
import lotto.service.dto.ResultDTO;

public class OutputView {
    private void printNumberOfLotto(int numberOfLottos) {
        System.out.printf(OutputMessage.NUMBER_OF_LOTTO_BOUGHT.getMessage(), numberOfLottos);
    }

    private void printLottoNumbers(List<List<Integer>> lottos) {
        lottos.forEach(x -> {
                    System.out.println(String.join(Delimiter.SEQUENCE.getValue(), x.toString()));
                });
    }

    public void printStatistic(List<Integer> fifthToFirst) {
        for(ResultMessage resultMessage : ResultMessage.values()) {
            System.out.printf(resultMessage.getMessage() + System.lineSeparator(), fifthToFirst.get(resultMessage.ordinal()));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OutputMessage.PROFIT_RATE.getMessage(), profitRate);
    }

    public void printBoughtLottos(int numberOfLottos, List<List<Integer>> lottos) {
        printNumberOfLotto(numberOfLottos);
        printLottoNumbers(lottos);
    }

    public void printResult(ResultDTO resultDTO) {
        printStatistic(resultDTO.getResult());
        printProfitRate(resultDTO.getProfitRate());
    }
}
