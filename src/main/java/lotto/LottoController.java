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

    public void getLottoCountFromUser() throws IllegalArgumentException {
        boolean pass = true;
        do {
            try {
                lottoView.userCountInputAnnouncement();
                String userInputStringLottoCount = Console.readLine();
                int userInputIntegerLottoCount = convertStringToInteger(userInputStringLottoCount);
                lottoDB.setUserLottoCount(userInputIntegerLottoCount);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public Integer convertStringToInteger(String Input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(Input);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 정수가 아닙니다.");
        }
    }
}
