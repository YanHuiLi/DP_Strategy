package StrategyInterfaceClass;

import StrategyInterface.QuackBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("实现鸭子的呱呱叫");
    }
}
