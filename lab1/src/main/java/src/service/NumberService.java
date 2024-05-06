package src.service;

import src.model.Number;

public class NumberService {
    public static Number sum(Number n1, Number n2) {
        Number number1 = n1.clone();
        Number number2 = n2.clone();
        int length = Math.max(
                number1.getValueInBytes().length,
                number2.getValueInBytes().length
        );
        number1.resizeToRight(length);
        number2.resizeToRight(length);
        int[] sum = new int[length];
        int carry = 0;

        for (int i = length-1; i >= 0; i--) {
            int bitSum = number1.getValueInBytes()[i] + number2.getValueInBytes()[i] + carry;
            sum[i] = bitSum % 2;
            carry = bitSum / 2;
        }
        Number res = new Number();
        res.setValueInBytes(sum);
        return res;
    }

    public static Number turnLeft(Number number){
        Number temp = number.clone();
        int[] arr = temp.getValueInBytes();
        int temp1 = arr[0]; // Сохраняем первый элемент во временной переменной

        // Копируем часть массива, исключая первый элемент, в оставшуюся часть массива
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);

        arr[arr.length - 1] = temp1;

        temp.setValueInBytes(arr);
        return temp;

    }

}
