# Dto, Domain의 변환 위치에 대해서

---

Lotto 미션도 저번달부터 연습 삼아 수차례 만들어 보았기 때문에 로직은 어느 정도 아는 상태였음.

똑같이 작성하면 의미가 없기 때문에 이번에는 어떤 식으로 고도화 시킬 수 있을지에 대해서 고민.

자세히 보면 입력 -> 출력, 입력 -> 출력이 2번 일어나며,

처음 입력으로 받았던 로또를 두번째 입출력을 처리할 때 사용하기 때문에,

처음 입력받은 로또들을 `Repository`에 저장하는 방법도 괜찮겠다는 생각이 들었음.

아직 JPA를 기초만 훑어본 상태이기 때문에 Java 진영에서 Repository를 제대로 운용하는 방법은 잘 모르지만,

어떤 웹 프레임워크를 사용하더라도 입문자들에게 가르치는 구조가 거의 항상 `Controller-Service-Repository`이기 때문에,

구조 잡는 것은 익숙한 상태였음.

Dto, Service, Domain 간의 관계도 미션을 진행하면서 조금씩 학습하여 대략적으로 파악이 된 상태였지만,

변환 계층 및 방법이 여러 가지라 실제로 현업에서는 어떤 방법이 사용되는지, 정석이 무엇인지까지는 알지 못해서

앞서 1년간 이런 부분들에 대해 수도없이 학습을 진행하며 익숙해졌을 우아한 테크코스 5기 기수들의 레포지토리에 답이 있을 것이라 생각하여, 이를 참고하며 구조를 베껴보기로 함.

일원화 되는 것이 아니라, 다양한 방법이 있었으며

모든 방법의 장단점에 대해 고민하며 코드를 작성해보고 내용 정리 후, 마음에 드는 방법을 사용해보기로 함.
  
---  

## 1. Dto에서 Domain 변환

1 ~ 2주차 미션을 진행하면서 사용한 방법이다.

최대한 getter를 지양하여 캡슐화를 깨뜨리지 않기 위해서 선택했었다.

```java  
public final class Car {

    private final String name;

    private int position;

    // 현재 Domain 객체를 Dto로 변환  
    public CarDto toDto() {
        return new CarDto(
                name,
                position
        );
    }
}  
```  

2주차 미션이었던 자동차 경주 게임의 도메인 객체, `Car`를 `CarDto`로 변환하는 로직이다.

`CarDto`는 자동차의 이름과 현재 위치를 저장하여 출력할 때 사용되는데,

사실상 `Car`과 데이터는 동일하지만, 비즈니스 로직이 존재하지 않으며 불변 객체라는 차이가 있다.

`Car`의 데이터를 빼서 `CarDto`를 만들기 때문에 `CarDto`를 만들기 위해 `Car`의 필드에 접근할 수 있어야 하는데,

`Car` 클래스 내부에서 `CarDto`를 만드는 로직을 작성하면, 필드를 노출할 필요가 없기 때문에 캡슐화가 전혀 훼손되지 않는다는 장점이 있다.

그러나 이 방법의 단점에 대해서 생각해보면 너무 많은 Dto 생성 로직이 Domain에 들어갈 가능성이 있다는 것이다.

예를 들어 `User`라는 도메인 객체가 있다고 생각해보자.

```java  
import java.time.LocalDate;

// User Domain Object  
public class User {

    // DB에 저장할 ID  
    private final int id;

    // 프로필 사진 주소  
    private final String profilePhotoUrl;

    // 로그인 ID  
    private final String username;

    // 닉네임  
    private final String nickname;

    // 실명  
    private final String name;

    // 이메일  
    private final String email;

    // 비밀번호  
    private final String password;

    // 나이  
    private final int age;

    // 성별  
    private final Gender gender;

    // 지역  
    private final Locale locale;

    // 생일  
    private final LocalDate birthDate;

    // 가입일  
    private final LocalDateTime createdDateTime;

    // 수정일  
    private final LocalDateTime updatedDateTime;

}  
```  

예시를 위해 조금 필드가 많아졌다.

`User`는 여러 Dto를 만들어낼 수 있다.

예를 들어, 로그인 아이디를 담는 `username`과 사용자의 별칭을 담는 `nickname` 두 개만 보여주고 싶을 경우가 존재하는데,

![[Dto, Domain의 변환 위치에 대해서-1.png]]

위처럼 대부분의 사이트에서 위와 비슷한 방식으로 간단한 프로필을 보여준다.

이 때 필요 없는 정보는 제하고 사용되는 정보만 담아서 보내주도록 Dto를 만들 수 있다.

```java  
public class UserProfileDto {
    // 프로필 사진  
    public final String profilePhotoUrl;

    // 닉네임  
    public final String nickname;

    // 이메일  
    public final String email;
}  
```  

이렇게 Dto는 원래 도메인 객체에서 필요한 정보만 필터링하여 데이터를 절약하면서 효율적으로 전송하는 이점이 있고,

보안 상 중요한 비밀번호 등의 필드를 제거하여 노출하지 않을 수 있다.

이 외에도 현재 예시에는 존재하지 않지만 주민번호, 카드번호 등의 정보가 존재한다면 Dto에선 필터링하고 안전하게 가려줄 수 있을 것이다.

이런 식으로 `User`에서 파생된 Dto가 여럿 생성되었다고 생각해보자.

```java  
// 프로필을 보여줄 때 사용  
public class UserProfileDto {
    // ...}  

    // 사용자 상세 정보 보여줄 때 사용  
    public class UserDetailDto {
        // ...}  

        // 이메일만 보여줄 때 사용  
        public class UserEmailDto {
            // ...}  

            // 이 외 간단한 사용자 정보 보여줄 때 사용  
            public class UserSimpleDto {
// ...}  

// 그 외 10개의 User에 관련된 Dto가 존재한다고 가정  
```  

이렇게 여러 개의 Dto가 존재하는데 변환 로직이 `User` 도메인 객체에 들어가게 된다면 어떻게 될까.

```java  
public class User {

    public UserProfileDto toUserProfileDto() {
        // ...  
    }

    public UserDetailDto toUserDetailDto() {
        // ...  
    }

    public UserEmailDto toUserEmailDto() {
        // ...  
    }

    public UserSimpleDto toUserSimpleDto() {
        // ...  
    }

    // ... 그 외 10개의 Dto 변환 로직 존재  

}  
```  

`User` 도메인 객체에 너무 많은 변환 로직이 들어간 것을 한 눈에 볼 수 있다.

변환 로직이 필드 및 비즈니스 로직보다도 더 많아진다면, 본말전도가 될 것이다.

정리하면 Domain 내의 Dto 변환 로직 작성은

필드를 노출할 필요가 없기 때문에 getter를 작성하지 않고 캡슐화를 지킬 수 있다는 장점이 있다.

단점은 Dto 종류가 많아질수록 도메인 객체에 변환 로직이 너무 많아져서

