# 로또 게임 

## 1. 미션 진행 계획
### 1) 패키지 구성 
- 크게 도메인 로직을 담고 있는 `domain`패키지, UI 로직을 담고 있는 `ui`패키지,
  도메인 로직과 UI 로직을 적절하게 제어하는 `controller`패키지로 나눈다.
- `domain` &rarr; `ui` &rarr; `controller` 순으로 구현한다.
- 어떤 코드가 도메인 로직인지 아닌지 애매하다면, 그 코드가 '로또'라는 비즈니스 문제에 대해서 
  의미있는 결정을 하고 있는지를 파악하자. 이 외의 다른 것들은 해당 결정을 해석하거나
  결정을 내리는 데 필요한 입출력과 관련되어 있다.
  - 참고자료
  - [비즈니스 로직, 도메인 로직이 도대체 뭐지?](https://velog.io/@eddy_song/domain-logic)
  - [What is domain logic?](https://enterprisecraftsmanship.com/posts/what-is-domain-logic/)

### 2) 테스트 코드 작성
- 테스트 코드는 도메인 로직이 완성된 뒤 작성한다. 도메인 로직을 작성하다가
  변경사항이 생길수도 있기 때문이다.
- 도메인 로직 위주로 단위 테스트를 구현한다.

### 3) 입력값 처리
1. Controller 부분에 do while문으로 UI 관련 메서드 호출
2. do while 조건문에서 값이 올바른지 확인하는 메서드 호출(이 메서드 역시 Controller 부분)
3. 이 메서드는 try catch로 구현해 try 부분에서 입력값을 저장 또는 처리하는 기능을 하는 domain 관련 메서드 호출
   1. 정상적으로 처리되면 controller의 다음 부분으로 이동
   2. 처리하다가 예외가 발생하면 catch 부분에서 에러 관련 UI 메서드를 호출하고 false 반환
       - do while문의 조건문에서 false를 받음
       - 1번으로 이동

### 4) 검증 로직의 적절한 위치
- 검증 로직을 꼭 한 계층에 몰아넣을 필요는 없다.
- 여러가지 검증 로직 중에, 도메인 부분에서 검증하면 좋을 내용과
  컨트롤러 부분에서 검증하면 좋을 내용을 잘 고민해서 분류한다.
- 참고자료
    - [[10분 테코톡] 해리&션의 MVC 패턴](https://www.youtube.com/watch?v=uoVNJkyXX0I&t=175s)
    - [MVC 패턴 (feat: 우아한테코톡)](https://velog.io/@jhp1115/MVC-%ED%8C%A8%ED%84%B4-feat-%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%EC%BD%94%ED%86%A1)