package lotto;

import java.util.*;

public class Purchaser {
    private final Map<WinningPrice, List<Lotto>> lotto;
    private final Integer price;
    private final Integer numberOfLotto;
    private Long earnings;

    public Purchaser(Integer price) {
        Map<WinningPrice, List<Lotto>> lotto = setInitialLotto();
        this.lotto = lotto;
        this.price = price;
        this.earnings = 0L;
        this.numberOfLotto = calculateNumberOfLotto(price);
    }

    public Integer getNumberOfLotto(){
        return numberOfLotto;
    }

    private Integer calculateNumberOfLotto(Integer price) {
        return price / InputJudgement.getLottoPrice();
    }

    /**
     * 초기 로또의 당첨 상태를 None으로 세팅
     * @return None 상태로 세팅된 로또
     */
    private Map<WinningPrice, List<Lotto>> setInitialLotto() {
        Map<WinningPrice, List<Lotto>> lotto = new LinkedHashMap<>();
        Arrays.stream(WinningPrice.values()).toList().forEach(grade -> {
            List<Lotto> emptyLotto = new ArrayList<>();
            lotto.put(grade, emptyLotto);
        });

        return lotto;
    }

    /**
     * 구매 금액에 기반하여 로또 구매
     * @return 구매한 로또들
     */
    public List<Lotto> buy() {
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i< numberOfLotto; i++){
            lottos.add(Lotto.issue());
        }

        setIssueLotto(lottos);
        return lottos;
    }

    private void setIssueLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> this.lotto.get(WinningPrice.NONE).add(lotto));
    }

    /**
     * 로또 당첨번호와 보너스 번호를 기반으로 로또 당첨 상태를 갱신
     * @param winningNumbers 로또 당첨 번호
     * @param bonusNumber 보너스 번호
     * @return 당첨 상태가 갱신된 로또
     */
    public Map<WinningPrice, List<Lotto>> checkWinningResult(List<Integer> winningNumbers, Integer bonusNumber) {
        // 우선 None 상태인 로또를 모두 뽑아내고, 다시 작동하게 합니다.
        List<Lotto> lottos = popAllNoneValueLotto(lotto);
        Queue<Lotto> q = new LinkedList<>();
        q.addAll(lottos);

        while (!q.isEmpty()) {
            Lotto lotto = q.poll();
            Integer correctCount = calculateWinning(winningNumbers, lotto);
            boolean bonus = checkBonus(correctCount, lotto, bonusNumber);
            WinningPrice winningPrice = determineResult(correctCount, bonus);
            putResultLotto(winningPrice, lotto);
        }

        return this.lotto;
    }

    /**
     * None 상태의 로또를 모두 pop
     * @param lotto 구입한 로또
     * @return None 상태의 로또
     */
    private List<Lotto> popAllNoneValueLotto(Map<WinningPrice, List<Lotto>> lotto) {
        List<Lotto> lottos = lotto.get(WinningPrice.NONE);
        lotto.remove(WinningPrice.NONE);
        lotto.put(WinningPrice.NONE, new ArrayList<>());
        return lottos;
    }

    /**
     * 각 로또의 번호와 당첨 번호의 일치 개수 계산
     * @param winningNumbers 로또 당첨 번호
     * @param lotto 구입한 로또
     * @return 구입한 로또와 일치하는 구매 로또 번호의 개수
     */
    private Integer calculateWinning(List<Integer> winningNumbers, Lotto lotto) {
        Integer winningCount = 0;

        for (Integer winningNumber : winningNumbers) {
            winningCount += checkContains(winningNumber, lotto);
        }
        return  winningCount;
    }

    private Integer checkContains(Integer winningNumber, Lotto lotto) {
        if(lotto.getNumbers().contains(winningNumber)){
            return 1;
        }
        return 0;
    }

    /**
     * 보너스 번호의 일치 확인
     * @param correctCount 로또 당첨번호와 일치하는 번호의 개수
     * @param lotto 구매한 로또
     * @param bonusNumber 보너스 번호
     * @return 로또 당첨 번호와 일치하는 번호의 개수가 5개이고 보너스 번호가 일치하면 true 그렇지 않으면 false
     */
    private boolean checkBonus(Integer correctCount, Lotto lotto, Integer bonusNumber) {
        if(correctCount == 5 && lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }


    private WinningPrice determineResult(Integer correctCount, boolean bonus) {
        return WinningPrice.getWinningPrice(correctCount, bonus);
    }

    private void putResultLotto(WinningPrice winningPrice, Lotto lotto) {
        this.lotto.get(winningPrice).add(lotto);
    }

    public Double calculateEarningsRate() {
        lotto.forEach(((winningPrice, lottos) -> {
            Long price = WinningPrice.getPrice(winningPrice) * lottos.size();
            this.earnings += price;
        }));

        Double earningsRate = (double) earnings / this.price * 100.0;
        return Math.round(earningsRate * 10) / 10.0;
    }
}