SRP를 지킬 수 없게 되며, 도메인 객체가 Dto에 의존하기 때문에 Dto가 변경되면 도메인 객체도 변경 되어야 한다.

이는 변경 지점을 늘리고 유지 보수를 어렵게 만드는 지점이 되어 코드의 복잡성을 늘릴 것이다.

또한 IDE에서 도메인 객체 내의 프로퍼티를 볼 때마다 불필요하게 여러 변환 메소드를 자동으로 보여줄 것이다.

  
---  

## 2. Dto에서 Domain 변환

1번 케이스와 완전히 반대되는 상황이라고 볼 수 있다.

```java  
public class UserProfileDto {
    public static UserProfileDto from(final User user) {
        // ...  
    }
}

public class UserDetailDto {
    public static UserDetailDto from(final User user) {
        // ...  
    }
}

public class UserEmailDto {
    public static UserEmailDto from(final User user) {
        // ...  
    }
}

public class UserSimpleDto {
    public static UserSimpleDto from(final User user) {
        // ...  
    }
}  
```  

각 Dto가 도메인 객체를 받아서 Dto 타입으로 변환 시켜주는 역할을 한다.

변환에 대한 책임이 각 Dto로 분산되었기 때문에,

Dto가 늘어나더라도 도메인 객체는 전혀 영향을 받지 않으며,

각 Dto가 요구 사항에 의해 변경 되더라도 변경 되어야 할 Dto만 건드리면 된다.

단점은 아까 봤던 것처럼, 별개의 Dto 클래스에서 도메인 객체의 데이터에 접근하기 위해서,

수많은 getter를 만들어서 캡슐화가 저해된다는 것이다.

```java  
import java.time.LocalDate;
import java.time.LocalDateTime;

// User Domain Object  
public class User {

    public int getId();

    public String getProfilePhotoUrl();

    public String getUsername();

    public String getNickname();

    public String getName();

    public int getAge();

    public Gender getGender();

    public Locale getLocale();

    public LocalDate getBirthDate();

    public LocalDateTime getCreatedDateTime();

    public LocalDateTime getUpdatedDateTime();

}  
```  

`User` 내에 변환 로직은 전혀 없지만 getter가 모조리 노출되었다.

그러나 수많은 Dto가 생기거나 변경되더라도 도메인 객체가 변경될 일은 없다.

도메인 객체에 없는 필드를 필요로 하지 않는 이상은.

두 방법 모두 트레이드 오프가 있는 것이다.
  
---  

## 3. Mapper 사용

도메인 객체는 비즈니스 로직 처리,

DTO는 데이터 전송 이라는 목적이 존재한다.

그런데 앞서 살펴봤던 두 방법은 모두,

'변환'이라는 다른 역할을 둘 중 하나에 추가적으로 부여했다.

'역할 분리' 관점에서 보면 하나의 객체에 한 가지 역할만 부여해야 하는 SRP가 위배된 것이다.

우아한 테크코스 5기 레포지토리를 참고해보니, '변환'이라는 역할을 `Mapper`라는 클래스에 위임하도록 만드는 경우가 있었다.

그저 역할을 다른 클래스로 분리한 것이기 때문에 어렵진 않았다.

```java  
public class UserMapper {
    public static UserProfileDto from(final User user) {
        // ...  
    }

    public static UserDetailDto from(final User user) {
        // ...  
    }

    public static UserEmailDto from(final User user) {
        // ...  
    }

    public static UserSimpleDto from(final User user) {
        // ...  
    }
}  
```  

위와 같이 `Mapper` 클래스에 변환 로직을 분리하기만 하면 된다.

좀 더 확실하게 분리하려면, `DTO -> 도메인 변환`, `도메인 -> DTO 변환`에 따른 2개의 `Mapper`를 만드는 것이 좋아 보인다.

그래야 변환 로직의 갯수가 늘어나도 방향을 헷갈릴 일이 없을 것이다.

```java  
public class UserToDtoMapper {
    // ...  
}

public class DtoToUserMapper {
    // ...  
}  
```  

이름을 잘 못 짓기 때문에 대략 의미 유추 정도만 되게 만들었는데,

대략 어떤 느낌인지가 바로 보일 것이다.

이런식으로 만들면 어떨까 싶다.

다만, 이것도 Dto가 너무 많아져서 100개라고 생각하면,

하나의 Mapper에서 100개의 변환 로직을 관리하는 것보다는

각 Dto에서 관리하는 것이 더 쉽지 않나 하는 생각도 든다.

그러나 그건 일반적인 경우는 아닌 것 같고, 변환 로직의 개수가 적다면 역할 분리가 명확하게 되고 유용하게 쓸 수 있을 것이다.

---  

# 4. 그 외 방법들

아직 기본 수준이기 때문에 지금은 위 3가지 중 하나만 사용해도 충분할 것 같지만,

그 외 방법들이 분명 있을 것이기 때문에 조금 더 생각해봤다.

## 4-1. Friend Class

이 방법은 Java에서는 불가하지만, `C++`에서 지원하는 방법이다.

```cpp  
class User {  
    // 필드 생략  
      
    // 이제 UserDto 클래스 내에서 User의 모든 멤버에 접근 가능.  
    friend class UserDto;   
}  
```  

`friend class`로 지정한 클래스는 해당 클래스의 모든 멤버에 접근이 가능해진다.

`User`의 `friend`가 `UserDto`가 되었기 때문에,

`UserDto`에서는 이제 `User`의 모든 필드에 getter 없이 접근할 수 있게 된 것이다.

```java  
public class UserDto {
    public static UserDto from(final User user) {
        return new UserDto(
                // UserDto에서 User의 필드에 직접 접근  
                user.id,
                user.name
                // ... 생략  
        );
    }
}   
```  

만약 Java에서 `friend`가 지원 되었다면, 위와 같이 작성할 수 있었을 것이다.

즉, `User`의 `friend` 클래스로 모든 Dto 클래스를 등록하게 된다면,

```cpp  
class User {  
    // 필드 생략  
      
    // 모든 Dto 클래스 내에서 User의 모든 멤버에 접근 가능.  
    friend class UserDto;  
    friend class UserProfileDto;  
    friend class UserDetailDto;  
    friend class UserEmailDto;  
    friend class UserSimpleDto;  
    // ... 생략  
}  
```  

Dto 변환 로직을 Dto 클래스 내에 넣으면서도 캡슐화를 조금 덜 깨뜨릴 수 있는 것이다.

Dto가 아닌 다른 클래스에서는 여전히 `User` 필드에 접근이 불가능하기 때문이다.

`friend`가 일반적으로 '안티 패턴'으로 인식되기 때문에 무분별한 사용을 지양해야 한다고 널리 알려져 있지만,

`friend`가 도메인, Dto 변환을 위해 사용된다고 명확한 목적을 알리고 작업자 간에 합의가 된다면 괜찮지 않을까 생각된다.

