package StrategyInterfaceClass;

import StrategyInterface.FlyBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞哦");
    }
}
