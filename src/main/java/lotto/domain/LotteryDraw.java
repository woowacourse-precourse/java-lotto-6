package lotto.domain;


import lotto.constants.ConstNums;
import lotto.constants.PrizeEnum;
import lotto.io.OutputHandler;

import java.util.HashMap;

public class LotteryDraw {

    private final LottoService lottoService;
    private final HashMap<String, Integer> matchCountLotto;

    public LotteryDraw(LottoService lottoService) {
        this.lottoService = lottoService;
        this.matchCountLotto = new HashMap<>();
        initMatchCount();
        setMatchCountLotto();
    }

    private void initMatchCount() {
        for (PrizeEnum prize : PrizeEnum.values()) {
            matchCountLotto.put(prize.getKey(), 0);
        }
    }

    public HashMap<String, Integer> getMatchCountLotto() {
        return matchCountLotto;
    }

    public void printDrawResult() {
        OutputHandler.printPrizeStat(this.getMatchCountLotto());
    }

    private void setMatchCountLotto() {
        for (Lotto lotto : lottoService.getLotteries()) {
            int matchedCount = checkMagicMatch(lotto);
            readRank(lotto, matchedCount);
        }
    }

    private void readRank(Lotto lotto, int matchedCount) {
        if (matchedCount == ConstNums.WinCondition.FIFTH.getCondition()) {
            matchCountLotto.put("FIFTH", matchCountLotto.get("FIFTH") + 1);
        } else if (matchedCount == ConstNums.WinCondition.FOURTH.getCondition()) {
            matchCountLotto.put("FOURTH", matchCountLotto.get("FOURTH") + 1);
        } else if (matchedCount == ConstNums.WinCondition.THIRD.getCondition()) {
            if (checkBonus(lotto)) {
                matchCountLotto.put("SECOND", matchCountLotto.get("SECOND") + 1);
                return;
            }
            matchCountLotto.put("THIRD", matchCountLotto.get("THIRD") + 1);
        } else if (matchedCount == ConstNums.WinCondition.FIRST.getCondition()) {
            matchCountLotto.put("FIRST", matchCountLotto.get("FIRST") + 1);
        }
    }

    private int checkMagicMatch(Lotto lotto) {
        int matchCount = 0;
        for (int magicNumber : lottoService.getMagicNumber()) {
            if (checkNumber(lotto, magicNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonus(Lotto lotto) {
        if (lotto == null) {
            throw new NullPointerException();
        }
        return lotto.getNumbers().contains(lottoService.getBonusNumber());
    }

    private boolean checkNumber(Lotto lotto, int target) {
        if (lotto == null) {
            throw new NullPointerException();
        }
        return lotto.getNumbers().contains(target);
    }

}