아이디어는 나쁘지 않다고 생각하지만, 이 방법은 Java에서는 사용할 수 없다는 것이 문제다.

생각해보면 Java에서도 비슷한 방법이 존재한다.

## 4-2. `default` 키워드를 이용한 필드 공유

보통 필드에 `private` 접근 제어자를 명시하지만, 아무 것도 명시하지 않으면 저절로 `default` 접근 권한을 갖는다.

`friend`는 접근 가능하게 만들 클래스를 명시했지만,

`default`는 '같은 패키지'로 범위가 한정된다.

그래서 같은 패키지 내에 Dto와 도메인 객체를 두면 `friend`와 비슷한 효과를 낼 수 있기는 한데...

과연 dto와 도메인 객체를 일반적으로 같은 패키지 내에 두는가 생각해보면 아닌 것 같다.

5기 레포지토리만 봐도 그렇다.

게다가 `default` 접근 제어자를 사용하는 것 자체가 드물 것이라고 생각하는데,

이러한 합의가 없다면 혼란을 일으킬 수 있을 것 같다.

대체 왜 `default` 접근 제어자를 사용했는지 같이 작업할 사람이 들어올 때마다 설명을 해야 할 것이다.

그래서 이 방법은 좋지 않다고 생각한다.

## 4-3. 도메인 클래스의 복제 클래스를 만드는 방법.

이 방법은 그냥 혼자 생각해 본 방법이기 때문에 실제로도 쓰이는 방법인지는 모르겠다.

아마 안 쓸 것 같기는 하지만 나름대로 머리를 굴려서 생각해 낸 방법이니 재미로 보면 좋을 것 같다.

```java  
public class User {
    private final int id;
    private final String name;
    // ... 나머지 필드 생략  

    public UserOpened toOpened() {
        return new UserOpened(
                id,
                name
                // ...  
        );
    }
}

// 복제 User  
public class UserOpened {
    public final int id;
    public final String name;
    // ... 나머지 필드 생략  
}  
```  

이름은 그냥 아무렇게나 지었다.

`User` 클래스의 복제판인 `UserOpened` 클래스를 만들어서,

`User`의 모든 필드를 `public`으로 만들었다.

`User` 내에서는 모든 필드를 `private`으로 유지하여 외부에서 접근할 수 없게 만든 다음,

Dto로 변환하고 싶으면 `User` 객체의 `toOpened` 메소드를 호출하여,

모든 필드가 열린 새로운 객체를 받는다.

그 다음 Dto로 변환하면 된다.

```java  
public class UserDto {
    // 도메인 -> Dto 변환 메소드를 각 Dto 내에 생성  
    public static UserDto from(final User user) {
        // 모든 필드가 private인 User의 필드에 접근 불가하므로,  
        // 모든 필드가 public인 UserOpened 클래스로 변환  
        final UserOpened userOpened = user.toOpened();

        // UserOpened에서 데이터를 꺼내서 사용할 수 있음.  
        return new UserDto(
                userOpened.id,
                userOpened.name
        );
    }
}  
```  

`User` 필드에 직접 접근하는 것이 아니라,

위와 같이 `UserOpened`로 변환해서 외부 접근하여 Dto로 변환 가능하게 되었다.

이러면 도메인 객체의 캡슐화도 지키면서 필요할 때, `toOpened`를 호출하여

외부에서도 `User`가 가지고 있던 데이터에 접근할 수 있게 된다.

장점은 이제 IDE에서 `user.`으로 필드 및 메소드 자동 완성을 해봐도 getter들이 보이지 않게 된다.

수많은 getter들이 오직 Dto만을 위해서 노출된다면 쓸 데 없이 정보량이 늘어나서 복잡도를 높일 것이다.

그리고 도메인 객체로 비즈니스 로직을 처리하는 도중에 getter에 임의로 접근해서 getter에 의존하게 되는 일이 줄어들 것이다.

반드시 모든 도메인 객체에 존재하는 `toOpened`는 Dto에서만 사용하라는 약속을 하면 될 것이기 때문이다.

그리고 `toOpened`는 도메인 객체가 모든 필드를 열 것이기 때문에,

Dto가 변경된다고 해서 같이 변경될 필요가 없다.

즉, Dto에 의존하지 않는다.

단점은 메모리와 성능을 괜히 더 먹게 된다는 것이며, 이 방법 역시 여러 사람이 함께 협업한다면

'규칙'을 정하고 `toOpened`를 마구 호출하지 말 것을 작업자 전원이 인지하는 추가적인 과정이 필요하다.

default 접근 제어자와 조금 다른 것은, toOpened 를 범용 용도가 아니라 반드시 Dto 변환을 위해서만 사용하자고 약속하면 된다는 것이다.

`default` 는 키워드부터가 그저 접근 제어자를 생략하는 것이 전부이기 때문에, 이걸 실수로 생략했는지, 다른 용도로 사용한 것인지, 필드를 같은 패키지 내의 Dto에서 접근하기 위해 사용한 것인지 ‘의도’를
파악하는 것이 그리 쉽지만은 않아 보인다.

그리고 마지막으로 도메인 객체의 필드를 복붙하는 개념이기 때문에,

도메인 객체가 변경될 때마다 동기화를 시켜줘야 한다.

도메인 객체 필드 변경 -> `Opened` 클래스 필드까지 변경해야 한다.

이렇게 여러 가지 방법과 개인적인 생각을 적어보았는데, 실제 현업에서는 어떤 방법이 권장되고 주로 사용되는지 궁금하다.

---

# 추가 내용

## 4.4. Nested Struct

이 방법은 Go언어에서 사용할 수 있는 방법인데, 언젠가 '상속'이 점점 퇴화하고

Java, Kotlin에 Heap이 아닌 Stack에 데이터가 쌓이는 Struct가 들어오는 날이 온다면

정말 먼 미래에 볼 수 있지 않을까 싶다.

그런 날이 오지 않을 수도 있겠지만,

```go
type UserFields struct {
    Id int
    Name string
    // ... 생략
}

type User struct {
    UserFields // Nested Struct
}

type UserOpened struct {
    UserFields // Nested Struct
}
```

Struct가 Java의 클래스라 생각하면 된다.

`Nested Struct`를 이해하기 쉽게 한 단어로 표현하면, '필드 상속'이다.

메소드는 배제하고 모든 필드를 그대로 복사하는 것이다.

이전 글에서 사용했던 `Opened` 클래스는 도메인 객체가 변경될 때마다 `Opened` 클래스도 같이 필드를 변경하는 동기화 작업이 필요했지만,

이 방법을 사용할 수 있다면, 변경 지점이 줄어서 동기화 과정이 생략된다.

`Nested Struct`가 Java에서 지원된다고 가정하고 문법을 비슷하게 짜보면,

(실제 존재하는 문법이 아닌 가정)

