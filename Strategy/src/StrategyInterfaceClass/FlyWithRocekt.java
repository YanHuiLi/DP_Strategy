package StrategyInterfaceClass;

import StrategyInterface.FlyBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class FlyWithRocekt implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我正在使用火箭飞天");
    }
}
