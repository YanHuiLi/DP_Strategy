# 策略模式

策略模式定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。


# 模拟鸭子的例子。

现在公司的需求是生产一批鸭子。有绿头鸭子，红头鸭子，橡皮鸭子，诱饵鸭。

分析一下我们的项目，我们可以设计一个抽象类的鸭子来让所有鸭子都继承，但是很明显，这样子的做法是很不合理，并且一旦有新的需求加进来，修改的代码量太大，而且不易修改。

仔细分析了以后，会发现，上面的鸭子，飞行的方式不一样和发出声音的方式不一样。因此我们可以抽取飞行和发出声音这两个形式作为两个策略，这就轮到我们的策略模式上场了。

 ![DuckStrategy](http://ogtmd8elu.bkt.clouddn.com/DuckStrategy-min.png)

当有新的需求叫进来以后，我们利用接口引用，建立新的算法族或者原有的算法，这样完成了程序的解耦，废话不多说了，直接上代码。

## 抽象duck类

```
/**
 * 
 * Created by Archer on 2016/11/16.
 */
public abstract class Duck {



    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }



    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

      protected FlyBehavior flyBehavior;  //在不加protected的情况下，默认是private，子类无法使用
     protected   QuackBehavior quackBehavior;


    public void swim() {

        System.out.println("不管是什么鸭子，总会是游泳的");

    }

    public abstract void display();


    public void performQuack() {
        quackBehavior.quack();
    }


    public  void performFly(){
        flyBehavior.fly();
    }

}

```

可以看到的是duck这个抽象类，里面有两个接口类型的声明变量，这就是我们所说的两个策略，我们通过接口引用变量的方式，将两个策略独立的封装起来，当我们需要调用的时候，直接面向接口编程，通过已经实现接口的类（我们的策略），来向客户类（鸭子），提供策略，解决问题（即调用performQuack和performFly方法），然后委托给实现接口的类去完成业务逻辑。



在这复习一下继承的知识，由于所有鸭子都会游泳，因此swim方法是有所有鸭子的继承的，这也少些了很多代码，在里面定义了一个display的抽象方法，是因为每一只鸭子的外观都是不一样的，所以要求实现的子类里面都要重写display方法。接口引用变量默认应该是private的设置，只有设置为protected的类型，才能被子类使用，不然会报空指针异常。

## 飞行接口（策略一）

```
/**
 * Created by Archer on 2016/11/16.
 */
 public  interface  FlyBehavior {

    void  fly();


}
```



## 叫声接口（策略二）

```
/**
 * Created by Archer on 2016/11/16.
 */
public interface QuackBehavior {

    void quack();

}
```

## 实现飞行接口的类

```
/**
 * Created by Archer on 2016/11/16.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞哦");
        //业务逻辑
    }
}
```

 

```
/**
 * Created by Archer on 2016/11/16.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" 我正在使用翅膀高飞");
    }
}
```



```
/**
 * Created by Archer on 2016/11/16.
 */
public class FlyWithRocekt implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我正在使用火箭飞天");
    }
}
```

## 实现叫声的类

```
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫哦");
    }
}
```

```
/**
 * Created by Archer on 2016/11/16.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("实现鸭子的呱呱叫");
    }
}
```

```
/**
 * Created by Archer on 2016/11/16.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("实现吱吱叫");
    }
}
```

```
/**
 * Created by Archer on 2016/11/16.
 */
public class QuckWithTools implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我正在使用虚拟的发声器");
    }
}
```

## 实例化一只模型鸭

```
/**
 * Created by Archer on 2016/11/16.
 */

class ModeDuck  extends Duck{
    ModeDuck() {
        flyBehavior =new FlyNoWay();
        quackBehavior=new MuteQuack();
    }
    @Override
    public void display() {
        System.out.println("我是模型鸭子");
    }
}
```

在这只模型鸭子中，我们在构造器中，初始化了飞行和叫声的实例化，直接指定为 “不会叫”和“无法飞翔”。

## 模拟鸭子的场景

```
public class miniDuckSimulator {


    public static void main(String[] args) {
        Duck modeDuck= new ModeDuck();
        modeDuck.display();
//        modeDuck.swim();
        modeDuck.performFly();
        modeDuck.performQuack();


        modeDuck.setFlyBehavior(new FlyWithRocekt());
        modeDuck.performFly();

        modeDuck.setQuackBehavior(new QuckWithTools());
        modeDuck.performQuack();
    }
}
```

是时候生产一只模型鸭子了，注意我们采用的是针对接口或者抽象类编程，而不是针对实现编程，这样子的做法利用了java的多态性，因此只要是实现或者继承了这个接口或者抽象类的子类产生的对象，都可以指定给这个变量。

当我们有个新的需求是要让模型鸭子飞起来和叫出声音来的时候，我们直接调用setFlyBehavior，setQuackBehavior的方法，只要求传入一个实现了对应接口的对象，即可实现相应的功能而不影响其他类。这就是策略模式。

效果：

 ![duck运行结果-min](http://ogtmd8elu.bkt.clouddn.com/duck-min.PNG)



# 策略模式的优点



* 算法可以自由切换
* 避免使用多重条件判断
* 扩展性良好

# 策略模式缺点

* 策略类数量增多
* 所有策略类都需要对外暴露

# 策略模式的使用场景

1. 多个类只有在算法或者行为上稍有不同的场景
2. 算法需要自由切换的场景
3. 需要屏蔽算法规则的场景

# 主要参考资料
《HeadFirst设计模式》
《设计模式之禅》



