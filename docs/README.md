## ⚙️ 기능 목록

Application

📌 로또 프로그램을 시작

```java
[로또 프로그램을 시작]
new LottoController.start()
```

---

### domain

[lotto]

LottoPurchaseMoney

📌 로또 구입 금액을 저장

```java
[로또 구입 금액 저장, 반환]
```

LottoTicketList

📌 랜덤으로 생성된 로또 번호 수열들의 리스트

```java
[로또 티켓들 리스트 저장, 반환]
```

Lotto

📌 당첨 번호를 저장

```java
[당첨 번호를 저장, 반환]
```

LottoBonus

📌 보너스 번호를 저장

```java
[보너스 번호를 저장, 반환]
```

LottoWinningStatus

📌 당첨 통계를 저장

```java
[당첨 장 수 리스트 저장, 반환]
```

[enum]

LottoWinningCase

```java
[같은 번호 갯수, 보너스 번호 일치 여부, 금액을 저장하고 있고 반환해주는 Enum]
```

---

### view

MessageOutputController

📌 입력 안내 문구 출력 관리

```jsx
[로또 구입 금액에 대한 입력 안내 문구 출력]
```

```java
[당첨 번호들 입력 안내 문구 출력]
```

```java
[보너스 번호 입력 안내 문구 출력]
```

ProcessedValueOutputController

📌 입력된 값에 대한 출력 관리

```java
[로또 구입 개수와 로또 티켓들 출력]
```

```java
[로또 당첨 결과 제목 출력]
```

```java
[로또 당첨 결과 출력]
```

ErrorOutputController

📌 에러 출력 관리

```java
[ERROR] 로또 금액은 숫자로만 이루어져 있어야 합니다.
```

```java
[ERROR] 로또 금액은 1000원 단위로만 입력해야 합니다.
```

```java
[printErrorOfLottoNumberWithChar]
[ERROR] 로또 번호는 숫자만 입력하셔야 하고, 구분은 쉼표(,)로만 하셔야 합니다.
```

```java
[printErrorOfLottoNumberDuplication]
[ERROR] 로또 번호는 중복이 안되어야 합니다.
```

```java
[printErrorOfLottoNumberRange]
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

```java
[printErrorOfLottoNumberCount]
[ERROR] 로또 번호는 정확히 6개만 입력하셔야 합니다.
```

```java
[printErrorOfLottoBonusNumberWithChar]
[ERROR] 보너스 번호는 숫자만 입력하셔야 합니다.
```

```java
[printErrorOfLottoBonusNumberDuplication]
[ERROR] 보너스 번호는 로또 번호들과 중복되지 않아야 합니다.
```

```java
[printErrorOfLottoBonusNumberRange]
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

---

### controller

[lotto]

LottoController

📌 로또 프로그램의 전체적인 흐름을 관리

```java
[로또 구매 금액 입력 받기]
LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney();
lottoPurchaseMoneyScanner.scanLottoPurchaseMoney(lottoPurchaseMoney);
```

```java
[로또 구매 금액에 따라 로또 번호들 리스트 생성]
LottoTicketList lottoTicketList = new LottoTicketList();
lottoTicketListGenerator.generateLottoTicketList(lottoPurchaseMoney, lottoTicketList);
```

```java
[구매 금액에 따라 생성된 랜덤 로또 티켓 리스트 출력]
lottoTicketListPrinter.printLottoTicketList(lottoTicketList);
```

```java
[당첨 번호 입력 받기]
Lotto lotto = new Lotto();
lottoNumberScanner.scanLottoNumber(lotto);
```

```java
[보너스 번호 입력 받기]
LottoBonus lottoBonus = new LottoBonus();
lottoBonusNumberScanner.scanLottoBonusNumber(lotto, lottoBonus);
```

```java
[로또 당첨 현황을 확인]
LottoWinningStatusChecker lottoWinningStatusChecker= new LottoWinningStatusChecker();
LottoWinningStatus lottoWinningStatus = new LottoWinningStatus();
lottoWinningStatusChecker.checkLottoWinningStatus(lotto, lottoBonus, lottoTicketList, lottoWinningStatus);
```

```java
[당첨 통계 출력하기]
lottoWinningStatusPrinter.printLottoWinningStatus(lottoWinningStatus);
```

LottoPurchaseMoneyScanner

📌 로또 금액 입력 및 유효성 검사

