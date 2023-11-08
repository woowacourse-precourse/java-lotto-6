package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final List<Lotto> DEFAULT_LOTTO_LIST = new ArrayList<>();

    private static final Long DEFAULT_TOTAL_PRIZE = Long.valueOf(0);

    private List<Lotto> lottoList;

    private Long totalAmount;

    private Long totalPrize;

    public User(Long totalAmount){
        this.lottoList = DEFAULT_LOTTO_LIST;
        this.totalAmount = totalAmount;
        this.totalPrize = DEFAULT_TOTAL_PRIZE;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
    public Long getTotalAmount(){
        return totalAmount;
    }

    public Long getTotalPrize(){
        return totalPrize;
    }

    public void buyLotto(Long amountOfLottoPapers){
        for (int i = 0; i < amountOfLottoPapers; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
    }

    public void matchLotto(Winner winner){
        List<Integer> winnerNumbers = winner.getNumbers();
        Integer bonusNumber = winner.getBonusNumber();

        lottoList.forEach(lotto -> {
            List<Integer> myNumbers = lotto.getNumbers();
            Rank rank = assignRank(myNumbers,winnerNumbers,bonusNumber);
            lotto.setRank(rank);
            totalPrize += rank.getPrize();
        });
    }
    public Rank assignRank(List<Integer> myNumbers, List<Integer> winnerNumbers, Integer bonusNumber){
        Integer matchingNumberCount = (int) myNumbers.stream()
                .filter(number -> winnerNumbers.contains(number))
                .count();
        switch (matchingNumberCount) {
            case 6:
                return Rank.FIRST;
            case 5:
                if (myNumbers.contains(bonusNumber)){
                    return Rank.SECOND;
                }
                return Rank.THIRD;
            case 4:
                return Rank.FORTH;
            case 3:
                return Rank.FIFTH;
            default:
                return Rank.NONE;
        }
    }
}
