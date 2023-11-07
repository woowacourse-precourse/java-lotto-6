package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    static final LottoService service = new LottoService();
    public void lotto(){
        service.doLotto();
    }
}