```java
public class UserFields {
    private int id;
    private String name;
    private String password;
}

public class User {
    nested UserFields;
}

public class UserOpened {
    nested UserFields; // UserFields 클래스의 모든 필드를 갖게 됨

    // UserFields 내의 모든 property가 private이므로 getter는 따로 만들어줌
    public int getId();

    public String getName();

    public String getPassword();
}
```

이런 식으로 되지 않을까 싶다.

만약 nested class의 접근 제어자를 명시해주고 싶다면,

```java
public class UserFields {
    private int id;
    private String name;
    private String password;
}

public class User {
    // UserFields의 모든 필드를 private으로 복사
    private nested UserFields;
}

public class UserOpened {
    // UserFields의 모든 필드를 public으로 복사
    public nested UserFields;
}
```

이런 식으로 표현할 수 있을 것 같다.

`UserFields`에 존재하는 `password`는 보안 상 문제가 될 수 있는 중요한 필드라,

Dto로 아예 접근 시킬 일이 없어서 `UserOpened`에서도 포함시키지 않고 싶다면,

```java
// Dto로 사용할 필드들
public class UserFields {
    private int id;
    private String name;
}

// Dto에서 절대 사용 안 할 보안 상 민감한 필드들
public class UserSecureFields {
    private String password;
}

// 도메인 객체에서는 모두 포함
public class User {
    // UserFields의 모든 필드를 private으로 복사
    private nested UserFields;
    // UserSecureFields의 모든 필드를 private으로 복사
    private nested UserSecureFields;
}

// Dto에서 필드를 꺼내갈 객체에서는 민감한 데이터는 배제
public class UserOpened {
    // UserFields의 모든 필드를 public으로 복사
    public nested UserFields;
}
```

위와 같이 만들면 좀 더 안전하게 사용할 수 있을 것이다.

`nested`는 상속과 달리 메소드를 제외하고 오직 다른 클래스 내의 필드만 그대로 복사하는 개념이다.

그래서 `UserOpened`는 메소드를 일절 포함하지 않게 되고,

오직 데이터만 갖게 된다.

```java
public class User {
    private nested UserFields;
    private nested UserSecureFields;

    public UserOpened toOpened() {
        // ...
    }
}
```

위와 같은 문법을 지원한다면 최종적으로 도메인 객체의 캡슐화를 깨지 않도록

Dto로 변환이 필요할 때는 `toOpened`를 호출하자는 약속을 모든 팀원이 인지하고 지키고,

필드를 노출하지 않아서 복잡도를 줄일 수 있으며,

`Opened` 클래스에서도 Dto로 노출하면 결코 안 되는 민감한 필드는 배제할 수 있다.

서버의 구조를 역할에 따라 Controller, Service, Repository로 나누고,

Service 계층이 커지면 Domain으로 나눴듯이,

Domain이 커지고 Dto가 늘어남에 따라 Domain, Mapper, Opened, Dto로 분리하는 방법에 대해서 상상해봤다.

Java에 존재하는 방법은 아니고, Go에서도 Nested Struct를 포함시킬 때 접근 제어자의 범위를 조절할 수는 없기 때문에 실제로 활용하기 애매하다고 느껴지지만,

캡슐화를 최대한 깨지 않으면서 Dto로 변환도 가능케 할 방향성에 대해서 생각해 볼 기회를 가져서 시야가 조금 트인 것 같다.

존재하지 않는 문법을 상상해보니 마치 언어를 직접 만드는 기분이 들어서 재미도 있었다.

내친 김에 조금 더 문법을 편하게 만들 방법을 생각해봤다.

```java
public fields UserFields(
        int id,
        String name
);

public fields UserSecureFields(
        String password
);

public class User {
    private nested UserFields;
    private nested UserSecureFields;
}

public class UserOpened {
    public nested UserFields;
}
```

`fields` 키워드로 오직 필드만 가진 클래스를 정의하고,

`nested` 키워드로 `fields` 클래스를 '포함'시킬 수 있는 문법이 가능하지 않을까 생각해봤다.

`fields`는 `record`와 동일한 문법이라 Java를 하던 사람들에게 쉽게 느껴질 것이다.

이 방법의 단점은 이전과 동일하게 여전히 하나의 객체를 더 거쳐가기 때문에 성능 상 손실이 발생할 것이며,

만약 2개의 `fields` 클래스를 포함시켰는데, 동일한 필드명이 존재한다면?

```java
import java.time.LocalDateTime;

public fields BaseFields(
        int id, // 중복
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime
);

public fields UserFields(
        int id, // 중복
        String name
);

public class User {
    private nested BaseFields;
    private nested UserFields;
}
```

바로 위와 같은 상황에서 충돌이 발생할 것이다.

Go언어에서 위와 같은 상황에 어떻게 처리하나 살펴봤더니,

```go
type BaseFields struct {
    id int
    createdDateTime time.Time
    updatedDateTime time.Time
}

type UserFields struct {
    id int
    name string
}

type User struct {
    BaseFields
    UserFields
}


var user = User{
    // 코드 생략, Java 생성자와 같다 보면 됨
}

user.id // ambiguous selector user.id

user.BaseFields.id // OK

user.UserFields.id // OK
```

`user.id`를 선택하면 `ambiguous selector user.id`라는 메세지를 컴파일러가 띄워준다.

당연한 오류라고 생각한다.

두 구조체 모두 동일한 필드명을 가지고 있어서 어떤 필드를 말하는 것인지 알 수 없기 때문이다.

다중 상속에서 발생하는 문제와 비슷하다.

`user.BaseFields.id`, `user.UserFields.id`와 같이,

필드가 담긴 구조체 명을 중간에 찍어서 사용하면 정상적으로 실행된다.

이렇게 Java에 존재하지는 않는 문법이지만 만약 Java에 추가된다면 어떤 식으로 활용될 수 있을지 생각해보는 시간을 가졌으며,

차세대 Java인 Kotlin을 보면, 다른 언어에서 좋은 기능들을 흡수해서 아주 적절하게 Kotlin에 녹여내고 있다는 느낌을 받는데,

`friend` 키워드나 `nested struct`도 그냥 사용하면 위험할 수 있겠지만,

Kotlin처럼 '제약'을 잘 걸어서 적절한 용례로 사용되게 할 수 있다면 상당히 유용할 것 같다.

그런데 기능이 너무 많아지는 것도 문제고 한 번 추가된 기능을 나중에 뺀다는 것이 거의 불가능 하기 때문에 추가되진 않을 것 같다. .

# Dto, Domain의 변환 위치에 대해서

---

Lotto 미션도 저번달부터 연습 삼아 수차례 만들어 보았기 때문에 로직은 어느 정도 아는 상태였음.

똑같이 작성하면 의미가 없기 때문에 이번에는 어떤 식으로 고도화 시킬 수 있을지에 대해서 고민.

자세히 보면 입력 -> 출력, 입력 -> 출력이 2번 일어나며,

