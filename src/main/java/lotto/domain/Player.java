package lotto.domain;

import java.util.List;

public class Player {
    private List<Lotto> lottoTickets;
    private State state;
    private Asset asset;
    private Long ticketNum;

    public Player(Asset asset){
        this.asset = asset;
        this.state = new State();
        this.ticketNum = calTicketNum(asset.getMoney());
        this.lottoTickets = LottoMachine.issuedLotto(ticketNum);
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

    public Long getTicketNum() { return ticketNum; }

    public void setAsset(Grade grade) {
        asset.increaseIncome(grade);
    }

    public void setState(Grade grade) {
        state.setGradeState(grade);
    }

    public Long calTicketNum(Double money){
        long ticketNum = (long) (money / 1000);
        
        if(ticketNum > 100){
            throw new IllegalArgumentException("로또는 100장만 살 수 있습니다.");
        }
        return ticketNum;
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
