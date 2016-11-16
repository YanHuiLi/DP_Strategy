package DuckClass;

import AbstractClass.Duck;
import StrategyInterfaceClass.FlyWithRocekt;
import StrategyInterfaceClass.QuckWithTools;

/**
 * Created by Archer on 2016/11/16.
 */
public class miniDuckSimulator {


    public static void main(String[] args) {
        Duck modeDuck= new ModeDuck();
        modeDuck.display();
//        modeDuck.swim();
        modeDuck.performFly();
        modeDuck.performQuack();


        modeDuck.setFlyBehavior(new FlyWithRocekt());
        modeDuck.performFly();

        modeDuck.setQuackBehavior(new QuckWithTools());
        modeDuck.performQuack();



    }
}
