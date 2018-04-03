#Dagger2 스터디 셈플

# Dagger2

`@Component`
```
의존성 주입이 될 타겟 interface 이거나 abstract class
interface, abstract class 에 의존성이 주입된 코드가 자동으로 작성된다
컴파일되면 Dagger{Component 이름} 으로 클래스가 생성되며, 예를들어 셈플에서는 DaggerStarComponent 가 생성 된다
```

`@Module`
```
주입할 객체를 설정한다
메서드에 @Provides 를 사용하여 리턴하는 객체가 주입되며
메서드에 파라메터가 존재하는경우 필요한 파라메터가 제공되도록 @Provides를 붙여 필요한 객체를 리턴하는 메서드를 만들어야한다
```

`@Provides`
```
객제 주입시 필요한 어노테이션
```
`@Inject`
```
멤버변수와 생성자에 어노테이션 할수 있으며 객체 주입한다
```

`@Binds`

`@IntoMap`

## 관계
```
Dagger <- Component -> Module
```

Dagger는 Component 에 코드를 생성한다

사용자는 Component 를 사용하여 객체를 주입한다

주입에 필요한 객체는 Module 로부터 얻는다

## SubComponent
```
Dagger <- Component -> Module
         SubComponent
```

SubComponent 는 상위 Component 와 상하위 관계를 맺을수있다

SubComponent 는 @Subcoponent.Builder interface 를 명시하여 객체를 생성할 수도 있다

Builder 로 객체가 생성되기 전에 파라미터 전달이 가능하다

SubComponent 는 Dagger{Component 이름} 으로 파일이 생성되지 않는다

Android 에서 `@SubComponent`
```
AppComponent 에서 에서 SubComponent 를 생성할수 있다
ex) 
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
```

`@Componet.Builder`

Component 객체를 생성할때 파라메터가 있는 Module 객체를 생성하여 사용할 수 있다

## Dagger 란
* 클래스를 쉽게 교환가능하다(모듈 교환)
* 재사용성

## Dagger 순서
1. @Inject 생성자의 파라메터 생성
2. 생성된 파라메터를 생성자에 전달하여 객체 생성
3. 주입될 클래스의 @Inject 가 달린 멤버변수에 생성된 객체 주입




##참고링크
https://cmcmcmcm.blog/2017/07/27/didependency-injection-%EC%99%80-dagger2/
https://cmcmcmcm.blog/2017/08/02/didependency-injection-%EC%99%80-dagger2-2/
http://eyeahs.github.io/designpatter/blog/2016/06/15/dagger-1/





# MovieGuide
[![BuddyBuild](https://dashboard.buddybuild.com/api/statusImage?appID=59100d0f7a93230001683759&branch=master&build=latest)](https://dashboard.buddybuild.com/apps/59100d0f7a93230001683759/build/latest?branch=master)

Android app that lists popular/highest-rated movies, shows trailers and reviews.

This app showcases the MVP pattern, RxJava, Dagger 2 and Uncle Bob Martin's Clean Architecture approach.
Optimized for tablets.

Add your themoviedb.org API key in the `local.properties` file:
```
tmdb_api_key=YOUR_API_KEY
```

Check out the Kotlin version [here](https://github.com/esoxjem/MovieGuide-Kotlin)

![Screenshot](http://i.imgur.com/72PypXCm.png) 
![screenshot2](http://imgur.com/I96Eka6m.png)
![screenshot3](http://imgur.com/4qHZcejm.png)
![screenshot4](http://imgur.com/m7J8HzUm.png)
![screenshot5](http://imgur.com/PwtjZHKm.png)
![screenshot6](http://imgur.com/kNHjCXSm.png)

## License
```
MIT License

Copyright (c) 2017 Arun Sasidharan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
