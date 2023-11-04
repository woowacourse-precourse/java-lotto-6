package lotto;

import java.util.ArrayList;
import java.util.List;

public class View {
    private interface Messages {
        String PRICE_INPUT_GUIDE = "구입금액을 입력해 주세요.";
        String WINNING_NUMBER_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
        String BONUS_NUMBER_INPUT_GUIDE = "보너스 번호를 입력해 주세요.";
        String TICKET_AMOUNT = "개를 구매했습니다.";
        String RESULT_TITLE = "당첨 통계\n---";
        String AMOUNT = "개";
        String RATE_OF_RETURN_HEAD = "총 수익률은 ";
        String RATE_OF_RETURN_TAIL = "%입니다.";
    }

    List<String> hitResultMessages = new ArrayList<>(){{
        add("3개 일치 (5,000원) - ");
        add("4개 일치 (50,000원) - ");
        add("5개 일치 (1,500,000원) - ");
        add("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        add("6개 일치 (2,000,000,000원) - ");
    }};

    public void priceInputGuideMsg() {
        System.out.println(Messages.PRICE_INPUT_GUIDE);
    }

    public void printLottoInfo(List<Lotto> tickets) {
        System.out.println(tickets.size() + Messages.TICKET_AMOUNT);

        for (Lotto ticket : tickets) {
            printLottoNumbers(ticket);
        }
    }

    private void printLottoNumbers(Lotto ticket) {
        System.out.println(ticket);
    }

    public void winningNumberInputGuideMsg() {
        System.out.println(Messages.WINNING_NUMBER_INPUT_GUIDE);
    }

    public void bonusNumberInputGuideMsg() {
        System.out.println(Messages.BONUS_NUMBER_INPUT_GUIDE);
    }

    public void hitResultTitle() {
        System.out.println(Messages.RESULT_TITLE);
    }

    public void printHitResult(List<Integer> result) {
        for (int idx = 0; idx < result.size(); idx++) {
            System.out.println(hitResultMessages.get(idx) + result.get(idx) + Messages.AMOUNT);
        }
    }

    public void printRateOfReturn(double rate) {
        System.out.println(Messages.RATE_OF_RETURN_HEAD + rate + Messages.RATE_OF_RETURN_TAIL);
    }
}
