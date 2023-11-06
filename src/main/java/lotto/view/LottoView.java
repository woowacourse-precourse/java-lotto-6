package lotto.view;

import java.util.List;

public class LottoView {

    private String inputBuyLottoMoneyMessage = "구입금액을 입력해 주세요.";
    private String lottoCountMessage = "개를 구매했습니다.";
    private String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    private String inputBonusNumberMessage = "당첨 번호를 입력해 주세요.";

    public void printStartMessage() {
        System.out.println(inputBuyLottoMoneyMessage);
    }

    public void printLottoTicketCount(int lottoCount) {
        System.out.println(lottoCount + lottoCountMessage);
    }

    public void printLottoNumbers(List<List<Integer>> lottos) {
        lottos.forEach(lottoNumbers -> {
            System.out.println(lottoNumbers.toArray());
        });
    }

    public void printEnterLine() {
        System.out.println();
    }

    public void printWinningNumberMessage() {
        System.out.println(inputWinningNumberMessage);
    }

    public void printBonusNumberMessage() {
        System.out.println(inputBonusNumberMessage);
    }

}