처음 입력으로 받았던 로또를 두번째 입출력을 처리할 때 사용하기 때문에,

처음 입력받은 로또들을 `Repository`에 저장하는 방법도 괜찮겠다는 생각이 들었음.

아직 JPA를 기초만 훑어본 상태이기 때문에 Java 진영에서 Repository를 제대로 운용하는 방법은 잘 모르지만,

어떤 웹 프레임워크를 사용하더라도 입문자들에게 가르치는 구조가 거의 항상 `Controller-Service-Repository`이기 때문에,

구조 잡는 것은 익숙한 상태였음.

Dto, Service, Domain 간의 관계도 미션을 진행하면서 조금씩 학습하여 대략적으로 파악이 된 상태였지만,

변환 계층 및 방법이 여러 가지라 실제로 현업에서는 어떤 방법이 사용되는지, 정석이 무엇인지까지는 알지 못해서

앞서 1년간 이런 부분들에 대해 수도없이 학습을 진행하며 익숙해졌을 우아한 테크코스 5기 기수들의 레포지토리에 답이 있을 것이라 생각하여, 이를 참고하며 구조를 베껴보기로 함.

일원화 되는 것이 아니라, 다양한 방법이 있었으며

모든 방법의 장단점에 대해 고민하며 코드를 작성해보고 내용 정리 후, 마음에 드는 방법을 사용해보기로 함.
  
---  

## 1. Dto에서 Domain 변환

1 ~ 2주차 미션을 진행하면서 사용한 방법이다.

최대한 getter를 지양하여 캡슐화를 깨뜨리지 않기 위해서 선택했었다.

```java  
public final class Car {

    private final String name;

    private int position;

    // 현재 Domain 객체를 Dto로 변환  
    public CarDto toDto() {
        return new CarDto(
                name,
                position
        );
    }
}  
```  

2주차 미션이었던 자동차 경주 게임의 도메인 객체, `Car`를 `CarDto`로 변환하는 로직이다.

`CarDto`는 자동차의 이름과 현재 위치를 저장하여 출력할 때 사용되는데,

사실상 `Car`과 데이터는 동일하지만, 비즈니스 로직이 존재하지 않으며 불변 객체라는 차이가 있다.

`Car`의 데이터를 빼서 `CarDto`를 만들기 때문에 `CarDto`를 만들기 위해 `Car`의 필드에 접근할 수 있어야 하는데,

`Car` 클래스 내부에서 `CarDto`를 만드는 로직을 작성하면, 필드를 노출할 필요가 없기 때문에 캡슐화가 전혀 훼손되지 않는다는 장점이 있다.

그러나 이 방법의 단점에 대해서 생각해보면 너무 많은 Dto 생성 로직이 Domain에 들어갈 가능성이 있다는 것이다.

예를 들어 `User`라는 도메인 객체가 있다고 생각해보자.

```java  
import java.time.LocalDate;

// User Domain Object  
public class User {

    // DB에 저장할 ID  
    private final int id;

    // 프로필 사진 주소  
    private final String profilePhotoUrl;

    // 로그인 ID  
    private final String username;

    // 닉네임  
    private final String nickname;

    // 실명  
    private final String name;

    // 이메일  
    private final String email;

    // 비밀번호  
    private final String password;

    // 나이  
    private final int age;

    // 성별  
    private final Gender gender;

    // 지역  
    private final Locale locale;

    // 생일  
    private final LocalDate birthDate;

    // 가입일  
    private final LocalDateTime createdDateTime;

    // 수정일  
    private final LocalDateTime updatedDateTime;

}  
```  

예시를 위해 조금 필드가 많아졌다.

`User`는 여러 Dto를 만들어낼 수 있다.

예를 들어, 로그인 아이디를 담는 `username`과 사용자의 별칭을 담는 `nickname` 두 개만 보여주고 싶을 경우가 존재하는데,

![[Dto, Domain의 변환 위치에 대해서-1.png]]

위처럼 대부분의 사이트에서 위와 비슷한 방식으로 간단한 프로필을 보여준다.

이 때 필요 없는 정보는 제하고 사용되는 정보만 담아서 보내주도록 Dto를 만들 수 있다.

```java  
public class UserProfileDto {
    // 프로필 사진  
    public final String profilePhotoUrl;

    // 닉네임  
    public final String nickname;

    // 이메일  
    public final String email;
}  
```  

이렇게 Dto는 원래 도메인 객체에서 필요한 정보만 필터링하여 데이터를 절약하면서 효율적으로 전송하는 이점이 있고,

보안 상 중요한 비밀번호 등의 필드를 제거하여 노출하지 않을 수 있다.

이 외에도 현재 예시에는 존재하지 않지만 주민번호, 카드번호 등의 정보가 존재한다면 Dto에선 필터링하고 안전하게 가려줄 수 있을 것이다.

이런 식으로 `User`에서 파생된 Dto가 여럿 생성되었다고 생각해보자.

```java  
// 프로필을 보여줄 때 사용  
public class UserProfileDto {
    // ...}  

    // 사용자 상세 정보 보여줄 때 사용  
    public class UserDetailDto {
        // ...}  

        // 이메일만 보여줄 때 사용  
        public class UserEmailDto {
            // ...}  

            // 이 외 간단한 사용자 정보 보여줄 때 사용  
            public class UserSimpleDto {
// ...}  

// 그 외 10개의 User에 관련된 Dto가 존재한다고 가정  
```  

이렇게 여러 개의 Dto가 존재하는데 변환 로직이 `User` 도메인 객체에 들어가게 된다면 어떻게 될까.

```java  
public class User {

    public UserProfileDto toUserProfileDto() {
        // ...  
    }

    public UserDetailDto toUserDetailDto() {
        // ...  
    }

    public UserEmailDto toUserEmailDto() {
        // ...  
    }

    public UserSimpleDto toUserSimpleDto() {
        // ...  
    }

    // ... 그 외 10개의 Dto 변환 로직 존재  

}  
```  

`User` 도메인 객체에 너무 많은 변환 로직이 들어간 것을 한 눈에 볼 수 있다.

변환 로직이 필드 및 비즈니스 로직보다도 더 많아진다면, 본말전도가 될 것이다.

정리하면 Domain 내의 Dto 변환 로직 작성은

필드를 노출할 필요가 없기 때문에 getter를 작성하지 않고 캡슐화를 지킬 수 있다는 장점이 있다.

단점은 Dto 종류가 많아질수록 도메인 객체에 변환 로직이 너무 많아져서

SRP를 지킬 수 없게 되며, 도메인 객체가 Dto에 의존하기 때문에 Dto가 변경되면 도메인 객체도 변경 되어야 한다.

이는 변경 지점을 늘리고 유지 보수를 어렵게 만드는 지점이 되어 코드의 복잡성을 늘릴 것이다.

또한 IDE에서 도메인 객체 내의 프로퍼티를 볼 때마다 불필요하게 여러 변환 메소드를 자동으로 보여줄 것이다.

  
---  

