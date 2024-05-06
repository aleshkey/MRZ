/*
Лабораторная работа #1 по предмету "Методы решения задач в интеллектуальных системах"

Авторы:
    студенты гр. 121701
    Олешкевич А.С., Протас А.А.

Задание:
    (16) реализовать алгоритм вычисления произведения пары 8-разрядных чисел умножением со старших разрядов
         со сдвигом частичной суммы влево

Источники:
    (1) Интеграционная платформа
    (2) Качинский, М. В. Арифметические основы электронных вычислительных средств : учебно-метод. пособие
        / М. В. Качинский, В. Б. Клюс, А. Б. Давыдов. - Минск : БГУИР, 2014. - 64 с. : ил.
*/
/*
* 16-разрядное
* */
import src.model.Number;
import src.service.ConveyorService;
import src.service.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of raws");
        int number = sc.nextInt();
        List<List<Number>> allNums = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < number; i++ ) {
            String line = sc.nextLine();
            List<Number> numbers = InputService.enterNumber(line);
            allNums.add(numbers);
        }
        ConveyorService.start(allNums);

    }

}
