package qa.guru.docs;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("ru"));

        System.out.println(faker.aquaTeenHungerForce().character());
        System.out.println(faker.backToTheFuture().quote());
        System.out.println(faker.animal().name());
        System.out.println(faker.beer().style());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.internet().ipV4Address());
        System.out.println(faker.business().creditCardNumber());

        System.out.println(faker.address().fullAddress());
        Faker faker1 = new Faker(new Locale("ru"));
        System.out.println(faker1.address().fullAddress());

        Faker faker2 = new Faker(new Locale("hu"));
        System.out.println(faker2.address().fullAddress());

        Faker faker3 = new Faker(new Locale("en"));
        System.out.println(faker3.address().fullAddress());
    }
}
