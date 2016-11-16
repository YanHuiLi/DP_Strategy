package AbstractClass;

import StrategyInterface.FlyBehavior;
import StrategyInterface.QuackBehavior;
import StrategyInterfaceClass.FlyNoWay;
import StrategyInterfaceClass.MuteQuack;

/**
 * Created by Archer on 2016/11/16.
 */
public abstract class Duck {


    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
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