## 2. Dto에서 Domain 변환

1번 케이스와 완전히 반대되는 상황이라고 볼 수 있다.

```java  
public class UserProfileDto {
    public static UserProfileDto from(final User user) {
        // ...  
    }
}

public class UserDetailDto {
    public static UserDetailDto from(final User user) {
        // ...  
    }
}

public class UserEmailDto {
    public static UserEmailDto from(final User user) {
        // ...  
    }
}

public class UserSimpleDto {
    public static UserSimpleDto from(final User user) {
        // ...  
    }
}  
```  

각 Dto가 도메인 객체를 받아서 Dto 타입으로 변환 시켜주는 역할을 한다.

변환에 대한 책임이 각 Dto로 분산되었기 때문에,

Dto가 늘어나더라도 도메인 객체는 전혀 영향을 받지 않으며,

각 Dto가 요구 사항에 의해 변경 되더라도 변경 되어야 할 Dto만 건드리면 된다.

단점은 아까 봤던 것처럼, 별개의 Dto 클래스에서 도메인 객체의 데이터에 접근하기 위해서,

수많은 getter를 만들어서 캡슐화가 저해된다는 것이다.

```java  
import java.time.LocalDate;
import java.time.LocalDateTime;

// User Domain Object  
public class User {

    public int getId();

    public String getProfilePhotoUrl();

    public String getUsername();

    public String getNickname();

    public String getName();

    public int getAge();

    public Gender getGender();

    public Locale getLocale();

    public LocalDate getBirthDate();

    public LocalDateTime getCreatedDateTime();

    public LocalDateTime getUpdatedDateTime();

}  
```  

`User` 내에 변환 로직은 전혀 없지만 getter가 모조리 노출되었다.

그러나 수많은 Dto가 생기거나 변경되더라도 도메인 객체가 변경될 일은 없다.

도메인 객체에 없는 필드를 필요로 하지 않는 이상은.

두 방법 모두 트레이드 오프가 있는 것이다.
  
---  

## 3. Mapper 사용

도메인 객체는 비즈니스 로직 처리,

DTO는 데이터 전송 이라는 목적이 존재한다.

그런데 앞서 살펴봤던 두 방법은 모두,

'변환'이라는 다른 역할을 둘 중 하나에 추가적으로 부여했다.

'역할 분리' 관점에서 보면 하나의 객체에 한 가지 역할만 부여해야 하는 SRP가 위배된 것이다.

우아한 테크코스 5기 레포지토리를 참고해보니, '변환'이라는 역할을 `Mapper`라는 클래스에 위임하도록 만드는 경우가 있었다.

그저 역할을 다른 클래스로 분리한 것이기 때문에 어렵진 않았다.

```java  
public class UserMapper {
    public static UserProfileDto from(final User user) {
        // ...  
    }

    public static UserDetailDto from(final User user) {
        // ...  
    }

    public static UserEmailDto from(final User user) {
        // ...  
    }

    public static UserSimpleDto from(final User user) {
        // ...  
    }
}  
```  

위와 같이 `Mapper` 클래스에 변환 로직을 분리하기만 하면 된다.

좀 더 확실하게 분리하려면, `DTO -> 도메인 변환`, `도메인 -> DTO 변환`에 따른 2개의 `Mapper`를 만드는 것이 좋아 보인다.

그래야 변환 로직의 갯수가 늘어나도 방향을 헷갈릴 일이 없을 것이다.

```java  
public class UserToDtoMapper {
    // ...  
}

public class DtoToUserMapper {
    // ...  
}  
```  

이름을 잘 못 짓기 때문에 대략 의미 유추 정도만 되게 만들었는데,

대략 어떤 느낌인지가 바로 보일 것이다.

이런식으로 만들면 어떨까 싶다.

다만, 이것도 Dto가 너무 많아져서 100개라고 생각하면,

하나의 Mapper에서 100개의 변환 로직을 관리하는 것보다는

각 Dto에서 관리하는 것이 더 쉽지 않나 하는 생각도 든다.

그러나 그건 일반적인 경우는 아닌 것 같고, 변환 로직의 개수가 적다면 역할 분리가 명확하게 되고 유용하게 쓸 수 있을 것이다.

---  

# 4. 그 외 방법들

아직 기본 수준이기 때문에 지금은 위 3가지 중 하나만 사용해도 충분할 것 같지만,

그 외 방법들이 분명 있을 것이기 때문에 조금 더 생각해봤다.

## 4-1. Friend Class

이 방법은 Java에서는 불가하지만, `C++`에서 지원하는 방법이다.

```cpp  
class User {  
    // 필드 생략  
      
    // 이제 UserDto 클래스 내에서 User의 모든 멤버에 접근 가능.  
    friend class UserDto;   
}  
```  

`friend class`로 지정한 클래스는 해당 클래스의 모든 멤버에 접근이 가능해진다.

`User`의 `friend`가 `UserDto`가 되었기 때문에,

`UserDto`에서는 이제 `User`의 모든 필드에 getter 없이 접근할 수 있게 된 것이다.

```java  
public class UserDto {
    public static UserDto from(final User user) {
        return new UserDto(
                // UserDto에서 User의 필드에 직접 접근  
                user.id,
                user.name
                // ... 생략  
        );
    }
}   
```  

만약 Java에서 `friend`가 지원 되었다면, 위와 같이 작성할 수 있었을 것이다.

즉, `User`의 `friend` 클래스로 모든 Dto 클래스를 등록하게 된다면,

```cpp  
class User {  
    // 필드 생략  
      
    // 모든 Dto 클래스 내에서 User의 모든 멤버에 접근 가능.  
    friend class UserDto;  
    friend class UserProfileDto;  
    friend class UserDetailDto;  
    friend class UserEmailDto;  
    friend class UserSimpleDto;  
    // ... 생략  
}  
```  

Dto 변환 로직을 Dto 클래스 내에 넣으면서도 캡슐화를 조금 덜 깨뜨릴 수 있는 것이다.

Dto가 아닌 다른 클래스에서는 여전히 `User` 필드에 접근이 불가능하기 때문이다.

`friend`가 일반적으로 '안티 패턴'으로 인식되기 때문에 무분별한 사용을 지양해야 한다고 널리 알려져 있지만,

`friend`가 도메인, Dto 변환을 위해 사용된다고 명확한 목적을 알리고 작업자 간에 합의가 된다면 괜찮지 않을까 생각된다.

아이디어는 나쁘지 않다고 생각하지만, 이 방법은 Java에서는 사용할 수 없다는 것이 문제다.

생각해보면 Java에서도 비슷한 방법이 존재한다.

## 4-2. `default` 키워드를 이용한 필드 공유

보통 필드에 `private` 접근 제어자를 명시하지만, 아무 것도 명시하지 않으면 저절로 `default` 접근 권한을 갖는다.

