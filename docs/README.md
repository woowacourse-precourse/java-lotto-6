# 3주차 미션 - 로또

## 🎮 게임 설명

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

<br>

## 🪐 기능 목록

### 게임 시작 (`LottoController - run()`)

<br>

### 로또 구입 금액 입력 안내 메세지 출력 (`OutputView - displayPurchaseGuide()`)

- [x]  `구입금액을 입력해 주세요.` 출력

<br>

### 로또 구입 금액 입력 (`InputView - inputPurchaseAmount()`)

- [x]  로또 구입 금액 입력
    - 조건
        - 1,000원 단위로 입력
        - 1,000원으로 나누어 떨어져야 함.
    - 예외 처리 (`Amount - create()`)
        1. `IllegalArgumentException` 발생
        2. `[ERROR]` 로 시작하는 에러 메시지 출력
        3. 올바른 값을 입력할 때까지 다시 입력 받음
    - 예외 경우
        - [x]  입력이 비었을 경우 - `[ERROR] 구입 금액을 입력해 주세요.`
        - [x]  입력이 숫자가 아닐 경우 - `[ERROR] 구입 금액은 숫자여야 합니다.`
        - [x]  입력이 음수일 경우 - `[ERROR] 구입 금액은 0보다 작을 수 없습니다.`
        - [x]  입력이 1,000원 단위가 아닐 경우 - `[ERROR] 로또는 1000원 단위로만 구매할 수 있습니다.`

<br>

### 로또 구입 개수 판단 (`LottoGameManager - calculateLottoCount()`)

- [x] 로또 구입 개수 = 로또 구입 금액 / 1000

<br>

### 로또 구입 개수 안내 메세지 출력 (`OutputView - displayLottoCount()`)

- [x] `{ 로또 구입 개수 }개를 구매했습니다.` 출력

<br>

### 로또 번호 출력 (`OutputView - displayLottoNumbers()`)

- [x] 한 줄에 하나의 로또 번호 출력
- [x] 로또 번호는 랜덤한 6개의 수
- [x] 1~45 사이의 숫자
- [x] 하나의 로또 각 번호는 중복 불가능
- [x] [1, 2, 3, 4, 5, 6] 형태로 출력

<br>

### 당첨 번호 입력 안내 메세지 출력 (`OutputView - displayWinningNumberGuide()`)

- [x] `당첨 번호를 입력해 주세요.` 출력

<br>

### 당첨 번호 입력 (`InputView - inputWinningNumbers()`)

- [x] 로또 당첨 번호 입력
    - 조건
        - 1~45 사이의 6개의 수
        - 번호는 쉼표(,)로 구분
    - 예외 처리 (`InputView - inputWinningNumbers(), Lotto - Lotto()`)
        1. `IllegalArgumentException` 발생
        2. `[ERROR]` 로 시작하는 에러 메시지 출력
        3. 올바른 값을 입력할 때까지 다시 입력 받음
    - 예외 경우
        - [x]  입력이 비었을 경우 - `[ERROR] 로또 번호가 비었습니다.`
        - [x]  입력이 숫자가 아닐 경우 - `[ERROR] 로또 번호는 숫자여야 합니다.`
        - [x]  입력된 번호의 개수가 6개가 아닌 경우 - `[ERROR] 로또의 번호는 6개여야 합니다.`
        - [x]  입력된 6개 번호에 1~45 사이의 수가 아닌 번호가 포함된 경우 - `[ERROR] 로또 번호는 1~45 사이의 수여야 합니다.`
        - [x]  입력된 6개 번호에 중복된 번호가 포함된 경우 - `[ERROR] 로또의 각 번호는 중복될 수 없습니다.`

<br>

### 보너스 번호 입력 안내 메세지 출력 (`OutputView - displayBonusNumberGuide()`)

- [x]  `보너스 번호를 입력해 주세요.` 출력

<br>

### 보너스 번호 입력 (`InputView - inputBonusNumber()`)

- [x]  로또 보너스 번호 입력
    - 조건
        - 1~45 사이의 1개의 수
        - 로또 당첨 번호와 중복되지 않는 수
    - 예외 처리 : `IllegalArgumentException` 발생 후 애플리케이션 종료 ()
        - [x]  입력된 번호가 로또 당첨 번호와 중복되는 경우 - `[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.`
        - [x]  입력이 비었을 경우 - `[ERROR] 보너스 번호를 입력해 주세요.`
        - [x]  입력이 숫자가 아닐 경우 - `[ERROR] 보너스 번호는 숫자여야 합니다.`
        - [x]  입력된 번호가 1~45 사이의 수가 아닌 경우 - `[ERROR] 보너스 번호는 1~45 사이의 수여야 합니다.`

<br>

### 당첨 결과 계산 (`LottoNumberComparator - calculateMatches()`)

- [x]  사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과 계산 (`LottoMatch[enum]`)
- 3개 일치 - `LottoMatch.THREE_MATCH`
- 4개 일치 - `LottoMatch.FOUR_MATCH`
- 5개 일치 - `LottoMatch.FIVE_MATCH`
- 5개 일치, 보너스 번호 일치 - `LottoMatch.FIVE_AND_BONUS_MATCH`
- 6개 일치 (당첨 번호와 전부 동일) - `LottoMatch.SIX_MATCH`
- 2개 이하 일치 - `LottoMatch.NOTHING_MATCH`

<br>

### 당첨 통계 안내 메세지 출력 (`OutputView - displayWinningStatisticsGuide()`)

- [x]  아래 메세지 출력

```
당첨 통계
---
```

<br>

### 당첨 내역 출력 (`OutputView - displayWinningStatistics()`)

- [x]  당첨 결과를 바탕으로 당첨 내역 출력

```
3개 일치 (5,000원) - n개
4개 일치 (50,000원) - n개
5개 일치 (1,500,000원) - n개
5개 일치, 보너스 볼 일치 (30,000,000원) - n개
6개 일치 (2,000,000,000원) - n개
```

<br>

### 수익률 판단 (`LottoGameManager - calculateYield()`)

- [x]    수익률 = 당첨 금액 / 로또 구입 금액 * 100

<br>

### 수익률 출력 (`OutputView - displayYield()`)

- [x]  `총 수익률은 {수익률}%입니다.` 출력
- [x]  수익률은 소수점 첫째 자리까지 출력
- [x]  둘째 자리 이하는 반올림 처리

<br>

### 게임 종료 (`LottoController`)