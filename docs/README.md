구현할 기능 목록 정리
==================

View(사용자와의 통신 인터페이스)
-------------
1. (+) class UserInput : 터미널(stdin)을 통해 사용자로부터 입력 받기
    + 유저로부터 구입 금액을 입력
    + 당첨번호를 입력
    + 보너스 번호를 입력
2. (+) class UserOutput : 터미널(stdout)을 통해 사용자에게 출력 하기
    + 로또 생성 결과를 출력
    + 당첨 통계 결과를 출력
    + 수익률을 출력
3. (+) class Messages : 메세지를 정보 저장
    + 입력 안내 문구
    + 출력 안내 문구
    + 에러 안내 문

Controller(게임 흐름을 총괄)
-------------
1. (+) class Controller : 로또 게임 기능을 총괄
    + 로또 구매 및 당첨 확인을 총괄
    + 유저로부터 구매금액을 입력받아 구매 개수로 변환 
      + IllegalArgumentException : 유저 입력이 정수가 아니거나 1000으로 나누어 떨어지지 않는 경우
    + 개수만큼 로또를 생성하여 저장
    + 발행된 로또 정보를 유저에게 알려줌
    + 당첨번호 및 보너스 번호를 입력받음
      + IllegalArgumentException : 유저 입력이 정수가 아니거나, 범위 내의 정수가 아니거나, 6개 + 1개가 아니거나, 중복이 발생하는 경우
    + 당첨통계를 유저에게 알려줌

Service(게임 관련 로직 구현)
-------------
1. (+) class LottoService : 로또 관련 로직 구현
    + 로또 번호를 랜덤으로 생성
    + 로또 당첨 확인
2. (+) class StaticsService : 당첨 통계 관련 로직 구현
    + 당첨 현황을 파악
    + 수익률 계산

Model(게임에 필요한 데이터 저장)
-------------
1. (+) class Lotto : 로또 번호
    + 로또 번호를 저장하는 클래스
    + 로또 번호의 개수가 올바른지 확인
      + IllegalArgumentException : 개수가 올바르지 않은 경우
    + getter()
2. (+) class User : 로또를 구매한 사용자 
    + 구매 금액
    + 구매한 <로또, 등수(=default 꽝)> hashMap
    + constructor()
    + getter() & setter()
    + 로또 값에 맞는 등수를 저장()
3. (+) class Winning : 당첨 번호 및 보너스 번호
    + 당첨 번호를 저장하는 Lotto 인스턴스
    + 보너스 번호
    + constructor()
    + getter()
4. (+) enum Price : 등수
    + 1등, 2등, 3등, 4등, 5등, 꽝
5. (+) class Constant : 상수값
    + 등수에 따른 당첨금
    + 로또 번호 범위 [1,45]
    + 로또 번호 개수
    + 로또 가격