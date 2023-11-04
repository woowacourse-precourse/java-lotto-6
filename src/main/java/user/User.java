package user;

import camp.nextstep.edu.missionutils.Console;

public class User {
    //?? ??? ??????, ??? ??? ??? ?? ???

    private final String inputLottoCount;

    // X?? ??????.
    // ?? ??? ??? ???.

    private final String[] inputWinningLottoNumber;
    // ??? ??? ??? ???.
    private final String inputBonusNumber;

    public User(String inputLottoCount, String[] inputWinningLottoNumber, String inputBonusNumber) {
        this.inputLottoCount = inputLottoCount;
        this.inputWinningLottoNumber = inputWinningLottoNumber;
        this.inputBonusNumber = inputBonusNumber;
    }

    public String getInputLottoCount() {
        return inputLottoCount;
    }

    public String[] getInputWinningLottoNumber() {
        return inputWinningLottoNumber;
    }

    public String getInputBonusNumber() {
        return inputBonusNumber;
    }

}
