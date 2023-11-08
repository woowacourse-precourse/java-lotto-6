package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final List<Lotto> lottoTicketsNums = new ArrayList<>();
    private static Lotto lotteryNums;
    public static double totalWinningAmount = 0;

    public static void main(String[] args) {

        Output.getPriceMessage();
        double purchasePrice = Input.inputPrice(LOTTO_PRICE);
        int lottoTicketCnt = (int) (purchasePrice / LOTTO_PRICE);
        Output.viewTicketCountMessage(lottoTicketCnt);

        while (lottoTicketCnt > 0) {
            lottoTicketsNums.add(new Lotto(NumberPicker.getRandomNum()));
            lottoTicketCnt--;
        }

        for (Lotto numberGroup : lottoTicketsNums) {
            Output.viewlottoTicketNumList(numberGroup);
        }

        Output.getLotteryNumsMessage();
        lotteryNums = new Lotto(Input.inputLotteryNums());
        Output.getBonusNumMessage();
        int bonusNum = Input.inputBonusNum(lotteryNums);

        for (Lotto lottoTicketNums : lottoTicketsNums) {
            Compare.readWinningReturnAmount(lottoTicketNums, lotteryNums, bonusNum);
        }

        Output.viewResult();

        double rate = totalWinningAmount / purchasePrice * 100;
        Output.viewRate(rate);
    }
}
