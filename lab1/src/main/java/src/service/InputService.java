package src.service;

import src.model.Number;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    public static List<Number> enterNumber(String input){
        String[] numbers = input.split(" ");
        List<Number> numbersList = new ArrayList<>();
        for (String number : numbers){
            numbersList.add(convert(number));
        }
        return numbersList;
    }

    private static Number convert(String numberInString){
        Number number = new Number();
        for (int i = 0; i < numberInString.length(); i++){
            if (numberInString.charAt(i)=='1'){
                number.getValueInBytes()[i]=1;
            }
        }
        return number;
    }

}
