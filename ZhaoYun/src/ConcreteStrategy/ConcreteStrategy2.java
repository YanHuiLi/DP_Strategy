package ConcreteStrategy;

import Interface.Strategy;

/**
 * Created by Archer on 2016/11/18.
 */
public class ConcreteStrategy2 implements Strategy{
    @Override
    public void doSomething() {

        System.out.println("doSomething2!");
    }
}
