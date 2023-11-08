package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int lottoTicketCnt = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final List<Lotto> lottoTicketsNums = new ArrayList<>();
    private static List<Integer> lotteryNums;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.getPriceMessage();
        lottoTicketCnt = Input.inputPrice(LOTTO_PRICE) / LOTTO_PRICE;
        Output.viewTicketCountMessage(lottoTicketCnt);

        while (lottoTicketCnt > 0) {
            lottoTicketsNums.add(new Lotto(NumberPicker.getRandomNum()));
            lottoTicketCnt--;
        }

        for (Lotto numberGroup : lottoTicketsNums) {
            Output.viewlottoTicketNumList(numberGroup);
        }

        Output.getLotteryNumsMessage();
        lotteryNums = Input.inputLotteryNums();
        Output.getBonusNumMessage();
        int bonusNum = Input.inputBonusNum(lotteryNums);

        for (Lotto lottoTicketNums : lottoTicketsNums) {
            Compare.readWinning(lottoTicketNums, lotteryNums, bonusNum);
        }
//        int rate = 수익률;
//
        Output.viewResult();
//        Output.viewRate(rate);
    }
}