```java
[로또 금액 입력 받기 위한 메세지 출력]
messageOutputController.printScanningLottoPurchaseMoneyMessage();
```

```java
[로또 금액 입력 받기]
String scannedPurchaseMoneyString = inputController.scanLottoPurchaseMoneyString();
```

```java
[로또 금액에 대한 예외 확인]
LottoPurchaseMoneyValueValidator lottoPurchaseMoneyValueValidator = new LottoPurchaseMoneyValueValidator();
lottoPurchaseMoneyValueValidator.checkValidaitonOfLottoPurchaseMoney(scannedPurchaseMoneyString);
```

```java
[로또 금액을 LottoPurchaseMoney 객체에 저장]
Integer scannedPurchaseMoney = Integer.parseInt(scannedPurchaseMoneyString);
lottoPurchaseMoney.setLottoPurchaseMoney(scannedPurchaseMoney);
```

LottoTicketListGenerator

📌 LottoTicket (랜덤으로 무작위 6개 숫자 리스트)을 가진 리스트 생성

```jsx
[입력 금액만큼 로또 티켓 생성]
LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
Integer countForGeneratingLottoTickets = lottoPurchaseMoney.getLottoPurchaseMoney % Dividing_Money_Unit;
while (countForGeneratingLottoTickets-- > End_Of_Count){
	LottoTicket lottoTicket = new LottoTicket();
	lottoTicket.setLottoNumbers(lottoTicketGenerator.generateLottoTicket());
	lottoTicket.createLottoTicket(createRandomUniqueAscendingNuumbersList());
	lottoTicketList.addLottoTicket(lottoTicket);
}
```

LottoTicketGenerator

📌 랜덤으로 무작위 6개의 숫자 리스트를 생성

```java
[로또 무작위 6개 선별 후 리스트 생성 후 반환]
```

LottoTicketListPrinter

📌 로또 구매 내역 출력 흐름을 관리

```java
List<LottoTicket> lottoTicketList = lottoTicketList.getLottoTicketList();
Integer purchaseCount = lottoTicketList.size();
processedValueOutputController.printLottoTicketPrinter(lottoTicketList, purchaseCount);
```

LottoNumberScanner

📌 당첨 번호들을 입력 받는 흐름을 관리

```java
[당첨 번호들을 입력 받기 위한 메세지 출력]
messageOutputController.printScanningLottoNumberMessage();
```

```java
[당첨 번호들 입력 받기]
String scannedLottoNumberListString = inputController.scanLottoNumberListString();
```

```java
[당첨 번호들에 대한 예외 확인]
LottoNumberValueValidator lottoNumberValueValidator = new LottoNumberValueValidator();
lottoNumberValueValidator.checkValidaitonOfLottoNumber(scannedLottoNumberListString);
```

```java
[당첨 번호 리스트를 Lotto 객체에 저장]
List<Integer> scannedLottoNumberList = scannedLottoNumberListString.split(SPLIT_SPOT);
lotto.setNumbers(scannedLottoNumberList);
```

LottoBonusNumberScanner

📌 보너스 번호를 입력 받는 흐름을 관리

```java
[보너스 번호 입력 받기 위한 메세지 출력]
messageOutputController.printScanningLottoBonusNumberMessage();
```

```java
[보너스 번호 입력 받기]
String scannedLottoBonusNumberString = inputController.scanLottoNumberBonusString();
```

```java
[보너스 번호에 대한 예외 확인]
LottoBonusNumberValueValidator lottoBonusNumberValueValidator= new LottoBonusNumberValueValidator();
lottoBonusNumberValueValidator.checkValidaitonOfLottoBonusNumber(lotto,scannedLottoBonusNumberString);
```

```java
[보너스 번호를 LottoBonus 객체에 저장]
Integer scannedLottoBonusNumberList = Integer.parseInt(scannedLottoBonusNumberString);
lottoBonus.setNumbers(scannedLottoNumberList);
```

LottoWinningStatusChecker

📌 당첨 통계를 확인하는 흐름 관리

