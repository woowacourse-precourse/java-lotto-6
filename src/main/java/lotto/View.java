package lotto;

import java.util.ArrayList;
import java.util.List;

public class View {
    List<String> hitResultMessages = new ArrayList<>(){{
        add("3개 일치 (5,000원) - ");
        add("4개 일치 (50,000원) - ");
        add("5개 일치 (1,500,000원) - ");
        add("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        add("6개 일치 (2,000,000,000원) - ");
    }};

    public void priceInputGuideMsg() {
        System.out.println(Messages.PRICE_INPUT_GUIDE.getMsg());
    }

    public void printLottoInfo(List<Lotto> tickets) {
        System.out.println(tickets.size() + Messages.TICKET_AMOUNT.getMsg());

        for (Lotto ticket : tickets) {
            printLottoNumbers(ticket);
        }
    }

    private void printLottoNumbers(Lotto ticket) {
        System.out.println(ticket);
    }

    public void winningNumberInputGuideMsg() {
        System.out.println(Messages.WINNING_NUMBER_INPUT_GUIDE.getMsg());
    }

    public void bonusNumberInputGuideMsg() {
        System.out.println(Messages.BONUS_NUMBER_INPUT_GUIDE.getMsg());
    }

    public void hitResultTitle() {
        System.out.println(Messages.RESULT_TITLE.getMsg());
    }

    public void printHitResult(List<Integer> result) {
        for (int idx = 0; idx < result.size(); idx++) {
            System.out.println(hitResultMessages.get(idx) + result.get(idx) + Messages.AMOUNT.getMsg());
        }
    }

    public void printRateOfReturn(double rate) {
        System.out.println(Messages.RATE_OF_RETURN_HEAD.getMsg() + rate + Messages.RATE_OF_RETURN_TAIL.getMsg());
    }
}
