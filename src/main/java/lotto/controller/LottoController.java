package lotto.controller;

import lotto.service.MakeLottoNumbersService;
import lotto.service.PrintResultService;
import lotto.service.UserInputService;

import java.util.HashSet;
import java.util.List;

public class LottoController {
    private final MakeLottoNumbersService makeLottoNumbersService;
    private final PrintResultService printResultService;
    private final UserInputService userInputService;
    public LottoController(){
        this.makeLottoNumbersService = new MakeLottoNumbersService();
        this.printResultService = new PrintResultService();
        this.userInputService = new UserInputService();
    }

    public void LottoStart(){
        Integer money = userInputService.validMoneyInputRequest();
        List<HashSet<Integer>> lottoNumbersArray = makeLottoNumbersService.makeLottoNumbers(money/1000);
        makeLottoNumbersService.printLottoNumberArrays(lottoNumbersArray);
        HashSet<Integer> winningNumbers = userInputService.validWinningNumbersInputRequest();
        Integer bonusNumber = userInputService.validBonusNumberInputRequest(winningNumbers);
        printResultService.printResult(lottoNumbersArray, winningNumbers, bonusNumber);
    }




}
