package StrategyInterfaceClass;

import StrategyInterface.QuackBehavior;

/**
 * Created by Archer on 2016/11/16.
 */
public class QuckWithTools implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我正在使用虚拟的发声器");
    }
}
