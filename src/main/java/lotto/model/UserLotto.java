package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private static final String INPUT_SPLIT_CHAR = ",";

    private List<Integer> userLotto;
    private int userBonus;
    private UserLottoUtil userLottoUtil = new UserLottoUtil();

    public UserLotto(String userLottoNumber, String userBonusLotto) {

        userLotto = new ArrayList<>();
        setUserLotto(userLottoNumber);
        userLottoUtil.duplicateLotto(userLotto);
        userLottoUtil.validateSizeUserLotto(userLotto);

        setUserBonus(userBonusLotto);
        userLottoUtil.duplicateNumberInList(userLotto, userBonus, -1);
        userLottoUtil.checkNumberRange(userBonus);
    }


    public void setUserLotto(String userLottoNumber) {
        String[] splitUserLotto = userLottoNumber.split(INPUT_SPLIT_CHAR);

        for (int index = 0; index < splitUserLotto.length; index++) {
            userLotto.add(userLottoUtil.validateNumber(splitUserLotto[index]));
        }
    }

    public List<Integer> getUserLotto() {
        return userLotto;
    }

    public void setUserBonus(String userBonusLotto) {
        userBonus = userLottoUtil.validateNumber(userBonusLotto);
    }

    public int getUserBonus() {
        return userBonus;
    }

}
