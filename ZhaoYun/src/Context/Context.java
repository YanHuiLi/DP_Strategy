package Context;

import Interface.Strategy;

/**
 * Created by Archer on 2016/11/18.
 */
public class Context {

     private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything(){

        strategy.doSomething();

    }

}
