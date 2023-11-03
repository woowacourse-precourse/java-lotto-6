package lotto.controller;

import lotto.service.MakeLottoNumbersService;
import lotto.service.PrintResultService;
import lotto.service.UserInputService;

public class LottoController {
    private final MakeLottoNumbersService makeLottoNumbersService;
    private final PrintResultService printResultService;
    private final UserInputService userInputService;
    public LottoController(){
        this.makeLottoNumbersService = new MakeLottoNumbersService();
        this.printResultService = new PrintResultService();
        this.userInputService = new UserInputService();
    }



}
