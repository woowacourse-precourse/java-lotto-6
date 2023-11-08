package lotto.view;

import lotto.io.BonusNumberReader;
import lotto.io.LottoNumberReader;

import java.util.List;

public class PrintView {
    public static List<Integer> lottoWinNumber;
    public static int bonusNumber;
    public void outView() {
        System.out.println();
        System.out.println("당첨번호를 입력해 주세요.");
        LottoNumberReader lottoNumberReader = new LottoNumberReader();
        lottoWinNumber = lottoNumberReader.lotto_reader();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        BonusNumberReader bonusNumberReader = new BonusNumberReader();
        bonusNumber = bonusNumberReader.bonusnumber();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
