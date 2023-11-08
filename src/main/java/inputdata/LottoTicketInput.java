package inputdata;


public class LottoTicketInput {
    // 로또 티켓 가격 입력
    private int lottoTicketPrice;

    public LottoTicketInput(int lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }
    public void setLottoTicketPrice(int lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }

    public int getLottoTicketPrice() {
        return lottoTicketPrice;
    }
}
