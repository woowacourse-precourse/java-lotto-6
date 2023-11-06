package lotto.model;

import lotto.dto.LottoDto;

import java.util.List;

// 전체적인 게임 정보를 관리하기 위한 클래스
public class Game {
    private Profit profit;
    private Player player;

    public Game(int cost) {
        this.profit = new Profit(cost);
        this.player = new Player(profit.getLottoCount());
    }

    public void winTheGame(int grade) {
        if(grade < 3) return;
        this.addPrize(grade);
        this.updateInfo(grade);
    }

    // 초기 비용으로 구매한 로또의 수량을 구함
    public int getLottoQuantity() {
        return this.profit.getLottoCount();
    }

    // 로또를 통한 수익을 백분율로 구함
    public double getGameProfit() {
        return this.profit.getProfit();
    }

    // 임의로 생성된 로또를 구매
    public void buyLotto(List<Integer> numbers) {
        this.player.addLotto(numbers);
    }

    // 사용자가 구매한 로또 번호를 조회
    public List<LottoDto> getLottoNumbers() {
        return this.player.getLottoNumbers();
    }

    // 사용자의 로또 결과를 조회
    public List<Integer> getResultInfo() {
        return this.player.getResults();
    }

    // 일치하는 숫자의 개수와 보너스 숫자 일치 여부에 따라서 상금을 더함
    private void addPrize(int grade) {
        this.profit.addPrizeByGrade(grade);
    }

    // 등수에 따른 결과 최신화
    private void updateInfo(int grade) {
        this.player.updateResult(grade);
    }
}
