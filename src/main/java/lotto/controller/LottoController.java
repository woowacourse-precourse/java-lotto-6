package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    public static void run(){
        try{
            LottoService.start();
        }catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
    }
}
