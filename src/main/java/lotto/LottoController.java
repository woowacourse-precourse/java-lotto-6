package lotto;

// Import Java Basic Library

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    // instance
    LottoDB lottoDB = new LottoDB();
    LottoView lottoView = new LottoView();

    // Method
    public void start() {
        getLottoCountFromUser();
    }

    public void getLottoCountFromUser() {
        lottoView.userCountInputAnnouncement();
        String userInputStringLottoCount = Console.readLine();
        int userInputIntegerLottoCount = convertStringToInteger(userInputStringLottoCount);
        lottoDB.setUserLottoCount(userInputIntegerLottoCount);
    }

    public Integer convertStringToInteger(String Input) throws IllegalArgumentException {
        return Integer.parseInt(Input);
    }
}
