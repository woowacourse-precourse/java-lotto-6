# 2023 우테코 프리코스 3주차 미션 - 로또

# 기능 명세

## Domain

- [x] Lotto
    - [x] 로또 번호의 개수가 6인지 확인
    - [x] 로또 번호에 중복된 숫자가 있는지 확인
    - [x] 로또 번호에 범위를 벗어난 숫자가 있는지 확인
    - [x] 당첨 결과 계산을 위한 메서드
- [x] LottoNumberGenerator
    - [x] 1 ~ 45범위의 중복되지 않는 6개의 무작위 숫자를 생성
    - [x] 각 무작위 숫자를 오름차순으로 정렬
- [x] LottoPrice
    - [x] 입력받은 문자열이 정수 형태인지 확인 후 정수형으로 변환
    - [x] 구입 금액이 1000 이상인지 확인
    - [x] 구입 금액이 1000으로 나누어 떨어지는지 확인
    - [x] 구입 금액에 따라 로또 구입 횟수를 반환
- [x] WinningNumber
    - [x] 보너스 번호를 저장
    - [x] 보너스 번호가 범위를 벗어났는지 확인
    - [x] 보너스 번호가 기본 로또 번호와 중복되는지 확인
    - [x] Lotto 클래스와 비교하여 당첨 결과를 반환
- [x] LottoResult
    - [x] 로또 결과를 저장하기 위한 필드
    - [x] 로또 결과를 필드에 적용
    - [x] 각 상금 당 당첨 횟수를 반환
    - [x] 최종 수익률을 계산하여 반환

## Controller

- [x] Game
    - [x] 구입금액을 입력받음
    - [x] 구입 횟수 만큼 Lotto 생성
    - [x] 당첨번호를 입력받음
    - [x] 보너스 번호를 입력받음
    - [x] 입력 예외사항 발생 시 해당 시점부터 다시 입력받음
    - [x] 생성한 모든 Lotto를 WinningNumbers와 비교하여 당첨 내역 계산

## View

- [x] InputView
    - [x] 구입금액 입력
    - [x] 당첨번호 입력
    - [x] 보너스번호 입력
- [x] OutputView
    - [x] 발행한 로또 수량 출력
    - [x] 발행한 로또 번호 출력
    - [x] 당첨 통계 출력

## Config

- [x] LottoConfig
    - [x] LOTTO_SIZE (로또 번호의 개수): 6
    - [x] LOTTO_RANGE_START (로또 번호의 최솟값): 1
    - [x] LOTTO_RANGE_END (로또 번호의 최댓값): 45
    - [x] LOTTO_PRICE (로또 하나의 가격): 1000
- [x] WinningPrize
    - [x] 6, "6개 일치", 2000000000
    - [x] 5, "5개 일치, 보너스 볼 일치", 30000000
    - [x] 5, "5개 일치", 1500000
    - [x] 4, "4개 일치", 50000
    - [x] 3, "3개 일치", 5000

## Util

- [x] parseIntOrThrow
    - [x] 정수 형태로 변환할 수 있는지 확인
    - [x] Integer 범위 내에서 변환할 수 있는지 확인
- [x] parseIntListOrThrow

# 요구사항

## 목표

- [x] 클래스(객체)를 분리하는 연습
- [x] 도메인 로직에 대한 단위 테스트를 작성하는 연습

## 2주차 공통 피드백

- [x] README.md를 상세히 작성
- [x] 기능 목록을 재검토 (너무 상세히 작성하지 말기)
- [x] 기능 목록을 수시로 업데이트
- [x] 값을 하드 코딩하지 않기
- [x] 구현 순서 지키기 (상수 -> 멤버변수 -> 생성자 -> 메서드 순)
- [x] 변수 이름에 자료형은 사용하지 않기
- [x] 한 함수가 한 가지 기능만 담당하게 하기
- [x] 함수가 한 가지 기능을 하는지 확인하는 기준을 세움
- [x] 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리
- [x] 처음부터 큰 단위의 테스트를 만들지 않기

## 기능 요구 사항

- [x] 구입 금액을 입력하면, 금액에 해당하는 만큼 로또를 발행
- [x] 로또 1장의 가격은 1,000원
- [x] 사용자에게 당첨 번호와 보너스 번호를 입력받음
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료
- [x] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받음

## 프로그래밍 요구 사항

