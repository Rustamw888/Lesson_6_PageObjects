package qa.guru.docs;

import static qa.guru.utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Рандомное слово из 10 символов: " + getRandomString(10));
        System.out.println("Рандомное число в диапазоне от 1234 до 99999: " + getRandomInt(1234, 99999));
        System.out.println("Рандомный почтовый адрес: " + getRandomEmail());
    }
}
