package lotto.domain;

import lotto.service.Execute;
import lotto.service.LottoMachine;

import java.util.List;

public class Player {
    private List<Lotto> lottoTickets;
    private State state;
    private Asset asset;

    public Player(Asset asset){
        this.asset = asset;
        this.state = new State();
        this.lottoTickets = LottoMachine.buyLotto(asset.getMoney());
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public Asset getAsset() {
        return asset;
    }

    public State getState() {
        return state;
    }

    public void setAsset(Grade grade) {
        this.asset.increaseIncome(grade);
    }

    public void setState(Grade grade) {
        state.setGradeState(grade);
    }
}
