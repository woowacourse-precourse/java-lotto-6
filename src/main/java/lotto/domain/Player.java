package lotto.domain;

import java.util.*;

public class Player {
    private int money;
    private List<Lotto> lottos;

    public Player(int money) {
        validate(money);
        this.money = money;

        lottos = new ArrayList<>();
    }

    private void validate(int money) {
        if (money % LottoMachine.getLottoPrice() != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public void addLottos(List<Lotto> issuedLottos) {
        lottos.addAll(issuedLottos);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.valueOf(lottos.size()))
                .append("개를 구매했습니다.")
                .append(System.lineSeparator());

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            result.append(lottoNumbers).append(System.lineSeparator());
        }

        return result.toString();
    }
}
