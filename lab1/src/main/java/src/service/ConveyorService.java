package src.service;

import src.constants.Constants;
import src.model.Number;
import src.model.Raw;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConveyorService {

    public static void start(List<List<Number>> listOfNumbers){
        List<Raw> raws = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_OF_BYTES; i++) {
            Raw instance = new Raw();
            raws.add(instance);
        }
        int counter=0;
        while(counter<Constants.NUMBER_OF_BYTES+listOfNumbers.size()-1){
            System.out.println("Tact " + (counter+1));
            if (counter < listOfNumbers.size()){
                Raw raw = new Raw();
                raw.setFree(false);
                raw.setRes(new Number());
                raw.setMultipliable(listOfNumbers.get(counter).get(0));
                raw.setMultiplier(listOfNumbers.get(counter).get(1));
                raw.setIndex(0);
                raws.add(0, raw);
            }
            else {
                raws.add(0, new Raw());
            }
            if (raws.get(raws.size()-1).isFree()){
                raws.remove(raws.size()-1);
            }

            counter++;
            printRaws(raws);
            System.out.println("Next?(y/n)");
            String flag = new Scanner(System.in).nextLine();
            if(!flag.equals("y")){
                break;
            }
        }
        System.out.println();
        printResult(raws);

    }

    private static void printRaws(List<Raw> raws){
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (Raw raw : raws) {
            executorService.execute(raw);
        }
        executorService.shutdown();
        for (int i =0; i< raws.size(); i++){
            if (i<Constants.NUMBER_OF_BYTES){
                System.out.println((i+1)+": "+raws.get(i));
            }
            else if (i<Constants.NUMBER_OF_BYTES+1) System.out.println("Result: "+raws.get(i));
        }
    }

    private static void printResult(List<Raw> raws){
        System.out.println("Results: ");
        for (int i=Constants.NUMBER_OF_BYTES-1;i<raws.size();i++){
            System.out.println(raws.get(i));
        }
    }


}
