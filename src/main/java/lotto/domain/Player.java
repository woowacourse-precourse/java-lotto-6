package lotto.domain;


import lotto.dto.response.LottiesInfoDto;

public class Player {
    private final int money;
    private final LottoShop lottoShop;
    private Lotties lotties;

    public Player(String input, LottoShop lottoShop) {
        this.money = Integer.parseInt(input);
        this.lottoShop = lottoShop;
    }

    public LottiesInfoDto buyLotties() {
        LottiesInfoDto lottiesInfoDto = lottoShop.sellLotties(money);
        this.lotties = new Lotties(lottiesInfoDto.lottiesNumber());
        return lottiesInfoDto;
    }
}
