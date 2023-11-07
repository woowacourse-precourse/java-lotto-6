package lotto.view.outputView;


import lotto.model.lotto.LottoTicket;

public class LottoOutputView {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";

    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE + "%n", lottoTicketCount);
    }

    public void printLottos(LottoTicket lottoTicket){
        System.out.println(lottoTicket.toString());
    }

}
