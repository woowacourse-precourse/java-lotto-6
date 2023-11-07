# 미션 소개
해당 미션은 우아한테크코스 프리코스 3주차 과정이다. 로또 게임을 구현한다.
미션은 기능 요구 사항, 프로그래밍 요구사항, 과제 진행 요구사항 세 가지로 구성되어 있다.
- 요구사항은 README.md를 참고한다.
세 개의 요구사항을 만족하기 위해 노력해야하며, 특히 기능을 구현하기 전에 기능 목록을 만든다.
- 구현할 기능 목록은 docs/README.md에 정리한다.
기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

# 구현 할 기능 목록 (순서도)
1. [ ] 로또 게임 시작
2. [ ] 로또 당첨 번호를 발행한다.
    - [ ] 1부터 45까지 중복되지 않는 무작위 숫자 6개를 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용하여 발행한다.
3. [ ] (사용자) 로또 구입 금액을 입력 받는다.
    - [ ] camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - [ ] 구입 금액은 1,000원 단위로 입력 받는다.
    - [ ] (예외처리) 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException을 발생시키고 종료한다.
4. [ ] (사용자) 당첨 번호를 camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - [ ] camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - [ ] 번호는 쉼표(,)를 기준으로 구분한다.
    - [ ] (예외처리) 아래 항목과 같은 상황이 발생시 IllegalArgumentException을 발생시키고 종료한다.
        - [ ] 입력받은 값이 1~45 사이의 값이 아닌 경우
        - [ ] 입력받은 값 중에서 중복되는 값이 있는 경우
5. [ ] 보너스 번호를 camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - [ ] camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - [ ] (예외처리) 아래 항목과 같은 상황이 발생시 IllegalArgumentException을 발생시키고 종료한다.
        - [ ] 입력받은 값이 1~45 사이의 값이 아닌 경우
        - [ ] 입력받은 값 중에서 3번에서 뽑은 당첨번호와 중복되는 값이 있는 경우
6. [ ] 당첨 내역을 출력한다.
    - [ ] 몇 개 맞췄는지에 따른 결과를 출력한다.
7. [ ] 수익률을 출력한다.
    - [ ] 소수점 둘째 자리에서 반올림한 결과를 출력한다.