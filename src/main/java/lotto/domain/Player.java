package lotto.domain;

import lotto.dto.response.LottosInfoDto;

public class Player {
    private final int money;
    private Lottos lottos;

    public Player(String input) {
        this.money = Integer.parseInt(input);
    }

    public LottosInfoDto buyLottos() {
        LottoShop lottoShop = new LottoShop();
        LottosInfoDto lottosInfoDto = lottoShop.sellLottos(money);
        this.lottos = new Lottos(lottosInfoDto.lottosNumbers());
        return lottosInfoDto;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}


