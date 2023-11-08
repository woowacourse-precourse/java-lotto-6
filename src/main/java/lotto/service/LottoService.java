package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.type.Reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoService {

    private List<Lotto> buyLottoList = new ArrayList<>();
    private Lotto successLotto;
    private int bonusLottoNumber;

    public void buyLotto(int buyLotto) {
        System.out.println();
        System.out.println(buyLotto + "개를 구매했습니다.");
        for (int i = 0; i < buyLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lotto);
            buyLottoList.add(lotto);
        }
    }

    public void calcLotto() {
        HashMap<Reward, Integer> totalMoneyMap = new HashMap<>();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 0; i < Reward.values().length; i++) {
            totalMoneyMap.put(Reward.values()[i], 0);
        }

        for (Lotto l : buyLottoList) {
            int count = countMatchingLotto(l);
            if (count < 3) {
                continue;
            }
            Reward reward = Reward.values()[count - 3];
            totalMoneyMap.put(reward, totalMoneyMap.get(reward) + 1);
        }
        printLottoMoney(totalMoneyMap);
    }

    private void printLottoMoney(HashMap<Reward, Integer> totalMoneyMap) {
        System.out.println("3개 일치 (5,000원) - " + totalMoneyMap.get(Reward.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - " + totalMoneyMap.get(Reward.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalMoneyMap.get(Reward.THREE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalMoneyMap.get(Reward.TWO) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalMoneyMap.get(Reward.ONE) + "개");
        System.out.println("총 수익률은 " + calculateRateOfReturn(totalMoneyMap) + "%입니다.");
    }

    private double calculateRateOfReturn(HashMap<Reward, Integer> totalMoneyMap) {
        int totalMoney = 0;
        int buyMoney = buyLottoList.size() * 1000;

        for (Map.Entry<Reward, Integer> entry : totalMoneyMap.entrySet()) {
            Reward reward = entry.getKey();
            int quantity = entry.getValue();
            totalMoney += reward.getMoney() * quantity;
        }

        double rateOfReturn = (totalMoney  * 100.0) / buyMoney;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

    private int countMatchingLotto(Lotto buyLotto) {
        int count = 0;

        List<Integer> buyLottoNumbers = buyLotto.getNumbers();
        List<Integer> successLottoNumbers = successLotto.getNumbers();

        for (int i = 0; i < buyLottoNumbers.size(); i++) {
            if (successLottoNumbers.contains(buyLottoNumbers.get(i))) {
                count++;
            }
        }

        if (count == 6)
            count++;

        if (count == 5 && buyLottoNumbers.contains(bonusLottoNumber))
            count++;

        return count;
    }


    public void setSuccessLotto(List<Integer> successLotto) {
        this.successLotto = new Lotto(successLotto);
    }

    public void setBonusLottoNumber(int bonusLottoNumber) {
        this.bonusLottoNumber = bonusLottoNumber;
    }

}

