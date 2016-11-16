package StrategyInterfaceClass;

import StrategyInterface.FlyBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" 我正在使用翅膀高飞");
    }
}
