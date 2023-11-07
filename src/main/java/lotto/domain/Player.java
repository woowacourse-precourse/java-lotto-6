package lotto.domain;



import lotto.dto.response.LottosInfoDto;

public class Player {
    private final int money;
    private final LottoShop lottoShop;

    public Player(String input, LottoShop lottoShop) {
        this.money = Integer.parseInt(input);
        this.lottoShop = lottoShop;
    }

    public LottosInfoDto buyLottos() {
        LottosInfoDto lottosInfoDto = lottoShop.sellLottos(money);
        return lottosInfoDto;
    }
}

