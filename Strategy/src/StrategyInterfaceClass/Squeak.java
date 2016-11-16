package StrategyInterfaceClass;

import StrategyInterface.QuackBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("实现吱吱叫");
    }
}
