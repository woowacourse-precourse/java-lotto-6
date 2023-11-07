package lotto.domain;


import lotto.dto.response.LottosInfoDto;


public class Player {
    private final int money;
    private final LottoShop lottoShop;
    private Lottos lottos;  // 추가된 필드

    public Player(String input, LottoShop lottoShop) {
        this.money = Integer.parseInt(input);
        this.lottoShop = lottoShop;
    }

    public LottosInfoDto buyLottos() {
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


