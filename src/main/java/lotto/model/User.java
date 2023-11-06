package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private List<Lotto> lottos;
    private Map<Result, Integer> result;

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
        for (Result rank : Result.values()) {
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
            Result rank = winningLotto.compareLotto(lotto);
            updateResult(rank);
        }
    }

    private void updateResult(Result rank) {
        int currentValue = result.get(rank);
        result.put(rank, currentValue + 1);
    }

    public String getResult() {
        String output = "";
        for (Result rank : result.keySet()) {
            output += rank.getMessage();
            output += " - ";
            output += result.get(rank);
            output += "개\n";
        }

        return output;
    }

    public String calculateProfitPercentage(PurchaseAmount purchaseAmount) {
        long prize = calculatePrize();
        return purchaseAmount.calculateProfitPercentage(prize);
    }

    private long calculatePrize() {
        long prize = 0;

        for (Result rank : result.keySet()) {
            prize += result.get(rank) * rank.getPrize();
        }

        return prize;
    }
}
