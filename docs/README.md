# 기능 분석

## 제한 사항 분석

- 로또 번호는 수이다.
- 로또 번호는 1~45이다.
- 로또 번호는 중복되지 않는다.
- 로또 번호는 6 ( +1 ) 개이다.
- 로또 번호에는 보너스 번호 1개가 있다.
- 로또 번호는 쉼표(,)를 기준으로 구분한다.
- 로또 당첨은 1 ~ 5등이 있다.
    - 1등 : 6개 번호 일치 / 2,000,000,000원
    - 2등 : 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등 : 5개 번호 일치 / 1,500,000원
    - 4등 : 4개 번호 일치 / 50,000원
    - 5등 : 3개 번호 일치 / 5,000원
- 로또 1장의 가격은 1,000원이다.
- 로또 구입 금액에 해당하는 만큼 로또를 발행한다.
- 구입 금액은 1,000원 단위다.
- 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외 처리한다.
- 로또 번호는 오름차순으로 정렬하여 보여준다.
- 수익률은 소수점 2자리까지 표현한다.
- 예외 문구는 "[ERROR]"로 시작한다.

## 핵심 기능 분석

- 비교한다.

## 핵심 객체 분석

```markdown

- LottoBall [ ]
    - match
    
```

## 핵심 도메인, 역할 분석

- (로또가) 일치한다. : match

### 구현 중 추가된 사항

## 시스템 기능 분석

- 운영 한다.
- 구매 한다.
- 설정 한다.
- 입력 한다.
- 출력 한다.

## 시스템 도메인 객체 분석

```markdown

- Shop [ ]
    - operate

- Machine [ ]
    - buy
    - set
    - match

- Reader [ ]
    - read

- Viewer [ ]
    - print

```

## 시스템 도메인, 역할 분석

- (상점이) 운영한다. : operate
- (로또 기계에게) 구매한다. : buy
- (로또 기계에게) (로또 번호) 설정한다. : set
- (로또 기계에게) (로또 보너스 번호) 설정한다. : set
- (로또 기계에게) (로또 번호) 일치여부를 확인한다. : match
- (리더가) 금액을 읽는다. : read
- (리더가) 번호를 읽는다. : read
- (리더가) 보너스 번호를 읽는다. : read

### 구현 중 추가된 사항

## 객체 결합 관계

```markdown

- LottoShop : Shop
    - LottoMachine : Machine
        - LottoBall
    - ConsoleReader : Reader
    - ConsoleViewer : Viewer

```

## 시나리오 분석

1. 구매 금액을 입력한다.
2. 구매 금액에 따른 로또를 발행한다.
3. 로또 기계에 로또 번호를 설정한다.
    - 당첨 번호를 입력한다.
    - 보너스 번호를 입력한다.
4. 구매한 로또와 당첨 번호를 비교한다.
5. 구매한 로또와 보너스 번호를 비교한다.
6. 당첨 결과를 출력한다.

## 예외 분석

- core
    - lottoBalls
        - 로또 당첨 공의 갯수가 6개 아닌 경우 : `InvalidLottoBallSizeException`
        - 로또 공이 중복되는 경우 : `DuplicatedLottoBallException`
    - lottoBall
        - 로또 공의 숫자 범위가 아닌 경우 : `InvalidLottoBallRangeException`

- system
    - lotto
        - 로또 번호가 중복되는 경우 : `DuplicatedLottoNumberException`
        - 로또 번호가 6개가 아닌 경우 : `InvalidLottoNumberSizeException`
    - machine
        - 이미 기계가 초기화된 경우 : `AlreadyInitializeException`
        - 기계가 초기화되지 않은 경우 : `NotInitializeException`
        - 중복된 보너스 번호를 설정하는 경우 : `DuplicatedBonusNumberException`
        - 중복된 로또 번호를 설정하는 경우 : `DuplicatedLottoNumberException`
        - 로또 구매 금액이 1,000원 단위가 아닌 경우 : `InvalidLottoPurchaseAmountException`

## 패키지 구조

```markdown

├── core
│ // 핵심 패키지 : 핵심 도메인을 위한 패키지
├──── 핵심 도메인
├────── domain
├─────── 핵심 도메인 객체
├─────── 핵심 도메인 멤버 객체
├────── exception
├── system
│ // 시스템 패키지 : 시스템 도메인을 위한 패키지
├──── 시스템 도메인
├────── domain
├─────── 시스템 도메인 객체
├─────── 시스템 도메인 멤버 인터페이스
├────── exception
├────── 시스템 도메인 멤버 인터페이스 구현체 별 패키지

```