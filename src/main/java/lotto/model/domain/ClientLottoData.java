package lotto.model;

import java.util.List;

public class ClientLottoData {
    public int price;
    public int lottoTicketCount;
    public List<Lotto> lottos;
    public List<RankTable> matchLottoCalculate;

    public ClientLottoData(int price, int lottoTicketCount) {
        this.price = price;
        this.lottoTicketCount = lottoTicketCount;
    }
}