```java
[로또 티켓들을 당첨 번호들과 비교하여 어떤 당첨 경우에 속하는지 확인]
//lottoWinningStatusChecker.checkLottoWinningStatus(lotto, lottoBonus, lottoTicketList, lottoWinningStatus);

List<Integer> winningCaseCountList = INITIAL_LIST;
new LottoWinningCaseCounter.countWinningCase(lotto,lottoBonus,lottoTicketList,winningCaseCountList);
lottoWinningStatus.setLottoWinningCaseCount(winningCaseCountList);
LottoWinningProfitCalculator lottoWinningProfitCalculator = new LottoWinningProfitCalculator();
lottoWinningStatus.setLottoWinningProfit(lottoWinningProfitCalculator())
```

LottoWinningCaseCounter

📌 당첨의 경우를 확인하고 그 갯수를 카운트

```java
LottoWinningCaseChecker lottoWinningCaseChecker = new LottoWinningCaseChecker();
for (LottoTicket lottoTicket : lottoTicketList){
	LottoWinningCase lottoWinningCase = lottoWinningCaseChecker.checkLottoWinningCaseChecker(lotto, lottoBonus, lottoTicket);
	Integer lottoWinningCaseIndex = lottoWinningCase.ordinal();
	Integer currentCountOFWinningCase = winningCaseCountList.get(lottoWinningCaseIndex);
	winningCaseCountList.set(lottoWinningCaseIndex, currentCountOFWinningCase + COUNT_VALUE_OF_WINNING_CASE);
}
```

LottoWinningCaseChecker

📌 당첨 번호들과 로또 번호들을 비교하고  당첨 경우 확인

```java
[당첨 번호들, 보너스 번호를 로또 번호를 비교해서 Enum 에 있는 값을 가져와 반환]
LottoSameNumberCounter lottoSameNumberCounter = new LottoSameNumberCounter();
Integer countedValueOfLottoSameNumber = lottoSameNumberCounter.countLottoSameNumber(lotto, lottoTicket);
Boolean comparedValueOfLottoBonusNumber = lottoBonusNumberComparator.compareLottoBonusNumber(lottoBonus, lottoTicket);
return LottoWinningCase.findByValue(countedValueOfLottoSameNumber, (보너스 번호를 맞췄는지 함수));
```

LottoSameNumberCounter

📌 당첨 번호와 로또 번호를 비교해서 당첨 경우 반환

```java
[당첨 번호와 로또 번호 비교]
```

LottoWinningStatusPrinter

📌 당첨 결과 출력에 대한 흐름 관리

```java
//lottoWinningStatusPrinter.printLottoWinningStatus(lottoWinningStatus);
processedValueOutputController.printWinningStatus(lottoWinningStatus);
```

[input]

InputController

📌 콘솔 입력에 대한 로직을 관리

```jsx
[로또 구입 금액 입력 받기]
```

```java
[당첨 번호 입력 받기]
```

```java
[보너스 번호 입력 받기]
```

[validation]

LottoPurchaseMoneyValueValidator

📌 로또 구입 금액 입력 값에 대한 유효성 검사

```jsx
[로또 구입 금액 입력 값에 문자 포함 여부 확인]
```

```java
[입력 값에 문자가 포함이 되면 에러 출력]
```

```jsx
[로또 구입 금액이 1000원으로 나누어 떨어지는지 확인]
```

```java
[입력 값에 문자가 포함이 되면 에러 출력]
```

LottoNumberValueValidator

📌 당첨 번호들에 대한 유효성 검사

```java
[당첨 번호들이 다른 문자를 포함하는지 확인]
```

```java
[당첨 번호들이 다른 문자를 포함하면 에러 출력]
```

```java
[당첨 번호들이 서로 중복되는지 확인]
```

```java
[당첨 번호가 중복되면 에러 출력]
```

```java
[당첨 번호들이 1-45 범위에 포함되는지]
```

```java
[당첨 번호들이 1-45 범위에 포함 안되면 에러 출력]
```

```java
[당첨 번호들이 6개 인지 확인]
```

```java
[당첨 번호들이 6개가 아니면 에러 출력]
```

LottoBonusNumberValueValidator

📌 보너스 번호에 대한 유효성 검사

```java
[보너스 번호가 다른 문자를 포함하는지 확인]
```

```java
[보너스 번호가 다른 문자를 포함하면 에러 출력]
```

```java
[보너스 번호가 당첨 번호와 중복되는지 확인]
```

```java
[보너스 번호가 당첨 번호와 중복되면 에러 출력]
```

```java
[보너스 번호가 1-45 범위에 포함되는지]
```

```java
[보너스 번호가 1-45 범위에 포함 안되면 에러 출력]
```

---