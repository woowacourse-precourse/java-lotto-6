package lotto.view;

import lotto.constants.LottoConstant;
import lotto.constants.OutputMessage;
import lotto.model.Lotto;

import java.util.ArrayList;

public class Output {
    String [] outputMessage;

    public Output() {
        outputMessage = new String[LottoConstant.LOTTO_SIZE.getConstant() + 2];
        outputMessage[3] = OutputMessage.PRINT_FIFTH_PRIZE.getOutputMessage();
        outputMessage[4] = OutputMessage.PRINT_FOURTH_PRIZE.getOutputMessage();
        outputMessage[5] = OutputMessage.PRINT_THIRD_PRIZE.getOutputMessage();
        outputMessage[6] = OutputMessage.PRINT_SECOND_PRIZE.getOutputMessage();
        outputMessage[7] = OutputMessage.PRINT_FIRST_PRIZE.getOutputMessage();
    }

    public void printLotteryNumber(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size() + OutputMessage.PRINT_BUY_LOTTO_SIZE.getOutputMessage());
        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printLottoProfit(int [] lottoSameSize) {
        System.out.println(OutputMessage.PRINT_RESULT_PREVIOUS_MESSAGE.getOutputMessage());
        for(int i=3;i<lottoSameSize.length;i++) {
            System.out.println(outputMessage[i] + lottoSameSize[i] + "개");
        }
    }

    //
    public void printEarningRate(double earningsRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningsRate) + "%입니다.");
    }
}
