package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientLottoData {
    private int price;
    private int lottoTicketCount;
    private List<Lotto> lottos = new ArrayList<>();
    private List<RankTable> matchLottoCalculate;

    public void setLottoTicketNumber(int money) {
        this.lottoTicketCount = money / 1000;
    }

    public void setLottoTicket(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(new ArrayList<>(numbers));
            Lotto lotto = new Lotto(numbers);
            this.lottos.add(lotto);
        }
    }

    public double setIncome() {
        double outputPrice = 0;
        for (RankTable rankTable : matchLottoCalculate) {
            outputPrice += rankTable.getMoney();
        }
        return Math.round(outputPrice / price * 1000) / 10d;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<RankTable> getMatchLottoCalculate() {
        return matchLottoCalculate;
    }

    public void setMatchLottoCalculate(List<RankTable> matchLottoCalculate) {
        this.matchLottoCalculate = matchLottoCalculate;
    }
}
