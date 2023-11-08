package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Game {
    private LottoRank lottoRank;
    private InputUser inputUser;
    private OutputUser outputUser;
    private List<Lotto> numberTickets;
    private WinningLotto winningLotto;
    private CalculateLotto calculateLotto;
    private Validate validate;
    private LottoMachine lottoMachine;
    private final Map<LottoRank, Integer> lottoResult;
    private Integer lottoMoney;
    protected Integer totalLottoCount;
    private double totalPrice;
    private double profitRate;

    public Game() {
        this.inputUser = new InputUser();
        this.outputUser = new OutputUser();
        this.numberTickets = new ArrayList<>();
        this.calculateLotto = new CalculateLotto();
        this.validate = new Validate();
        this.lottoMachine = new LottoMachine();
        lottoResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    // 로또 게임 실행 입력, 계산, 출력 순으로 진행
    public void play() {
        // 구입 금액 입력
        while (true) {
            try {
                this.lottoMoney = inputUser.inputLottoMoney();
                break;
            } catch (IllegalArgumentException e) {
                outputUser.outputExceptionMessage(e.getMessage());
            }
        }
        makeNumberTicket(lottoMoney);
        outputUser.outputBuyLotto(this.totalLottoCount);
        outputUser.outputBuyLottoNumbers(this.numberTickets);

        List<Integer> winningNumbers = null;
        while (true) {
            try {
                winningNumbers = inputUser.inputWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                outputUser.outputExceptionMessage(e.getMessage());
            }
        }

        Integer bonusNumber = null;
        while (true) {
            try {
                bonusNumber = inputUser.inputBonusNumber();
                validate.validateDistinctWinningAndBonusNumbers(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputUser.outputExceptionMessage(e.getMessage());
            }
        }
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        resultLottoGame(this.numberTickets, this.winningLotto);
        outputUser.outputLottoGameResult(this.lottoResult, this.profitRate);
    }

    private void makeNumberTicket(Integer lottoMoney) {
        this.totalLottoCount = lottoMoney/1000;
        for (int i = 0; totalLottoCount > i; i++) {
            this.numberTickets.add(lottoMachine.makeNumber());
        }
    }

    private void resultLottoGame(List<Lotto> numberTickets, WinningLotto winningLotto) {
        for (Lotto lotto : numberTickets) {
            Integer matchedNumbersCount = calculateLotto.calculateLottoGame(lotto, winningLotto);
            Boolean isBonusNumberMatched = calculateLotto.calculateLottoGameBonus(lotto, winningLotto);
            calculateLottoGameResult(matchedNumbersCount, isBonusNumberMatched);
        }
        this.profitRate = this.totalPrice / this.lottoMoney * 100;
    }

    private void calculateLottoGameResult(Integer matchedNumbersCount, Boolean isBonusNumberMatched) {
        LottoRank rank = LottoRank.getRank(matchedNumbersCount, isBonusNumberMatched);
        this.totalPrice += rank.getPrizeMoney();
        lottoResult.merge(rank, 1, Integer::sum);
    }

}
