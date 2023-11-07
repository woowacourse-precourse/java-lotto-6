package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.ClientLottoData;
import lotto.model.Lotto;
import lotto.model.RankTable;
import lotto.model.WinningLottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static int getLottoTicketNumber(int money) {
        return money / 1000;
    }

    public static List<Lotto> setLottoTicket(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<RankTable> matchLottoCalculate(ClientLottoData clientLottoData,
                                                      WinningLottoNumber winningLottoNumber) {
        List<RankTable> matchLottoCalculate = new ArrayList<>();
        int bonusNumber = winningLottoNumber.bonusNumber;

        for (Lotto lotto : clientLottoData.lottos) {
            List<Integer> lottoNumber = lotto.getNumbers();

            int matchCount = countMatchNumber(lottoNumber, winningLottoNumber);
            filterBonusNumber(matchLottoCalculate, lottoNumber, bonusNumber, matchCount);
        }
        return matchLottoCalculate;
    }

    private static int countMatchNumber(List<Integer> lottoNumber, WinningLottoNumber winningLottoNumber) {
        int matchCount = 0;

        for (Integer winningNumber : winningLottoNumber.winningNumberWithBonusNumber) {
            if (lottoNumber.contains(winningNumber)) {
                ++matchCount;
            }
        }
        return matchCount;
    }

    private static void filterBonusNumber(List<RankTable> matchLottoCalculate, List<Integer> lottoNumber,
                                          int bonusNumber, int matchCount) {
        boolean bonus = false;
        if (lottoNumber.contains(bonusNumber)) {
            bonus = true;
        }
        if (matchCount == 5 && bonus) {
            matchLottoCalculate.add(RankTable.BONUS);
        }
        if (matchCount >= 3 && !bonus) {
            addMatchRank(matchLottoCalculate, matchCount);
        }
    }

    private static void addMatchRank(List<RankTable> matchLottoCalculate, int matchCount) {
        for (RankTable value : RankTable.values()) {
            int matchNumber = value.getMatchNumber();
            if (matchNumber == matchCount && !value.isBonus()) {
                matchLottoCalculate.add(value);
            }
        }
    }

    public static double setIncome(ClientLottoData clientLottoData) {
        int inputPrice = clientLottoData.price;
        double outputPrice = 0;
        List<RankTable> matchLottoCalculate = clientLottoData.matchLottoCalculate;
        for (RankTable rankTable : matchLottoCalculate) {
            outputPrice += rankTable.getMoney();
        }
        return Math.round(outputPrice / inputPrice * 1000) / 10d;
    }
}