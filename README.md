# 🪐 우아한프리코스 6기 웹 백엔드 프리코스 3주차 미션 - 로또

## 🤔 프리코스란?

프리코스는 우아한테크코스 본 과정을 미리 경험해 보는 단계이며,
본 과정과 같이 매주 미션을 하나씩 구현하고 제출하는 방식으로 진행합니다.

## 📋 로또 게임 규칙

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

---

## 🔎 함수별 기능 설명

### LottoController

- run() : 로또 게임을 실행하는 메서드
- getAmountFromUser() : 사용자로부터 로또 구입 금액을 입력받는 메서드
- getValidatedAmount() : 검증된 로또 구입 금액을 반환하는 메서드
- purchaseLottoByAmount(int lottoCount) : 계산한 로또 개수에 따른 로또를 구입하는 메서드
- calculateLottoCount(Amount amount) : 구입 금액에 따른 로또 개수를 계산하는 메서드
- decideWinningNumbers() : 당첨 번호 + 보너스 번호를 결정하는 메서드
- getValidWinningNumbers() : 검증된 당첨 번호를 반환하는 메서드
- displayWinningStatisticsAndYield(List<LottoMatch> winningResults, Amount amount) : 당첨 통계 및 수익률을 출력하는 메서드

### Amount

- Amount(int amount) : 로또 구입 금액 객체를 생성하는 생성자
- create(String amountStr) : 사용자로부터 입력받은 구입 금액을 검증한 뒤, Amount 객체로 생성하는 메서드
- getAmount() : 로또 구입 금액을 반환하는 메서드
- validateNotInteger() : 입력받은 구입 금액이 정수인지 검증하는 메서드
- validateNegativeNumber() : 입력받은 구입 금액이 음수가 아닌지 검증하는 메서드
- validateAmountInThousandUnit() : 입력받은 구입 금액이 1000원 단위인지 검증하는 메서드

### Lotto

- Lotto(List<Integer> numbers) : 로또 번호 객체를 생성하는 생성자
- getNumbers() : 로또 번호를 반환하는 메서드
- validateEmpty() : 로또 번호가 비어있는지 검증하는 메서드
- validateSixNumbersCount() : 로또 번호가 6개인지 검증하는 메서드
- validateInvalidLottoNumberRange() : 로또 번호가 1~45 사이인지 검증하는 메서드
- validateDuplicateNumbers() : 각 로또 번호가 중복되지 않는지 검증하는 메서드

### LottoMatch

- LottoMatch(int matching, boolean bonusMatching, int amount) : 로또 매칭 객체를 생성하는 생성자
- getMatching() : 로또 매칭 결과를 반환하는 메서드
- getAmount() : 매칭 결과의 당첨 금액을 반환하는 메서드
- collect(int matching, boolean bonusMatching) : 보너스 번호 매칭 여부를 반영할지 결정하는 메서드
- filterLottoMatch(int matching, boolean bonusMatching) : 매칭 결과를 바탕으로 알맞는 로또 매칭 객체를 반환하는 메서드

### WinningLotto

- WinningLotto(Lotto winningLotto, String bonusNumber) : 당첨 로또 객체를 생성하는 생성자
- create(Lotto winningLotto, String bonusNumber) : 사용자로부터 입력받은 당첨 번호와 로또 번호를 검증한 뒤, WinningLotto 객체로 생성하는 메서드
- getWinningLotto() : 당첨 번호를 반환하는 메서드
- getBonusNumber() : 보너스 번호를 반환하는 메서드
- validateNoDuplicateNumbers() : 당첨 번호와 보너스 번호가 중복되지 않는지 검증하는 메서드
- bonusNumberValidator() : 보너스 번호를 검증하는 메서드
- validateNotInteger() : 보너스 번호가 정수인지 검증하는 메서드
- validateInvalidLottoNumberRange() : 보너스 번호가 1~45 사이인지 검증하는 메서드

### LottoGameManager

- calculateLottoCount(Amount amount) : 구입 금액에 따른 로또 개수를 계산하는 메서드
- buyLotto(int lottoCount) : 계산한 로또 개수만큼 생성한 로또 리스트를 반환하는 메서드
- generateWinningNumbers(Lotto winningLotto, String bonusNumberStr) : 당첨 번호 + 보너스 번호를 결정하는 메서드
- getWinningResults(List<Lotto> lottoList) : 로또 리스트와 당첨 번호를 비교하여 당첨 결과를 반환하는 메서드
- calculateYield(List<LottoMatch> winningResults, Amount amount) : 당첨 통계를 통해 수익률을 계산하는 메서드
- calculatePrizeMoney(List<LottoMatch> lottoMatchList) : 당첨 통계를 통해 총 상금을 계산하는 메서드

### LottoNumberComparator

- LottoNumberComparator(WinningLotto winningLotto) : 로또 번호 비교기 객체를 생성하는 생성자
- init(WinningLotto winningLotto) : 생성한 당첨 번호 객체를 로또 번호 비교기에 저장하는 메서드
- calculateMatches(List<Lotto> lottoList) : 구입한 로또 리스트와 당첨 로또를 비교하여 매칭 결과를 반환하는 메서드
- calculateMatchForSingleLotto(List<Integer> lottoNumbers) : 단일 로또와 당첨 로또를 비교하여 매칭 결과를 반환하는 메서드
- countMatchingNumbers(List<Integer> lottoNumbers) : 단일 로또와 당첨 로또를 비교하여 매칭 개수를 반환하는 메서드
- equals(Object o) : 테스트를 위한 당첨 번호 비교기 검사 메서드

### InputView

- inputPurchaseAmount() : 사용자로부터 구입 금액을 입력받는 메서드
- inputWinningNumbers() : 사용자로부터 당첨 번호를 입력받는 메서드
- inputBonusNumber() : 사용자로부터 보너스 번호를 입력받는 메서드
- getInput() : 사용자로부터 값을 입력받아 검증한 뒤, 반환하는 메서드
- parseNumbers(String input) : 사용자로부터 입력받은 값을 파싱하여 반환하는 메서드

### OutputView

- displayPurchaseGuide() : 구입 금액 입력 안내 문구를 출력하는 메서드
- displayLottoCount(final int lottoCount) : 구입한 로또 개수를 출력하는 메서드
- displayLottoNumbers(final List<Lotto> lottoList) : 구입한 로또 번호를 출력하는 메서드
- displayWinningNumberGuide() : 당첨 번호 입력 안내 문구를 출력하는 메서드
- displayBonusNumberGuide() : 보너스 번호 입력 안내 문구를 출력하는 메서드
- displayWinningStatisticsGuide() : 당첨 통계 안내 문구를 출력하는 메서드
- displayWinningStatistics(final List<LottoMatch> winningResults) : 당첨 통계를 출력하는 메서드
- determineBonusBallMessage(LottoMatch lottoMatch) : 보너스 볼 매칭 여부를 출력할지 결정하는 메서드
- countMatch(List<LottoMatch> winningResults, LottoMatch lottoMatch) : 매칭 값별로 개수를 계산하는 메서드
- displayYield(final double yield) : 수익률을 출력하는 메서드
- displayExceptionMessage(final String message) : 예외 메시지를 출력하는 메서드

---

## ✨ 실행 결과 화면

![제목 없음](https://github.com/ChaeAg/TEST-Repository/assets/109871579/43e78d35-174c-495b-b869-e5abbb37f2f4)