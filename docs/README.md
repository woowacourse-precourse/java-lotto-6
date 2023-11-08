# 구현 기능

---

### 1) 금액 입력, 로또 개수 출력
- 구매 금액을 입려하면, `입력한 금액` 과 `구매한 로또 개수` 가 출력되도록 간단히 코드를 구성하는 것 부터 시작하였습니다.

### 2) Lotto 클래스 형 lotto 인스턴스 생성, 당첨 번호, 보너스 번호 입력 받기
- [이후 입출력 형태 보완]
    - 입력한 금액을 1000원으로 나누었을 떄 몇개의 로또가 구매 가능한지를 계산
    - `당첨 번호` 를 `winningInput` 변수에 `String` 으로 입력 받고 이후 구분문자 `(,)` 기준으로 split 하여 `winningNumbers` 배열 안에 할당
    - `보너스 번호` 를 변수 `bonus` 에 입력받기

- [Lotto 만들기]
    - 그렇게 계산된 로또 개수만큼 Lotto 클래스 형 객체 `lotto` 를 생성시켜 각 객체 필드인 numbers 에 1~45 까지의 랜덤한 수를 만들어 할당하였다
    - 각 lotto 인스턴스들의 private 필드인 `numbers` 에 접근 가능하도록 `getNumbers()` 메서드 구현
    - Lotto 클래스 타입 인스턴스를 보관할 `lottoes` 배열 생성 후 배열에 각각 `add`
    - 각 로또 번호를 오름차순으로 정렬 후 출력

### 3) 로또 당첨 개수 계산 및 출력
- [일치조건 찾기]
    - 당첨 번호와 로또 번호가 일치하는 개수를 계산하는 메서드 `countMatchingNumbers` 구현 후 일치 개수 `matchCount` 에 할당
    - 보너스 일치 파악 후 `matchCounts` 배열에 수치 누적
>- 인덱스 0~7가 의미하는 것 : 로또 번호와 당첨 번호간 일치하는 숫자의 개수를 의미
>- 단, 6번 인덱스의 경우는 5개의 로또 번호가 일치함과 동시에 보너스 숫자가 맞았을 경우를 의미
>- 이러한 조건에 의해서 7번 인덱스는 6개 로또 번호가 일치할 경우로 배정 (2등 1등은 한 칸씩 뒤로 밀린 케이스)
-  [결과 출력]
    - `matchCounts` 를 rotation 하면서 해당 인덱스에 포함된 누적된 개수 출력



### 4) 입력 조건 예외 처리 및 중간 리팩토링
- 잘못된 금액 정보가 입력될 경우 에러처리 `try-catch`
- 전반적인 코드 리팩토링 : 메서드화 시키기
    - `CalcCash` -> `calculateNuimberOfLotto`
    - 금액 입력 받기 -> `getPurchaseAmount` 메서드로 만들기
    - 당첨 번호, 보너스 번호 입력 메서드로 만들기 : `getWinningNumbers, getBonusNumber`
    - 일치 조건 찾기와, 및 출력 분리

### 5) 수익률 기능 추가
- 출력 형태 만들기

### 6) 수익률 기능 수정
- 올바른 수익률 수식 적용
    - 획득한 금액 계산 : `double totalPrize = calculateTotalPrize(matchCounts);`
    - 소비한 금액 계산 : `double totalSpent = getTotalSpent(lottos)`
- 테스트 코드 통과를 위해 소수점 한 자리까지 표시 하도록 수정
    - 수익률 계산 : `double profitRate = Math.round(((totalPrize) / totalSpent) * 1000.0) / 10.0;`

--- 