`friend`는 접근 가능하게 만들 클래스를 명시했지만,

`default`는 '같은 패키지'로 범위가 한정된다.

그래서 같은 패키지 내에 Dto와 도메인 객체를 두면 `friend`와 비슷한 효과를 낼 수 있기는 한데...

과연 dto와 도메인 객체를 일반적으로 같은 패키지 내에 두는가 생각해보면 아닌 것 같다.

5기 레포지토리만 봐도 그렇다.

게다가 `default` 접근 제어자를 사용하는 것 자체가 드물 것이라고 생각하는데,

이러한 합의가 없다면 혼란을 일으킬 수 있을 것 같다.

대체 왜 `default` 접근 제어자를 사용했는지 같이 작업할 사람이 들어올 때마다 설명을 해야 할 것이다.

그래서 이 방법은 좋지 않다고 생각한다.

## 4-3. 도메인 클래스의 복제 클래스를 만드는 방법.

이 방법은 그냥 혼자 생각해 본 방법이기 때문에 실제로도 쓰이는 방법인지는 모르겠다.

아마 안 쓸 것 같기는 하지만 나름대로 머리를 굴려서 생각해 낸 방법이니 재미로 보면 좋을 것 같다.

```java  
public class User {
    private final int id;
    private final String name;
    // ... 나머지 필드 생략  

    public UserOpened toOpened() {
        return new UserOpened(
                id,
                name
                // ...  
        );
    }
}

// 복제 User  
public class UserOpened {
    public final int id;
    public final String name;
    // ... 나머지 필드 생략  
}  
```  

이름은 그냥 아무렇게나 지었다.

`User` 클래스의 복제판인 `UserOpened` 클래스를 만들어서,

`User`의 모든 필드를 `public`으로 만들었다.

`User` 내에서는 모든 필드를 `private`으로 유지하여 외부에서 접근할 수 없게 만든 다음,

Dto로 변환하고 싶으면 `User` 객체의 `toOpened` 메소드를 호출하여,

모든 필드가 열린 새로운 객체를 받는다.

그 다음 Dto로 변환하면 된다.

```java  
public class UserDto {
    // 도메인 -> Dto 변환 메소드를 각 Dto 내에 생성  
    public static UserDto from(final User user) {
        // 모든 필드가 private인 User의 필드에 접근 불가하므로,  
        // 모든 필드가 public인 UserOpened 클래스로 변환  
        final UserOpened userOpened = user.toOpened();

        // UserOpened에서 데이터를 꺼내서 사용할 수 있음.  
        return new UserDto(
                userOpened.id,
                userOpened.name
        );
    }
}  
```  

`User` 필드에 직접 접근하는 것이 아니라,

위와 같이 `UserOpened`로 변환해서 외부 접근하여 Dto로 변환 가능하게 되었다.

이러면 도메인 객체의 캡슐화도 지키면서 필요할 때, `toOpened`를 호출하여

외부에서도 `User`가 가지고 있던 데이터에 접근할 수 있게 된다.

장점은 이제 IDE에서 `user.`으로 필드 및 메소드 자동 완성을 해봐도 getter들이 보이지 않게 된다.

수많은 getter들이 오직 Dto만을 위해서 노출된다면 쓸 데 없이 정보량이 늘어나서 복잡도를 높일 것이다.

그리고 도메인 객체로 비즈니스 로직을 처리하는 도중에 getter에 임의로 접근해서 getter에 의존하게 되는 일이 줄어들 것이다.

반드시 모든 도메인 객체에 존재하는 `toOpened`는 Dto에서만 사용하라는 약속을 하면 될 것이기 때문이다.

그리고 `toOpened`는 도메인 객체가 모든 필드를 열 것이기 때문에,

Dto가 변경된다고 해서 같이 변경될 필요가 없다.

즉, Dto에 의존하지 않는다.

단점은 메모리와 성능을 괜히 더 먹게 된다는 것이며, 이 방법 역시 여러 사람이 함께 협업한다면

'규칙'을 정하고 `toOpened`를 마구 호출하지 말 것을 작업자 전원이 인지하는 추가적인 과정이 필요하다.

default 접근 제어자와 조금 다른 것은, toOpened 를 범용 용도가 아니라 반드시 Dto 변환을 위해서만 사용하자고 약속하면 된다는 것이다.

`default` 는 키워드부터가 그저 접근 제어자를 생략하는 것이 전부이기 때문에, 이걸 실수로 생략했는지, 다른 용도로 사용한 것인지, 필드를 같은 패키지 내의 Dto에서 접근하기 위해 사용한 것인지 ‘의도’를
파악하는 것이 그리 쉽지만은 않아 보인다.

그리고 마지막으로 도메인 객체의 필드를 복붙하는 개념이기 때문에,

도메인 객체가 변경될 때마다 동기화를 시켜줘야 한다.

도메인 객체 필드 변경 -> `Opened` 클래스 필드까지 변경해야 한다.

이렇게 여러 가지 방법과 개인적인 생각을 적어보았는데, 실제 현업에서는 어떤 방법이 권장되고 주로 사용되는지 궁금하다.

---

# 추가 내용

## 4.4. Nested Struct

이 방법은 Go언어에서 사용할 수 있는 방법인데, 언젠가 '상속'이 점점 퇴화하고

Java, Kotlin에 Heap이 아닌 Stack에 데이터가 쌓이는 Struct가 들어오는 날이 온다면

정말 먼 미래에 볼 수 있지 않을까 싶다.

그런 날이 오지 않을 수도 있겠지만,

```go
type UserFields struct {
    Id int
    Name string
    // ... 생략
}

type User struct {
    UserFields // Nested Struct
}

type UserOpened struct {
    UserFields // Nested Struct
}
```

Struct가 Java의 클래스라 생각하면 된다.

`Nested Struct`를 이해하기 쉽게 한 단어로 표현하면, '필드 상속'이다.

메소드는 배제하고 모든 필드를 그대로 복사하는 것이다.

이전 글에서 사용했던 `Opened` 클래스는 도메인 객체가 변경될 때마다 `Opened` 클래스도 같이 필드를 변경하는 동기화 작업이 필요했지만,

이 방법을 사용할 수 있다면, 변경 지점이 줄어서 동기화 과정이 생략된다.

`Nested Struct`가 Java에서 지원된다고 가정하고 문법을 비슷하게 짜보면,

(실제 존재하는 문법이 아닌 가정)

```java
public class UserFields {
    private int id;
    private String name;
    private String password;
}

public class User {
    nested UserFields;
}

public class UserOpened {
    nested UserFields; // UserFields 클래스의 모든 필드를 갖게 됨

    // UserFields 내의 모든 property가 private이므로 getter는 따로 만들어줌
    public int getId();

    public String getName();

    public String getPassword();
}
```

이런 식으로 되지 않을까 싶다.

만약 nested class의 접근 제어자를 명시해주고 싶다면,

