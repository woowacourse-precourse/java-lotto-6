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

    private Map<WinningPrice, List<Lotto>> setInitialLotto() {
        Map<WinningPrice, List<Lotto>> lotto = new LinkedHashMap<>();
        Arrays.stream(WinningPrice.values()).toList().forEach(grade -> {
            List<Lotto> emptyLotto = new ArrayList<>();
            lotto.put(grade, emptyLotto);
        });

        return lotto;
    }

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

    public Map<WinningPrice, List<Lotto>> checkWinningResult(List<Integer> winningNumbers, Integer bonusNumber) {
        List<Lotto> lottos = popNoneValue(lotto);
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

    private List<Lotto> popNoneValue(Map<WinningPrice, List<Lotto>> lotto) {
        List<Lotto> lottos = lotto.get(WinningPrice.NONE);
        lotto.remove(WinningPrice.NONE);
        lotto.put(WinningPrice.NONE, new ArrayList<>());
        return lottos;
    }

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
            addSumEarnings(price);
        }));

        Double earningsRate = (double) earnings / this.price * 100.0;
        return Math.round(earningsRate * 10) / 10.0;
    }

    private void addSumEarnings(Long price) {
        this.earnings += price;
    }
}
