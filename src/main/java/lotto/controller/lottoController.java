package lotto.controller;


import lotto.Lotto;
import lotto.domain.generateLottoNumbers;
import lotto.domain.numberOfWins;
import lotto.domain.winningLottoNumber;
import lotto.view.view;


import lotto.domain.inputAmountLotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.Lotto.createLotto;


public class lottoController {

    public lottoController(){}

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static List<Lotto> lottoNumberList;
    private static winningLottoNumber winningLottoNumber;

    private static List<Integer> lotto = new ArrayList<>();


    public static void start() {
        try {
            runLotto();
        } catch (IllegalArgumentException e) {
            createLotto(lotto);
            runLotto();

        }
    }

    public static void runLotto(){
        lotto.domain.inputAmountLotto inputAmountLotto = new inputAmountLotto(view.inputAmountLotto());
        int numberOfLottoTickets = inputAmountLotto.numberOfLottoTickets();

        view.PrintNumberOfLottoTickets(numberOfLottoTickets);

        lottoNumberList = generateLottoNumberList(numberOfLottoTickets);
        winningLottoNumber = validBonus();

        lottoResult(lottoNumberList, winningLottoNumber, numberOfLottoTickets);

    }

    private static List<Lotto> generateLottoNumberList(int numberOfLottoTickets){
        lottoNumberList = new ArrayList<>();
        for(int i=0;i<numberOfLottoTickets;i++){
            lottoNumberList.add(generateLotto());
        }
        return lottoNumberList;
    }

    private static Lotto generateLotto(){
        lotto = new ArrayList<>();
        lotto = generateLottoNumbers.generateNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public static winningLottoNumber validBonus(){
        Lotto lotto = new Lotto(view.inputLottoWinningNumber());
        List<Integer> winningNumber = lotto.printLottoNumbers();

        int bonusNumber = view.inputBounusNumber();
        Lotto.validBonusNumber(winningNumber, bonusNumber);

        return new winningLottoNumber(new Lotto(winningNumber), bonusNumber);

    }

    private static void lottoResult(List<Lotto> lottoList, winningLottoNumber winningLottoNumber, int amount){
        Map<numberOfWins, Integer> result = setResult();
        numberOfWins numberOfWins;

        view.PrintResult();

        for (Lotto value : lottoList) {
            numberOfWins = winningLottoNumber.match(value);
            result.put(numberOfWins, result.get(numberOfWins) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private static void printResult(Map<numberOfWins, Integer> result) {
        for (int i = numberOfWins.values().length - 1; i >= 0; i--) {
            numberOfWins.values()[i].printMessage(result.get(numberOfWins.values()[i]));
        }
    }

    private static void printEarningRate(Map<numberOfWins, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (numberOfWins rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getPrize()) / (lottoAmount * LOTTO_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        view.printEarningRate(EarningRate);
    }


    private static Map<numberOfWins, Integer> setResult() {
        Map<numberOfWins, Integer> result = new LinkedHashMap<>();

        for (numberOfWins number : numberOfWins.values()) {
            result.put(number, 0);
        }
        return result;
    }







}
