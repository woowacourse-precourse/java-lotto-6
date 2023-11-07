# Lotto

# Introduction

## 🎯 이번 주 목표

### 프리코스 명시 목표

1. 클래스(객체)를 분리한다.
2. 도메인 로직에 대한 단위 테스트를 작성한다.

### 나만의 목표

1. DDD(Domain Driven Design) Layered Architecture를 적용한다.
2. TDD(Test Driven Development)에 숙련되는 연습을 한다.

## 📋 미션 요구사항

### 프로그래밍 요구사항

1. 함수 길이 15줄
2. else 예약어 금지
    * 대신 early return을 적용할 것.
    * switch/case 또한 금지
3. Java Enum 적용
4. Lotto class 활용
    * private field modifier 수정 금지.
    * field 추가 및 수정 금지
    * 패키지는 변경 가능하다.

## 미션 요구사항

1. 로또 구입 금액 입력
    * 1000원 단위로 입력
    * 1000원 미만 입력 시 예외 처리 및 재입력
2. 로또 구입 및 표시
    * 발행한 로또의 수량 및 번호 출력
    * 로또 번호는 오름차순으로 정렬
3. 당첨 번호 입력
    * 1 ~ 45 사이의 숫자 6개 입력
    * 중복 입력 시 예외 처리 및 재입력
4. 보너스 볼 입력
    * 1 ~ 45 사이의 숫자 1개 입력
    * 당첨 번호와 중복 입력 시 예외 처리 및 재입력
5. 당첨 통계 표시
    * 당첨 번호와 보너스 볼에 따른 당첨 통계를 출력한다.
    * 3개 일치, 4개 일치, 5개 일치, 5개 일치 + 보너스 볼 일치, 6개 일치를 출력한다.
        * 당첨 통계는 이 순서대로 출력한다.
    * 당첨 통계는 0개 일치도 포함한다.
    * 수익률을 계산하여 출력한다.
        * 수익률은 소수점 둘째 자리에서 반올림하여 출력한다.
        * 수익률은 (총 수익 / 총 비용)으로 계산한다.

## 📝 요구사항 분석

### 명시되지 않은 요구사항 분석 및 결정

1. 당첨 번호 입력에 공백이 있을 경우 -> trim하여 처리
2. 생성되는 로또 번호는 1~45의 숫자
3. 로또 번호는 오름차순으로 정렬하여 저장. Lotto class가 검증 -> 정렬 -> 저장한다.
4. 액수와 백분율 출력 포맷은 3자리마다 콤마(,)를 찍는다.

## 📝 기능 목록

### Presentation 계층

* 구입 금액 입력
* 구입한 로또 출력
* 당첨 번호 입력
* 보너스 번호 입력
* 당첨 통계 출력

### Application 계층

* 구입 금액을 갯수로 변환해 전달하고, 갯수만큼 로또 티켓을 생성해 그 값을 리턴한다.
* Repository 계층에게 당첨 번호와 보너스 번호를 전달한다.
* 티켓으로부터 당첨 통계를 리턴한다.

### Domain 계층

* 로또 티켓을 생성한다.
* 당첨 번호에 따른 티켓의 당첨 여부를 판단한다.
* 티켓들의 당첨 통계를 생성한다.

### Repository 계층

* 로또 티켓을 저장 / 조회한다.
* 당첨 통계를 저장 / 조회한다.

## 📝 설계

* DDD Layered Architecture로 구현하고, 패턴에 매몰되기보단 도메인 중심의 설계에 초점을 맞출 것.

### ▶️ Presentation Layer

* Console을 통해 사용자와 상호작용한다.
* 사용자의 입력을 받아 Application Layer에 전달한다.
* Application Layer로부터 전달받은 결과를 출력한다.

#### LottoController

### 🎮 Application Layer

* Presentation Layer로부터 전달받은 요청을 처리한다.
* Domain Layer와 Repository Layer에 요청을 전달한다.

#### LottoService

### 💡 Domain Layer

* Application Layer로부터 전달받은 요청을 처리한다.
* Repository Layer에 요청을 전달한다.

#### Lotto (VO)

* 책임:
    * 번호 6개를 검증 후 오름차순으로 저장한다.
        * 검증 로직: 6개, 범위 내, 중복 불가
    * 두 로또간의 일치하는 번호의 갯수를 계산한다.
* 메소드:
    * validate

#### Ticket

* 책임:
    * 로또 객체를 가진다.
    * 당첨 번호와 비교한 결과를 계산한다.
* 메소드:
    * match

#### DrawResult

* 책임:
    * 로또 객체와 보너스 볼 번호를 검증 후 저장한다.
        * 보너스 검증 로직: 범위 내, 당첨 번호와 중복 불가
    * 티켓들의 당첨 통계를 계산한다.
* 필드:
    * 로또 객체
    * 보너스 볼 번호
* 메소드:
    * matchTicket

#### TicketSeller

* 책임:
    * 티켓 객체를 지정한 규칙에 맞게 생성한다.
* 메소드:
    * createTicket

#### LottoGenerator (interface)

* 책임:
    * 로또 번호를 생성하는 규칙을 정의한다.
* 메소드:
    * generate
* 구현체:
    * RandomLottoGenerator
    * ManualLottoGenerator

##### RandomLottoGenerator

* 책임:
    * 랜덤한 로또 번호를 생성한다.
* 메소드:
    * generate

### 📁 Repository Layer

* Domain Class의 인스턴스가 여기에 저장된다.

#### TicketRepository

#### DrawResultRepository