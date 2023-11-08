package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.*;
import lotto.util.Constants;
import lotto.view.View;
import lotto.dto.RequestDto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        Lottos lottos = sellLotto();
        WinningNumbers winningNumbers = WinningNumbers.of(pickSixNumbers(), pickBonusNum());
        AnalysisResult analysisResult = analyze(lottos, winningNumbers);
        View.printAnalysis(analysisResult);
    }

    private List<Lotto> provideLottos(int money) {
        int count = money / Constants.LOTTO_PRICE.getValue();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.of());
        }
        return lottos;
    }

    private Lottos sellLotto() {
        View.requestMoney();
        while (true) {
            try {
                int money = RequestDto.of(Console.readLine()).toMoney();
                Lottos lottos = Lottos.of(provideLottos(money));
                View.printLottos(lottos.getLottos());
                return lottos;
            } catch (IllegalArgumentException e) {
                View.printError(e.getMessage());
            }
        }
    }

    private List<Integer> pickSixNumbers() {
        View.requestSixNumbers();
        while (true) {
            try {
                return RequestDto.of(Console.readLine()).toList();
            } catch (IllegalArgumentException e) {
                View.printError(e.getMessage());
            }
        }
    }

    private int pickBonusNum() {
        View.requestBonusNumber();
        while (true) {
            try {
                return RequestDto.of(Console.readLine()).toBonusNumber();
            } catch (IllegalArgumentException e) {
                View.printError(e.getMessage());
            }
        }
    }

    private AnalysisResult analyze(Lottos lottos, WinningNumbers winningNumbers) {
        AnalysisResult analysisResult = AnalysisResult.of(lottos);
        List<LottoType> lottoTypes = lottos.toLottoTypes(winningNumbers);
        analysisResult.addData(lottoTypes);
        return analysisResult;
    }
}