- [x] JDK 17버전에서 실행 가능해야 함
- [x] 프로그램 실행의 시작점은`Application`의`main()`
- [x] `build.gradle`파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않음
- [x] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)가이드를 준수하며 프로그래밍한다.
- [x] `System.exit()`를 호출하지 않음
- [x] `ApplicationTest`의 모든 테스트가 성공해야 함
- [x] 파일, 패키지 이름을 수정하거나 이동하지 않음
- [x] Indent depth가 3을 넘지 않도록 구현 (최대 2까지 허용)
- [x] 3항 연산자를 사용하지 않음
- [x] 메서드가 한 가지 일만 하도록 최대한 작게 만들기
- [x] JUnit5와 AssertJ를 이용해 기능 목록이 정상 동작함을 테스트 코드로 확인
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
- [x] `else` 예약어를 쓰지 않음
- [x] `switch/case`문을 쓰지 않음
- [x] Java의 `enum`을 적용
- [x] 도메인 로직에 단위 테스트를 구현해야 함 (단, `System.out`, `System.in`, `Scanner` 로직은 제외)
- [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현해야 함

## 2주차 서로 리뷰하기 피드백

- [x] 명령형보다는 각 객체가 스스로 움직일 수 있도록 협력하는 방향으로 설계
- [x] `ParameterizedTest` 사용

# 파일 내용

## `lotto.config` 패키지

애플리케이션 전반에 사용될 상수값을 모아둔 패키지

### `ErrorMessage`

애플리케이션에서 사용될 에러 메시지를 관리하는 `enum`

| Field     | Description  |
|-----------|--------------|
| `message` | 에러에 대응하는 메시지 |

| Method      | Description                         |
|-------------|-------------------------------------|
| `message()` | 에러에 대응하는 메시지에 `[ERROR]` 문자열을 붙여 반환. | 

### `LottoConfig`

로또 규칙에 관련된 상수를 관리하는 `enum`

| Field   | Description    |
|---------|----------------|
| `value` | 로또 규칙에 대응하는 정수 | 

| Method    | Description     |
|-----------|-----------------|
| `value()` | 해당하는 정수를 그대로 반환 |

### `WinningPrize`

로또 결과에 관련된 상수를 관리하는 `enum`

| Field     | Description              |
|-----------|--------------------------|
| `match`   | 몇 개의 로또번호가 일치하는지 나타내는 정수 |
| `message` | 해당 결과를 나타내는 메시지 문자열      |
| `prize`   | 상금을 나타내는 정수              | 

| Method                         | Description                  |
|--------------------------------|------------------------------|
| `getPrizeWithMatch(int match)` | `match`수가 서로 일치하는 `enum`을 반환 |
| `match()`                      | 해당하는 매치수를 반환                 |
| `message()`                    | 해당하는 메시지를 반환                 |
| `prize()`                      | 해당하는 상금을 반환                  |

## `lotto.controller` 패키지

애플리케이션의 흐름을 제어하는 컨트롤러를 모아둔 패키지

### `LottoGame`

로또 게임을 제어하는 컨트롤러 `class`

| Field         | Description  |
|---------------|--------------|
| `buyingPrice` | 구입금액         |
| `lottos`      | 구매한 로또들의 리스트 |
| `winning`     | 당첨번호         |
| `result`      | 당첨번호와 비교한 결과 | 

| Method                 | Description            |
|------------------------|------------------------|
| `run()`                | 로또 게임을 실행              |
| `inputBuyingPrice()`   | 구입금액을 입력받음             |
| `createLotto()`        | 구입금액만큼 로또를 생성하고 결과를 출력 |
| `inputWinningNumber()` | 당첨번호를 입력               |
| `inputBonusNumber()`   | 보너스번호를 입력              |
| `makeResult()`         | 각 로또마다 결과를 계산          |
| `printResult()`        | 로또의 전체 결과를 출력          | 

## `lotto.domain`

로또 도메인 로직을 모아둔 패키지

### `BuyingPrice`

로또 구입금액을 관리하는 `class`

| Field   | Description |
|---------|-------------|
| `price` | 구입금액        | 

| Method               | Description                  |
|----------------------|------------------------------|
| `getTryCount()`      | 로또를 몇번 살 수 있는지 반환            |
| `validateRange()`    | 입력된 가격이 로또 한 장의 가격 이상인지 확인   |
| `validateDivision()` | 입력된 가격이 로또 가격으로 나누어 떨어지는지 확인 | 

### `Lotto`

개별 로또를 관리하는 `class`

| Field     | Description         |
|-----------|---------------------|
| `numbers` | 로또 번호 6자리를 나타내는 리스트 | 

| Method                                        | Description                          |
|-----------------------------------------------|--------------------------------------|
| `chechDuplicates(int target)`                 | `target`이 `numbers`에 있는 숫자와 중복되는지 확인 |
| `compareWithAnswer(Lotto numbers, int bonus)` | 로또와 보너스번호를 함께 사용해 현재 로또와 비교          |
| `compareWithLotto(Lotto target)`              | 현재 로또를 다른 로또와 비교                     |
| `checkBonus(int bonus)`                       | 보너스 번호를 확인하여 2등과 3등을 결정              |
| `validate(List<Integer> numbers)`             | 로또 번호의 개수가 6개인지 확인                   |
| `validateDuplicates(List<Integer> numbers)`   | 로또 번호에 서로 중복되는 수가 있는지 확인             |
| `validateRange(List<Integer> numbers)`        | 로또 번호 각각이 로또 범위를 만족하는지 확인            | 

### `LottoNumberGenerator`

랜덤한 로또 번호를 생성하는 `class`

| Method                        | Description                    |
|-------------------------------|--------------------------------|
| `generate()`                  | 6개의 중복되지 않는 로또번호를 생성 후 정렬하여 반환 |
| `sort(List<Integer> numbers)` | `numbers` 리스트를 오름차순으로 정렬하여 반환  | 

### `LottoResult`

로또 결과를 관리하는 `class`

| Field    | Description           |
|----------|-----------------------|
| `result` | 로또 결과를 저장하는 `HashMap` | 

| Method                              | Description           |
|-------------------------------------|-----------------------|
| `apply()`                           | 로또 결과를 `result`필드에 반영 |
| `getEachResult(WinningPrize prize)` | `prize`에 맞는 당첨 횟수를 반환 |
| `getFinalProfit()`                  | 최종 수익률을 계산하여 반환       | 

### `WinningNumber`

당첨번호를 관리하는 `class`

| Field     | Description |
|-----------|-------------|
| `numbers` | 6자리의 당첨번호   |
| `bonus`   | 보너스번호       | 

| Method                                         | Description            |
|------------------------------------------------|------------------------|
| `setNumbers(Lotto numbers)`                    | 당첨번호를 설정               |
| `setBonus(int bonus)`                          | 보너스번호를 설정              |
| `compareWithLotto(Lotto target)`               | 로또와 비교하여 당첨결과를 반환      |
| `validateRange(int number)`                    | 보너스번호가 로또 범위를 만족하는지 확인 |
| `validateDuplicates(Lotto numbers, int bonus)` | 보너스번호가 로또 번호와 중복하는지 확인 | 

## `lotto.util`

애플리케이션 전반적으로 사용되는 유틸성 클래스를 모아둔 패키지

### `Parser`

문자열을 특정한 자료형으로 변환하는 메서드를 모아둔 `class`

| Method                                              | Description                             |
|-----------------------------------------------------|-----------------------------------------|
| `parseIntListOrThrow(String numericSequence)`       | 정수 리스트형 문자열을 `List<Integer>`형으로 변환하여 반환 |
| `parseIntOrThrow(String numericString)`             | 정수형 문자열을 `int`형으로 변환하여 반환               |
| `parseLongOrThrow(String numericString)`            | 정수형 문자열을 `long`형으로 변환하여 반환              |
| `validateNumericStringLength(String numericString)` | 정수형 문자열의 길이가 정상 길이 이내인지 확인              |
| `validateIntRange(long number)`                     | 숫자의 크기가 `Integer` 자료형 범위에 있는지 확인        | 

## `lotto.view`

콘솔을 이용한 입력 또는 출력을 위한 클래스를 모아둔 패키지

### `InputView`

콘솔을 이용한 입력을 관리하는 `class`

| Method                          | Description                         |
|---------------------------------|-------------------------------------|
| `inputBuyingPrice()`            | 구입금액 입력을 위한 메시지를 출력하고 문자열을 입력받아 반환  |
| `inputWinningNumber()`          | 당첨번호 입력을 위한 메시지를 출력하고 문자열을 입력받아 반환  |
| `inputBonusNumber()`            | 보너스번호 입력을 위한 메시지를 출력하고 문자열을 입력받아 반환 |
| `printMessage(ViewMessage msg)` | `ViewMessage`를 받아 메시지를 출력           | 

### `OutputView`

콘솔을 이용한 출력을 관리하는 `class`

| Method                                            | Description                  |
|---------------------------------------------------|------------------------------|
| `printBuyingCount(int count)`                     | 로또 구매 횟수를 출력                 |
| `printEachLotto(List<Integer> numbers)`           | 각 로또의 번호 정보를 정해진 포맷으로 출력     |
| `printResultTitle()`                              | 당첨 통계 메시지를 출력                |
| `printEachResult(WinningPrize result, int count)` | 각 등수가 몇 번 당첨되었는지 출력          |
| `printProfitResult(float profit)`                 | 최종 수익률을 소숫점 둘째 자리에서 반올림하여 출력 |
| `printErrorMessage(Exception error)`              | 입력받은 `error`의 메시지를 출력        |
| `newLine()`                                       | 빈 줄 출력                       | 

### `ViewMessage`

`View`에서 사용될 출력 메시지 및 포맷을 관리하는 `enum`

| Field     | Description  |
|-----------|--------------|
| `message` | 출력 메시지 또는 포맷 | 

| Method      | Description      |
|-------------|------------------|
| `message()` | 해당하는 메시지를 그대로 반환 |
