# 미션 - 로또

## 🔍게임 진행 방식

1. 사용자는 로또 구입 금액을 입력합니다.
2. 프로그램은 입력된 금액에 따라서 로또 번호를 생성합니다.
3. 사용자는 로또 당첨 번호와 보너스 번호를 입력합니다.
4. 프로그램은 당첨 통계 및 수익률을 계산하여 출력합니다.

## 구현할 기능 목록

1. 사용자에게 로또 구입할 금액 입력
    - [x] 입력 전 모든 메시지를 enum 클래스에 정리
    - [x] 모든 예외에 대한 메시지를 enum 클래스에 정리
    - [x] 21억 이상의 값 Long으로 선언
    - [x] 1,000원 단위로 나누어 떨어지지 않으면 `IllegalArgumentException`발생
    - [x] 1,000원 미만의 값이 입력되면 `IllegalArgumentException` 발생
    - [x] 숫자 이외의 값이 있다면 `NumberFormatException` 발생
    - [x] 모든 예외에 대해 `[ERROR]`로 시작하는 명확한 에러 메시지 출력 후 **다시 입력받는다.**


2. 로또 당첨 번호 입력
    - [x] 숫자가 아닌 경우 `NumberFormatException` 발생
    - [x] 1 ~ 45 사이가 아니라면 `IllegalArgumentException` 발생
    - [x] 중복된 값이 있으면 `IllegalArgumentException` 발생
    - [x] 6개가 입력되지 않으면 `IllegalArgumentException` 발생
    - [x] (,)기준으로 구분하며 잘못된 입력인 경우 `IllegalArgumentException`발생
    - [x] 모든 예외에 대해 `[ERROR]`로 시작하는 명확한 에러 메시지 출력 후 **다시 입력받는다.**


3. 보너스 번호를 입력
    - [x] 숫자가 아닌 경우 `NumberFormatException` 발생
    - [x] 당첨 번호 입력값과 중복인 경우 `IllegalArgumentException` 발생
    - [x] 1 ~ 45 사이가 아니라면 `IllegalArgumentException` 발생
    - [x] 모든 예외에 대해 `[ERROR]`로 시작하는 명확한 에러 메시지 출력 후 **다시 입력받는다.**


4. 금액에 맞추어 로또 번호를 생성
    - [x] 구입금액 / 1000 의 수량만큼 숫자 생성
    - [x] 중복되지 않는 숫자로 생성한다.
    - [x] 생성한 수량 만큼 번호를 출력한다.


5. 번호 일치 확인
    - [x] 생성된 번호과 입력한 당첨 번호의 일치 갯수를 확인
    - [x] 2등의 경우 보너스 번호까지 일치하는지 확인


6. 수익률 계산
    - [x] (당첨 금액 % 구입 금액)의 수익률을 계산한다.
    - [x] int의 최대값이 넘을 수 있으므로 Long으로 선언


7. 당첨 통계를 형식에 맞추어 출력
    - [x] 통계 문구를 enum 클래스로 모아서 관리
    - [로또 금액 기준]
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

```
[실제 출력 내용]
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## [추가 요구 사항]

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- **도메인 로직(프로그램의 핵심 기능)** 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

## 테스트 코드 구현 목록

#### 조건 : 도메인 로직의 단위 테스트를 구현해야 한다.

1. enum 메시지 테스트
    - 오류 메시지
    - 입력 메시지
    - 출력 메시지
    - 3가지 항목의 메시지가 요구사항대로 출력되는지 확인


2. WinningStatistics 테스트
    - 티켓 수가 1,000원 단위로 나누어져서 저장이 되는지 확인
    - 3개 일치시 횟수 증가 확인
    - 5개 + bonus번호 일치시 증가 확인
    - 3개 미만인 경우 증가하지 않는지 확인


3. Lotto 테스트
    - ...

## 패키지 구조 변경

### 이전 구조

- 패키지: lotto
    - 클래스 : Application, Lotto, LottoResultPrinter, UserInputHandler, WinningStatistics, ErrorMessage,
      LottoInputMessages, LottoResultMessages

### 새로운 구조

- 패키지 : lotto
    - 클래스 : Application, Lotto, LottoResultPrinter, UserInputHandler, WinningStatistics
    - 패키지: messages
        - enum : ErrorMessage, LottoInputMessages, LottoResultMessages

#### 이유

- 모듈화: 코드를 작은 부분으로 나누어 관리 및 유지보수에 유리
- 가독성 향상: 클래스와 enum을 구분하여 코드 가독성 향상
- 유지 관리성 향상: 특정 부분만 수정할 수 있어 변경이 다른 부분에 미치는 영향 최소화