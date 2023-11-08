package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Integer amount;
    private List<Lotto> lottos;
    private Double profit;

    public Member() {
        this.amount = null;
        this.lottos = new ArrayList<>();
        this.profit = null;
    }

    public void setAmount() {
        while (true) {
            Integer amount = Input.inputAmount();
            System.out.println("");
            try {
                divideBy1000Validate(amount);

                this.amount = amount / 1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.amount = amount;
    }

    private void divideBy1000Validate(Integer amount) throws IllegalArgumentException {
        if (amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다. 다시 입력하세요");
    }

    public void setLottos() {
        for (int i = 0; i < this.amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottos.add(new Lotto(numbers));
        }
    }


    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "Member{" +
                "amount=" + amount +
                ", lottos=" + lottos +
                '}';
    }
}
