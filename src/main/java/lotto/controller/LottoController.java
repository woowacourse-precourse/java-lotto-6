package lotto.controller;

import lotto.Lotto;
import lotto.domain.Member;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }
    public void play(){
        int money = 2000; // input 미구현으로 인해 일단 대입
        Member member = generateLottoMember(money);
        // TODO: 멤버의 구매 로또 리스트를 넘겨받아 추첨하는 로직 추가
    }

    private Member generateLottoMember(final int money) {
        List<Lotto> purchasedLottos = lottoService.purchase(money);
        return new Member(money, purchasedLottos);
    }
}
