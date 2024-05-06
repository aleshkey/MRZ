package src.model;

import lombok.Data;
import src.constants.Constants;
import src.service.NumberService;

import java.util.Arrays;

@Data
public class Raw implements Runnable {

    private boolean isFree = true;
    private Number multipliable = new Number();
    private Number multiplier = new Number();
    private Number res = new Number();
    private int index = 0;
    private Number partialWork = new Number();


    @Override
    public String toString() {
        if (!isFree) {
            return "multipliable=" + multipliable +
                    ", multiplier=" + multiplier +
                    ", product="+partialWork+
                    ", sum=" + res;
        }
        return "multipliable=--------"+
                ", multiplier=--------" +
                ", product=--------"+
                ", sum=----------------";
    }

    private Number solveRow(Number n1, Number n2, Number res, int index){
        //res.resizeToLeft(res.getValueInBytes().length+1);
        res = NumberService.turnLeft(res);
        if (n2.getValueInBytes()[index]==1){
            partialWork = n1.clone();
            res = NumberService.sum(res, n1);
        }
        else partialWork = new Number();
        return res;
    }

    @Override
    public void run() {
        res.resizeToLeft(16);
        if (!isFree && index < Constants.NUMBER_OF_BYTES) {
            res = solveRow(multipliable, multiplier, res, index);
            index++;
        }
    }
}
