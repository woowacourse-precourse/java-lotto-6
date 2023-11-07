package lotto.domain;

import java.util.List;

public class Player {
    private List<Lotto> lottoTickets;
    private State state;
    private Asset asset;

    public Player(Asset asset){
        this.asset = asset;
        this.state = new State();
        this.lottoTickets = LottoMachine.issuedLotto(asset.getMoney());
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
    public void updatePlayer(List<Grade> grades){
        grades.stream()
                .filter(grade -> grade != Grade.NOTHING)
                .forEach( grade -> {
                    this.setState(grade);
                    this.setAsset(grade);
                });

    }
}
