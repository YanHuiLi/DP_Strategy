package Client;

import ConcreteStrategy.ConcreteStrategy1;
import ConcreteStrategy.ConcreteStrategy2;
import Context.Context;
import Interface.Strategy;

/**
 * Created by Archer on 2016/11/18.
 */
public class Client {

    public static void main(String[] args) {
         Strategy strategy=new ConcreteStrategy2();
        Context  abc=new Context(strategy);
        abc.doAnything();
    }



}
