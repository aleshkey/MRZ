package src.model;

import lombok.Data;
import src.constants.Constants;

import java.util.Arrays;

@Data
public class Number implements Cloneable {
    int[] valueInBytes = new int[Constants.NUMBER_OF_BYTES];

    public long getDecimalValue(){
        long res = 0;
        for(int i = 0; i < valueInBytes.length; i++) {
            res += (long) (valueInBytes[i]*Math.pow(2, valueInBytes.length-i-1));
        }
        return res;
    }

    public void resizeToLeft(int numberOfBytes){
        valueInBytes = Arrays.copyOf(valueInBytes, numberOfBytes);
    }

    public void resizeToRight(int numberOfBytes){
        int zerosToAdd = numberOfBytes - valueInBytes.length;
        int[] resizedArray = new int[numberOfBytes];
        System.arraycopy(valueInBytes, 0, resizedArray, zerosToAdd, valueInBytes.length);
        valueInBytes = resizedArray;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i : valueInBytes){
            res.append(i);
        }
        res.append(" (").append(getDecimalValue()).append(")");
        return res.toString();
    }

    @Override
    public Number clone() {
        try {
            Number clone = (Number) super.clone();
            clone.valueInBytes = new int[valueInBytes.length];
            System.arraycopy(valueInBytes, 0, clone.valueInBytes, 0, valueInBytes.length);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
