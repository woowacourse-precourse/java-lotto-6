Lotto 게임 만들기

Controller
public void runLottoGame()
Lotto 게임을 시작합니다. 먼저 사용자로부터 로또 티켓의 구매 금액, 당첨 번호 및 보너스 번호를 수집합니다. 그런 다음 구매 금액을 기반으로 로또 티켓을 생성하고 결과를 표시합니다.

private int inputPurchaseAmount()
사용자에게 로또 티켓의 구매 금액을 입력하도록 요청합니다. 입력 금액이 최소 1,000원 이상인지 확인합니다.

private int readPurchaseAmount()
사용자로부터 구매 금액을 읽어옵니다. 최소 1,000원 이상의 유효한 금액이 제공될 때까지 반복적으로 입력을 요청합니다.

private void validatePurchaseAmount(int purchaseAmount)
구매 금액이 최소 1,000원 이상인지를 확인합니다.


model
Lotto
private void validate(List<Integer> numbers)
로또 번호가 6개인지 확인하고, 중복 체크, 1부터 45사이의 숫자인지 확인을 통해 에러 메시지를 출력합니다.

private boolean hasDuplicateNumbers(List<Integer> numbers)
로또 번호가 중복된 숫자를 가지는지 확인합니다.

private boolean isValidNumbers(List<Integer> numbers)
로또 번호가 1부터 45사이의 숫자인지를 확인합니다.

public List<Integer> getNumbers()
이 메서드는 해당 로또 티켓에 포함된 숫자 목록을 반환합니다.

public LottoResult checkWinningResult(List<Integer> winningNumbers, int bonusNumber)
checkWinningResult 메서드는 해당 로또 티켓의 번호와 당첨 번호, 보너스 번호를 기준으로 당첨 여부를 확인합니다. 매치된 번호의 개수와 보너스 번호의 일치 여부를 고려하여 LottoResult를 반환합니다.

public String toString()
toString 메서드는 로또 티켓의 숫자 목록을 문자열 형태로 반환합니다.

public boolean equals(Object obj)
equals 메서드는 다른 객체와 해당 로또 티켓을 비교하여 동일한지 확인합니다.

Lottoresult
LottoResult 열거형은 다음과 같은 다섯 개의 상수를 가지고 있습니다:
FIRST: 3개 일치 시 상금 5,000원
SECOND: 4개 일치 시 상금 50,000원
THIRD: 5개 일치 시 상금 1,500,000원
FOURTH: 5개 일치 및 보너스 볼 일치 시 상금 30,000,000원
FIFTH: 6개 일치 시 상금 2,000,000,000원

public int getMatchingNumbers()
이 메서드는 해당 당첨 등수에 필요한 일치하는 번호의 개수를 반환합니다.

public int getPrize()
이 메서드는 해당 당첨 등수의 상금을 반환합니다.

LottoResult Enum의 활용
LottoResult 열거형은 Lotto 게임에서 각 당첨 결과를 정의하는데 사용됩니다. 게임 결과를 표현하기 위해 이 열거형을 활용하며, 당첨 번호와 일치하는 번호의 개수에 따라 각 등수와 상금을 결정하는데 사용됩니다.

이 열거형은 게임의 결과를 가독성 있게 표현하고, 각 등수별로 상금을 관리하기 위한 효과적인 도구로 활용됩니다.


View
public void printPurchasedLottosCount(int numberOfLotto)
이 메서드는 구입한 로또 티켓의 개수를 출력합니다. 사용자가 구매한 로또 티켓의 개수를 화면에 표시합니다.

public void printPurchasedLottos(List<Lotto> lottos)
이 메서드는 구입한 로또 티켓의 번호를 출력합니다. 사용자가 구매한 로또 티켓의 번호를 화면에 표시합니다.

public void printWinningResult(int[] winCounts, int purchaseAmount)
이 메서드는 게임의 최종 결과를 출력합니다. 각 당첨 등수별로 일치하는 티켓 수와 상금을 출력하고, 총 수익률을 표시합니다.
