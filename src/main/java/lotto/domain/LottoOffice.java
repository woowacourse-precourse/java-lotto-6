package lotto.domain;


import camp.nextstep.edu.missionutils.Console;
import constant.Rank;
import java.util.Arrays;
import java.util.List;
import lotto.ConsoleIO;
import lotto.Lotto;
import lotto.LottoValidator;
import util.InputValidator;

public class LottoOffice {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final LottoValidator lottoValidator;

    public LottoOffice() {
        lottoValidator = new LottoValidator();
        this.winningLotto = pickWinningLotto();
        this.bonusNumber = pickBonusNumber(winningLotto);
    }

    public LottoOffice(Lotto winningLotto) {
        lottoValidator = new LottoValidator();
        this.winningLotto = winningLotto;
        this.bonusNumber = pickBonusNumber(winningLotto);
    }


    private Lotto pickWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> tempWinningNumbers = StringToIntListByRegex(Console.readLine(), ",");
                return new Lotto(tempWinningNumbers);
            } catch (IllegalArgumentException e) {
                pickWinningLotto();
            }
        }
    }

    private List<Integer> StringToIntListByRegex(String str, String regex) {
        return Arrays.stream(str.trim().split(regex))
                .peek(InputValidator::validNumberType)
                .map(Integer::parseInt)
                .peek(lottoValidator::validLottoNumRange)
                .toList();
    }


    private int pickBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputValue = Console.readLine();
                InputValidator.validNumberType(inputValue);
                int bonusNumber = Integer.parseInt(inputValue);
                //rage
                lottoValidator.validateBonusNumber(bonusNumber, winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                pickBonusNumber(winningLotto);
            }
        }
    }


    public Rank calRank(Lotto compareLotto) {
        int mathOfCount = compareLotto.compareTo(winningLotto);
        boolean hasBonus = compareLotto.isContain(bonusNumber);
        return Rank.valueOf(mathOfCount, hasBonus);
    }

}
