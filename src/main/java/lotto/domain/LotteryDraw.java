package lotto.domain;


import lotto.constants.ConstNums;
import lotto.constants.PrizeEnum;
import lotto.io.OutputHandler;

import java.util.HashMap;

public class LotteryDraw {

    private final LottoService lottoService;
    private final HashMap<String, Integer> drawResultTable;

    public LotteryDraw(LottoService lottoService) {
        this.lottoService = lottoService;
        this.drawResultTable = new HashMap<>();
        initDraw();
        doDrawAll();
    }

    private void initDraw() {
        for (PrizeEnum prize : PrizeEnum.values()) {
            drawResultTable.put(prize.getKey(), 0);
        }
    }

    public HashMap<String, Integer> getDrawResultTable() {
        return drawResultTable;
    }

    public void printDrawResult() {
        OutputHandler.printPrizeStat(this.getDrawResultTable());
    }

    private void doDrawAll() {
        for (Lotto lotto : lottoService.getLotteries()) {
            int matchedCount = checkMagic(lotto);
            writeTable(lotto, matchedCount);
        }
    }

    private void writeTable(Lotto lotto, int matchedCount) {
        if (matchedCount == ConstNums.WinCondition.FIFTH.getCondition()) {
            drawResultTable.put("FIFTH", drawResultTable.get("FIFTH") + 1);
        } else if (matchedCount == ConstNums.WinCondition.FOURTH.getCondition()) {
            drawResultTable.put("FOURTH", drawResultTable.get("FOURTH") + 1);
        } else if (matchedCount == ConstNums.WinCondition.THIRD.getCondition()) {
            if (checkBonus(lotto)) {
                drawResultTable.put("SECOND", drawResultTable.get("SECOND") + 1);
                return;
            }
            drawResultTable.put("THIRD", drawResultTable.get("THIRD") + 1);
        } else if (matchedCount == ConstNums.WinCondition.FIRST.getCondition()) {
            drawResultTable.put("FIRST", drawResultTable.get("FIRST") + 1);
        }
    }

    private int checkMagic(Lotto lotto) {
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
