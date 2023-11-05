package lotto.view;

import static lotto.etc.Constant.BUY;
import static lotto.etc.Constant.START;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;

public class LottoView {

    private Lottos lottos;
    public void start(){
        System.out.println(START);
    }
    public void lottoPay(String money){
        Lottos lottos = LottoController
                .getInstance()
                .lottoSell(money);

        this.lottos = lottos;

        System.out.printf(BUY.toString(), lottos.getLottoCount());
        System.out.println();
        lottos
                .getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void lottoResult(String numbers, String bonus){
        LottoRequestDTO lottoRequestDTO = new LottoRequestDTO.Builder()
                .lottos(lottos)
                .numbers(numbers)
                .bonus(bonus)
                .build();

        LottoResponseDTO lottoResponseDTO = LottoController.getInstance()
                .CountScore(lottoRequestDTO);
    }

}
