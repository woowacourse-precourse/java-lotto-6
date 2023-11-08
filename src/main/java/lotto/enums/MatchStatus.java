package lotto.enums;

import lotto.Lotto;
import lotto.view.InputView;

import java.text.DecimalFormat;

public enum MatchStatus {
    CORRESPOND_3(3, 5000, false),
    CORRESPOND_4(4, 50000, false),
    CORRESPOND_5(5, 1500000, false),
    CORRESPOND_5_AND_BONUS(5, 30000000, true),
    CORRESPOND_6(6, 2000000000, false),
    FAIL(0, 0, false);
    public String prompt;
    public int num;
    public int count;
    public int reward;
    public DecimalFormat decimalFormat = new DecimalFormat("###,###");
    MatchStatus(int num, int reward, boolean isBonusBallMatches){
        this.num = num;
        this.reward = reward;
        this.prompt = num + "개 일치";
        if(isBonusBallMatches){
            prompt += ", 보너스 볼 일치";
        }
        prompt += " (" + decimalFormat.format(reward) + "원)";
    }
}
