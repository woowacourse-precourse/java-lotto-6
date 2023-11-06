package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private List<Lotto> lottos;
    private Map<Rank, Integer> result;

    private User(int numberOfLotto) {
        lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(new ArrayList<>(lottoNumber));
            lottos.add(lotto);
        }

        setResult();
    }

    private void setResult() {
        result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public static User purchaseLottos(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.divideByThousand();
        return new User(numberOfLotto);
    }

    public String getAllLottoTicketsNumbers() {
        String result = "";

        for (Lotto lotto : lottos) {
            result += lotto.getLottoNumbers();
            result += "\n";
        }

        return result;
    }

    public int getNumberOfLottoTickets() {
        return lottos.size();
    }

    public void compareLottos(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compareLotto(lotto);
            updateResult(rank);
        }
    }

    private void updateResult(Rank rank) {
        int currentValue = result.get(rank);
        result.put(rank, currentValue + 1);
    }

    public String getResult() {
        String output = "";
        for (Rank rank : result.keySet()) {
            if (rank != Rank.MISS) {
                output += rank.getMessage();
                output += " - ";
                output += result.get(rank);
                output += "개\n";
            }
        }

        return output;
    }

    public String calculateProfitPercentage(PurchaseAmount purchaseAmount) {
        long prize = calculatePrize();
        return purchaseAmount.calculateProfitPercentage(prize);
    }

    private long calculatePrize() {
        long prize = 0;

        for (Rank rank : result.keySet()) {
            prize += result.get(rank) * rank.getPrize();
        }

        return prize;
    }
}