```java
public class UserFields {
    private int id;
    private String name;
    private String password;
}

public class User {
    // UserFields의 모든 필드를 private으로 복사
    private nested UserFields;
}

public class UserOpened {
    // UserFields의 모든 필드를 public으로 복사
    public nested UserFields;
}
```

이런 식으로 표현할 수 있을 것 같다.

`UserFields`에 존재하는 `password`는 보안 상 문제가 될 수 있는 중요한 필드라,

Dto로 아예 접근 시킬 일이 없어서 `UserOpened`에서도 포함시키지 않고 싶다면,

```java
// Dto로 사용할 필드들
public class UserFields {
    private int id;
    private String name;
}

// Dto에서 절대 사용 안 할 보안 상 민감한 필드들
public class UserSecureFields {
    private String password;
}

// 도메인 객체에서는 모두 포함
public class User {
    // UserFields의 모든 필드를 private으로 복사
    private nested UserFields;
    // UserSecureFields의 모든 필드를 private으로 복사
    private nested UserSecureFields;
}

// Dto에서 필드를 꺼내갈 객체에서는 민감한 데이터는 배제
public class UserOpened {
    // UserFields의 모든 필드를 public으로 복사
    public nested UserFields;
}
```

위와 같이 만들면 좀 더 안전하게 사용할 수 있을 것이다.

`nested`는 상속과 달리 메소드를 제외하고 오직 다른 클래스 내의 필드만 그대로 복사하는 개념이다.

그래서 `UserOpened`는 메소드를 일절 포함하지 않게 되고,

오직 데이터만 갖게 된다.

```java
public class User {
    private nested UserFields;
    private nested UserSecureFields;

    public UserOpened toOpened() {
        // ...
    }
}
```

위와 같은 문법을 지원한다면 최종적으로 도메인 객체의 캡슐화를 깨지 않도록

Dto로 변환이 필요할 때는 `toOpened`를 호출하자는 약속을 모든 팀원이 인지하고 지키고,

필드를 노출하지 않아서 복잡도를 줄일 수 있으며,

`Opened` 클래스에서도 Dto로 노출하면 결코 안 되는 민감한 필드는 배제할 수 있다.

서버의 구조를 역할에 따라 Controller, Service, Repository로 나누고,

Service 계층이 커지면 Domain으로 나눴듯이,

Domain이 커지고 Dto가 늘어남에 따라 Domain, Mapper, Opened, Dto로 분리하는 방법에 대해서 상상해봤다.

Java에 존재하는 방법은 아니고, Go에서도 Nested Struct를 포함시킬 때 접근 제어자의 범위를 조절할 수는 없기 때문에 실제로 활용하기 애매하다고 느껴지지만,

캡슐화를 최대한 깨지 않으면서 Dto로 변환도 가능케 할 방향성에 대해서 생각해 볼 기회를 가져서 시야가 조금 트인 것 같다.

존재하지 않는 문법을 상상해보니 마치 언어를 직접 만드는 기분이 들어서 재미도 있었다.

내친 김에 조금 더 문법을 편하게 만들 방법을 생각해봤다.

```java
public fields UserFields(
        int id,
        String name
);

public fields UserSecureFields(
        String password
);

public class User {
    private nested UserFields;
    private nested UserSecureFields;
}

public class UserOpened {
    public nested UserFields;
}
```

`fields` 키워드로 오직 필드만 가진 클래스를 정의하고,

`nested` 키워드로 `fields` 클래스를 '포함'시킬 수 있는 문법이 가능하지 않을까 생각해봤다.

`fields`는 `record`와 동일한 문법이라 Java를 하던 사람들에게 쉽게 느껴질 것이다.

이 방법의 단점은 이전과 동일하게 여전히 하나의 객체를 더 거쳐가기 때문에 성능 상 손실이 발생할 것이며,

만약 2개의 `fields` 클래스를 포함시켰는데, 동일한 필드명이 존재한다면?

```java
import java.time.LocalDateTime;

public fields BaseFields(
        int id, // 중복
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime
);

public fields UserFields(
        int id, // 중복
        String name
);

public class User {
    private nested BaseFields;
    private nested UserFields;
}
```

바로 위와 같은 상황에서 충돌이 발생할 것이다.

Go언어에서 위와 같은 상황에 어떻게 처리하나 살펴봤더니,

```go
type BaseFields struct {
    id int
    createdDateTime time.Time
    updatedDateTime time.Time
}

type UserFields struct {
    id int
    name string
}

type User struct {
    BaseFields
    UserFields
}


var user = User{
    // 코드 생략, Java 생성자와 같다 보면 됨
}

user.id // ambiguous selector user.id

user.BaseFields.id // OK

user.UserFields.id // OK
```

`user.id`를 선택하면 `ambiguous selector user.id`라는 메세지를 컴파일러가 띄워준다.

당연한 오류라고 생각한다.

두 구조체 모두 동일한 필드명을 가지고 있어서 어떤 필드를 말하는 것인지 알 수 없기 때문이다.

다중 상속에서 발생하는 문제와 비슷하다.

`user.BaseFields.id`, `user.UserFields.id`와 같이,

필드가 담긴 구조체 명을 중간에 찍어서 사용하면 정상적으로 실행된다.

이렇게 Java에 존재하지는 않는 문법이지만 만약 Java에 추가된다면 어떤 식으로 활용될 수 있을지 생각해보는 시간을 가졌으며,

차세대 Java인 Kotlin을 보면, 다른 언어에서 좋은 기능들을 흡수해서 아주 적절하게 Kotlin에 녹여내고 있다는 느낌을 받는데,

`friend` 키워드나 `nested struct`도 그냥 사용하면 위험할 수 있겠지만,

Kotlin처럼 '제약'을 잘 걸어서 적절한 용례로 사용되게 할 수 있다면 상당히 유용할 것 같다.

그런데 기능이 너무 많아지는 것도 문제고 한 번 추가된 기능을 나중에 뺀다는 것이 거의 불가능 하기 때문에 추가되진 않을 것 같다. .

---

## 4-5. Sealed Class

클래스 앞에 `sealed`를 붙이면, 반드시 등록된 클래스만 상속이 가능해진다.

코드 예시를 보자.

```java
// User 클래스는 UserOpened만 상속 가능
public sealed class User permits UserOpened {

}

public class UserOpened extends User {

}
```

이제 `User` 클래스는 `UserOpened`에 의해서만 상속될 수 있다.

`Class is not allowed to extend sealed class from another package`


---

## 4-5. Sealed Class

클래스 앞에 `sealed`를 붙이면, 반드시 등록된 클래스만 상속이 가능해진다.

코드 예시를 보자.

```java
// User 클래스는 UserOpened만 상속 가능
public sealed class User permits UserOpened {

}

public class UserOpened extends User {

}
```

이제 `User` 클래스는 `UserOpened`에 의해서만 상속될 수 있다.

`Class is not allowed to extend sealed class from another package`

